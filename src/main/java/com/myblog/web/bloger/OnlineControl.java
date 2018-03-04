package com.myblog.web.bloger;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/online")
public class OnlineControl {
	@Autowired
	private SessionDAO sessionDAO;
	/*获取当前是否有用户登录*/
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
		System.out.println(sessions);
	/*System.out.println(stats);
	removeSession("10001");*/
		return stats;
	}
	
	public void removeSession(String loginName){
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		System.out.println("sessions"+sessions);
		for(Session session:sessions){
			if(loginName.equals((session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).toString())){
			session.setTimeout(0);//设置session立即失效，即将其踢出系统
			
			break;
			}

			}
		
	}
}
