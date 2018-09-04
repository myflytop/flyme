package com.myblog.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.mgt.eis.SessionDAO;

import com.myblog.entity.Blog_web_record;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;

/**
 * 记录用户浏览相关操作
 * @author Administrator
 *
 */
public class WebRecordUtils {
	
    public static Blog_web_record getAgent(HttpServletRequest request,int user_id) {
    	Blog_web_record bl=new Blog_web_record();
    	        //获取浏览器信息
    			String ua = request.getHeader("User-Agent");
    			//转成UserAgent对象
    			UserAgent userAgent = UserAgent.parseUserAgentString(ua);
    			//获取浏览器信息
    			Browser browser = userAgent.getBrowser();  
    			//获取系统信息
    			OperatingSystem os = userAgent.getOperatingSystem();
    			//系统名称
    			String system = os.getName();
    			bl.setRecord_dervice(system);
    			//浏览器名称
    			String browserName = browser.getName();
    			bl.setRecord_brow(browserName);
    			bl.setRecord_ip(CusAccessObjectUtil.getIpAddress(request));
    			bl.setRecord_user(String.valueOf(user_id));
    	 
    	System.err.println(bl);
    	return bl;
    }
}
