package com.myblog.util;

import java.util.Collection;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 仅一个用户登录
 * @author Administrator
 *
 */
public class OnlyUserUtils {
	  @Autowired
      public static SessionDAO sessionDAO;
	  /**
	   * 获取登录的用户
	   * @return
	   */
	  public static Object UserLogin() {
		  Collection<Session> sessions = sessionDAO.getActiveSessions();
			for(Session session:sessions){
				System.out.println("登录ip:"+session.getHost());
				System.out.println(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
				System.out.println("登录用户"+session.getAttribute(("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString()));
				System.out.println("最后操作日期:"+session.getLastAccessTime());
				}
			System.out.println(sessions);
		  return true;
	  }
	  public static int removeSession(String loginName){
			Collection<Session> sessions = sessionDAO.getActiveSessions();
			System.out.println("sessions"+sessions);
			for(Session session:sessions){
				if(loginName.equals((session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)).toString())){
				session.setTimeout(0);//设置session立即失效，即将其踢出系统
				
				break;
				}

				}
			return 1;
		}
}
