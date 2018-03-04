 package com.myblog.web.bloger;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myblog.realm.AdminRealm;
import com.myblog.shiro.CustomizedToken;
import com.myblog.shiro.LoginType;
@Controller
@RequestMapping("/blogerlogin")
public class BlogerloginControl {
	@Autowired
	private AdminRealm adminRealm;
	@Autowired
	private SessionDAO sessionDAO;
	private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();
	@RequestMapping("/login.do")
	public String login(@RequestParam("bloger_id")int bloger_id,@RequestParam("bloger_pas")String bloger_pas) {
		/*就是代表当前的用户。*/
		Subject currentUser = SecurityUtils.getSubject();
		
		//得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		 CustomizedToken token = new CustomizedToken(Integer.toString(bloger_id), bloger_pas,ADMIN_LOGIN_TYPE);
		//当前浏览器已经有用户已经认证
		if (currentUser.isAuthenticated()) {
			//退出当前浏览器存在的用户
			System.err.println("currentUser"+currentUser.getPrincipals());
			adminRealm.claenCached();
			
			currentUser.logout();	
			
		}
		try {
			currentUser.getSession().setAttribute("loginType", ADMIN_LOGIN_TYPE);
			currentUser.login(token);	
			System.err.println("登录成功: " );
		} catch (AuthenticationException ae) {
			// TODO: handle exception
			System.out.println("登录失败: " + ae.getMessage());
		}
		
		return "redirect:/bloger.jsp";
	}
	@RequestMapping("/getStatus.do")
	public Object getStatus() {
		/*获取认证用户集合，已经登录*/
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		for(Session session:sessions){
			System.out.println("登录ip:"+session.getHost());
			System.out.println(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			System.out.println("登录用户"+session.getAttribute(("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString()));
			System.out.println("最后操作日期:"+session.getLastAccessTime());
			}
		Object stats="";
		/*就是代表当前的用户。*/
		Subject currentUser = SecurityUtils.getSubject();
		//当前用户已经认证
		if (currentUser.isAuthenticated()) {	
		stats=currentUser.getPrincipal();
		
		}
	System.out.println(stats);
	removeSession("10001");
		return stats;
	}
	
	public void removeSession(String loginName){
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		System.out.println("sessions"+sessions);
		for(Session session:sessions){
			if(
			loginName.equals((session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).toString())){
			session.setTimeout(0);//设置session立即失效，即将其踢出系统
			
			break;
			}

			}
		
	}
	
	
}
