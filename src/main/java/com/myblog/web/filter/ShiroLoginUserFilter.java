package com.myblog.web.filter;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;

import com.myblog.shiro.LoginType;
import com.myblog.util.ReturnUtils;

/**
 * 扩展AdviceFilter，用于ajax访问接口未管理员登录的处理
 * 
 * @author Administrator
 *
 */
public class ShiroLoginUserFilter extends AdviceFilter {
	private static final String USER_LOGIN_TYPE = LoginType.ADMIN.toString();

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		System.err.println("ShiroLoginUserFilter");
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpServletResponse hresponse = (HttpServletResponse) response;
		Subject currentUser = SecurityUtils.getSubject();
		Object principal = currentUser.getPrincipal();
		boolean getu = USER_LOGIN_TYPE.equals((String)currentUser.getSession().getAttribute("loginType"));
		if ((hrequest.getHeader("accept").indexOf("application/json") > -1
				|| (hrequest.getHeader("X-Requested-With") != null
						&& hrequest.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
			if (principal == null||getu) {
				try {
					hresponse.setCharacterEncoding("UTF-8");
					hresponse.setContentType("text/html; charset=UTF-8");
					PrintWriter pw = response.getWriter();
					pw.write(ReturnUtils.basicReturn(-1, "用户未登录", null));
					pw.flush();
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}

		} else {
			
			if (principal ==null||getu) {
				System.out.println(hrequest.getContextPath()+"/WEB-INF/err/errUnPowerNew.jsp");
				request.setAttribute("msg", ReturnUtils.normlExcptionReturn(-1, "用户未登录或者登陆过期",null, "用户未登录"));
				request.getRequestDispatcher("/WEB-INF/err/errUnPowerNew.jsp").forward(request, response);
				return false;
			}

		}

		return true;

	}

}
