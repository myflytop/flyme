package com.myblog.web.filter;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.myblog.util.CusAccessObjectUtil;
import com.myblog.util.ReturnUtils;
import com.myblog.util.WebRecordUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-18
 * <p>Version: 1.0
 */
public class KickoutSessionControlFilter extends AccessControlFilter {
    
    static String kickoutUrl; //踢出后到的地址
    public static String getKickoutUrl() {
		return kickoutUrl;
	}

	public static void setKickoutUrl(String kickoutUrl) {
		KickoutSessionControlFilter.kickoutUrl = kickoutUrl;
	}

	private boolean kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private int maxSession = 1; //同一个帐号最大会话数 默认1
    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

   

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.err.println("KickoutSessionControlFilter");
        
    	Subject subject = getSubject(request, response);
    	//如果没有登录，直接进行之后的流程
        if(!subject.isAuthenticated() && !subject.isRemembered()) {  
            return true;
        }
         
        /*用户已经认证往下走*/
        
        Session session = subject.getSession();
        //获取认证用户
        String username = String.valueOf( subject.getPrincipal());
        //获取认证用户
        Serializable sessionId = session.getId();
        

        //TODO 会先从第一个cacheManager中查找有没有cacheName的cache，如果没有接着查找第二个，如果最后找不到，因为fallbackToNoOpCache=true，那么将返回一个NOP的Cache否则返回null。
        Deque<Serializable> deque = cache.get(username);
        if(deque == null) {
            deque = new LinkedList<Serializable>();
            cache.put(username, deque);
        }

        //如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if(!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            deque.push(sessionId);
        }

        //如果队列里的sessionId数超出最大会话数，开始踢人
        while(deque.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if(kickoutAfter) { //如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } else { //否则踢出前者
                kickoutSessionId = deque.removeLast();
            }
            try {
                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                if(kickoutSession != null) {
                    //设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                }
            } catch (Exception e) {//ignore exception
            }
        }
          
        //如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            //会话被踢出了
            try {
                subject.logout();
                saveRequest(request);
                if(CusAccessObjectUtil.isAjax((HttpServletRequest)request)) {
                    response.setCharacterEncoding("UTF-8");
         	        response.setContentType("text/html; charset=UTF-8");
         	        PrintWriter pw = response.getWriter();
         	        pw.write(ReturnUtils.basicReturn(-2, "你已经被踢出", null));
         	        pw.flush();
         	        pw.close();
                }
                else {
                    
                	request.setAttribute("msg", ReturnUtils.normlExcptionReturn(-2, "你已经在远方登陆",null, "异地登陆"));
    				request.getRequestDispatcher(kickoutUrl).forward(request, response);
                }
            } catch (Exception e) { //ignore
            }
            
            return false;
        }
        //用户没有登陆，用户仅一个登陆
        if(true)
        {   WebRecordUtils.getAgent((HttpServletRequest)request,Integer.valueOf(username));
        }
     
        return true;
    }
}
