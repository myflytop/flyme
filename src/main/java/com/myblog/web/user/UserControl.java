package com.myblog.web.user;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myblog.dto.user.UserBasic;
import com.myblog.entity.User;
import com.myblog.service.user.IUserService;
import com.myblog.shiro.CustomizedToken;
import com.myblog.shiro.LoginType;
import com.myblog.util.BasicUtil;
import com.myblog.util.CusAccessObjectUtil;
import com.myblog.util.MailUtil;
import com.myblog.util.ReturnUtils;
import com.myblog.util.WebRecordUtils;

import net.sf.json.JSONObject;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;

@Controller
@RequestMapping("/user")
public class UserControl {
	private static final String USER_LOGIN_TYPE = LoginType.USER.toString();
	@Autowired
	private MailUtil mailutil;
	@Resource(name = "userService")
	private IUserService userService;
	@Autowired
    private SessionDAO sessionDAO;
	public MailUtil getMailutil() {
		return mailutil;
	}

	public void setMailutil(MailUtil mailutil) {
		this.mailutil = mailutil;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/reg/getCode.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getCode(@RequestParam("user_mail") String user_mail, HttpSession session) {
		System.out.println(user_mail);
		String send = "";
		// 邮箱是否可用
		if (BasicUtil.isEmail(user_mail)) {
			// 判断邮箱是否注册
			if (userService.countMail(user_mail) == 0) {
				// 发送验证码，并判断是否发送成功
				// 成功写入session,并返回成功i
				int code = BasicUtil.creCode();
				session.setAttribute("mail", user_mail);
				session.setAttribute("mailcode", code);
				mailutil.send(user_mail, "你的验证码", "你的验证码为：" + code);
				send = "sendSuccess";
			} else {
				send = "sendFail";
			}
		}

		else {
			send = "sendFail";
		}

		return send;
	}

	@RequestMapping(value = "/reg/eqCode.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String eqCode(@RequestParam("user_mail") String user_mail, @RequestParam("code") int code,
			HttpSession session) {
		String sendcode = "";
		// 邮箱是否可用
		if (BasicUtil.isEmail(user_mail)) {
			// 判断邮箱是否注册
			if (userService.countMail(user_mail) == 0) {
				// 读取session,并返回成功i
				// 比对验证码
				String mail = (String) session.getAttribute("mail");
				int secode = (int) session.getAttribute("mailcode");
				if (user_mail.equals(mail) && secode == code) {
					sendcode = "codeOK";
				}

			} else {
				sendcode = "codeFail";
			}
		}

		else {
			sendcode = "codeFail";
		}
		return sendcode;
	}

	@RequestMapping(value = "/reg/regUser.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String regUser(@RequestParam("user_mail") String user_mail,
			@RequestParam("user_pas") String user_pas, @RequestParam("code") int code, HttpServletRequest request) {
		String reg = "";
		HttpSession session = request.getSession();
		// 邮箱是否可用
		if (BasicUtil.isEmail(user_mail)) {
			// 判断邮箱是否注册
			if (userService.countMail(user_mail) == 0) {
				// 读取session,并返回成功i
				// 比对验证码
				String mail = (String) session.getAttribute("mail");
				int secode = (int) session.getAttribute("mailcode");
				System.out.println(mail + secode);
				if (user_mail.equals(mail) && secode == code && BasicUtil.boolPas(user_pas)) {
					userService.addUser(new User(user_mail, CusAccessObjectUtil.getIpAddress(request),
							BasicUtil.encryptPsa(user_pas, user_mail).toString()));
					reg = "regOK";
				}

			} else {
				reg = "regFail";
			}
		}

		else {
			reg = "regFail";
		}
		return reg;
	}

	@RequestMapping(value = "/login/loginUser.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String loginUser(@RequestParam("user_loginpas") String user_pas,
			@RequestParam("user_parm") String user_parm, HttpServletRequest request) {
		String re;
		// 得到当前正在执行的主题
		Subject currentUser = SecurityUtils.getSubject();
		// 如果存在则覆盖
		if (currentUser.isAuthenticated()) {
			// 退出当前浏览器存在的认证用户
			currentUser.logout();
		}

		CustomizedToken customizedToken = new CustomizedToken(user_parm, user_pas, USER_LOGIN_TYPE);
		customizedToken.setRememberMe(false);
		try {
			currentUser.getSession().setAttribute("loginType", USER_LOGIN_TYPE);
			// 执行登陆
			currentUser.login(customizedToken);
			userService.adduser_recordlogin(WebRecordUtils.getAgent(request, getUser()));
			/*removeSession(String.valueOf(currentUser.getPrincipal()));*/
			re = ReturnUtils.basicReturn(0, "loginSuccess", currentUser.getPrincipal());

		} catch (IncorrectCredentialsException ice) {
			re = ReturnUtils.basicReturn(0, "loginFail", ice.getMessage());
			System.out.println("邮箱/密码不匹配！");
		} catch (AuthenticationException ae) {
			re = ReturnUtils.basicReturn(0, "loginFail", ae.getMessage());
			System.out.println(ae.getMessage());
		}

		return re;
	}

	@RequestMapping(value = "/login/logoutUser.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String logoutUser(@RequestParam("user_id") String user_id) {
		String re;
		// 得到当前正在执行的主题
		Subject currentUser = SecurityUtils.getSubject();
		// 如果存在则覆盖

		if (currentUser.isAuthenticated()) {
			// 退出当前浏览器存在的认证用户
			String cid = currentUser.getPrincipal().toString();
			if (cid.equals(user_id)) {
				currentUser.logout();
				re = ReturnUtils.basicReturn(0, "outSuccesss", user_id);

			} else {// 登陆不一样
				re = ReturnUtils.basicReturn(0, "unlike", user_id);

			}
		} else {
			re = ReturnUtils.basicReturn(0, "unlogin", user_id);

		}
		return re;
	}

	@RequestMapping(value = "/personal/upUserHeard.do", produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	public @ResponseBody String upUserHeard(@RequestParam("user_id") int user_id,@RequestParam("user_img") MultipartFile user_img, HttpServletRequest request) throws IOException {
		{  JSONObject jsonObject = new JSONObject();
			String fileName="";
			if(getUser()==user_id) {
			if (user_img !=null &&!user_img.isEmpty()&&user_img.getSize()<524288) {
				try {
					String imgname=user_img.getOriginalFilename();
					StringBuilder fileo=new StringBuilder();
					/*fileo.append(user_id).append(".").append(user_img.getOriginalFilename().split("\\.")[1]);*/
					fileo.append("user").append("-").append(user_id).append(".").append(imgname.substring(imgname.lastIndexOf(".") + 1).    
					        trim().toLowerCase());
					fileName=fileo.toString();
				  
					String realPath = request.getSession().getServletContext().getRealPath("/img/user");
					FileUtils.copyInputStreamToFile(user_img.getInputStream(),
							new File(realPath, fileName));
					System.out.println(realPath);
					StringBuilder user_imgurl = new StringBuilder(request.getContextPath());
					user_imgurl.append("/img/user/").append(fileName);
					jsonObject.put("data", userService.upUserHeard(user_id, user_imgurl.toString()));
					jsonObject.put("msg", 200);
					jsonObject.put("code", 1);
				} catch (IOException e) {
					jsonObject.put("msg", 200);
					jsonObject.put("code", -1);
					jsonObject.put("data", "");
					e.printStackTrace();
				}
			}
			}
			else
			{jsonObject.put("msg", 200);
			jsonObject.put("code", -1);
			jsonObject.put("data", "登陆不符合");}
			
			return jsonObject.toString();
		}
	}
	@RequestMapping(value = "/personal/getBasicUser.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getBasicUser(@RequestParam("user_id") int user_id) {
		String re=ReturnUtils.basicReturn(0, "登陆不符", null);
		if(user_id==getUser())
		{
			re=ReturnUtils.basicReturn(1, "获取成功", userService.getUserBasic(user_id));
		}
		return re;
	}
	
	@RequestMapping(value = "/personal/upUser.do", produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	public @ResponseBody String upUser(@ModelAttribute("UserBasic")UserBasic userBasic)
	{   String re=ReturnUtils.basicReturn(0, "修改失败",null);
	    System.err.println(userBasic);
		if(userBasic.getUser_id()==getUser())
		{
		if(userService.upUser(userBasic)==1)
		{
		re=ReturnUtils.basicReturn(1, "修改成功",userService.getUserBasic(getUser()));
		}
		}
		else {
		re=ReturnUtils.basicReturn(0, "登陆不符",null);
		}
		return re;
	}
	/**
	 * 获取登录用户
	 * @return
	 */
	@RequestMapping(value = "/basic/getuserbool.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getuserbool(HttpServletRequest request)  {
		int user_id=getUser();
		WebRecordUtils.getAgent(request, user_id);
		if(user_id==-1)
		{ 
			return ReturnUtils.basicReturn(-1, "用户未登录", null);
		}
		return ReturnUtils.basicReturn(1, "用户已经登录", user_id);
	}
	private Integer getUser() {
		Subject currentUser = SecurityUtils.getSubject();
		Object gObject=currentUser.getPrincipal();
	    Integer principal=null;
	    if (gObject==null||"".equals(gObject.toString())) {
			principal=null;
		}
	    else {
			principal=Integer.valueOf(gObject.toString());
		}
		boolean getu = USER_LOGIN_TYPE.equals((String)currentUser.getSession().getAttribute("loginType"));
		
		if (principal==null||!getu) {
			principal=-1;
		}
		return principal;
	}
	private void removeSession(String loginName){
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		System.out.println("sessions"+sessions);
		int i=0;
		for(Session session:sessions){
			if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null) {
				if(loginName.equals((session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).toString())){
					System.out.println("登录ip:"+session.getHost());
					
					System.out.println("登录ip:"+session.getId());
					System.out.println(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
					System.out.println("登录用户"+session.getAttribute(("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString()));
					System.out.println("最后操作日期:"+session.getLastAccessTime());
					i++;
					if(i==2) {
						session.setTimeout(0);
						break;
					}
					
					}
			}
			

		}
	}
}
