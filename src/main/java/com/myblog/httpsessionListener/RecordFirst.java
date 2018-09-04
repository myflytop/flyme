package com.myblog.httpsessionListener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;


public class RecordFirst implements SessionListener{

	@Override
	public void onStart(Session session) {//会话创建触发 已进入shiro的过滤连就触发这个方法
		// TODO Auto-generated method stub
		System.out.println("会话创建：" + session.getId());	
		System.out.println("请求ip:"+session.getHost());
		System.out.println("id:"+session.getId());
		System.out.println("登录用户"+session.getAttribute(("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString()));
		System.out.println("最后操作日期:"+session.getLastAccessTime());
		
	}

	@Override
	public void onStop(Session session) {//退出
		// TODO Auto-generated method stub
		System.out.println("退出会话：" + session.getId());
	}

	@Override
	public void onExpiration(Session session) {//会话过期时触发
		// TODO Auto-generated method stub
		System.out.println("会话过期：" + session.getId()); 
	}

}
