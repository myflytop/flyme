package com.myblog.servletListen;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.myblog.util.BasicUtil;

public class ServletStartListen implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext servletContext = arg0.getServletContext();
		servletContext.setAttribute("startTime", BasicUtil.getTime());
	}

	

}
