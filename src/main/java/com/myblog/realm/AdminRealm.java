package com.myblog.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.myblog.entity.Bloger;
import com.myblog.service.BlogerServiceImpl;
import com.myblog.shiro.CustomizedToken;
import com.myblog.shiro.LoginType;

public class AdminRealm extends AuthorizingRealm {
	
	 @Autowired
	 @Qualifier("blogerService")
     private BlogerServiceImpl blogerService;

	public BlogerServiceImpl getBlogerService() {
		return blogerService;
	}

	public void setBlogerService(BlogerServiceImpl blogerService) {
		this.blogerService = blogerService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub	
		System.err.println("AdminRealm doGetAuthorizationInfo");
		SimpleAuthorizationInfo info = null;
		// 获取当前登录类型
		String loginType = (String) SecurityUtils.getSubject().getSession().getAttribute("loginType");
		System.out.println(loginType);
		if (LoginType.ADMIN.toString().equals(loginType)) {
			Set<String> roles = new HashSet<>();
			System.out.println("授权");
			roles.add("admin");
			info = new SimpleAuthorizationInfo(roles);
		}
		
		
		return info;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken 
		CustomizedToken upToken = (CustomizedToken) token;
		//2. 从 UsernamePasswordToken 中来获取 username
		String username = upToken.getUsername();
		Bloger bloger=blogerService.getBloger(Integer.parseInt(username));
		System.out.println(bloger);
        //4.获取到的用户不存在，抛出UnknownAccountException异常
		if (bloger==null) {
			throw new UnknownAccountException("用户不存在!");
		}
		
		//5. 根据用户信息的情况, 决定是否需要抛出其他的 LockedAccountException 异常. 
		/*if("monster".equals(username)){
			throw new LockedAccountException("用户被锁定");
		}*/
		//6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		//以下信息是从数据库中获取的.
		//1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象. 
		Object principal = username;
		//2). credentials: 密码. 
		Object hashedCredentials = bloger.getBloger_pas(); 
		String realmName=getName();
		
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, //用户名
				hashedCredentials, //用户密码
				ByteSource.Util.bytes(username), //salt 加盐为用户账号
				realmName);
		/*SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(principal, credentials, realmName);*/
		return info;
	}
	  public void claenCached()
	  {
	   PrincipalCollection principals=SecurityUtils.getSubject().getPreviousPrincipals();
	   System.err.println(principals);
	   super.clearCachedAuthenticationInfo(principals);
	  super.clearCache(principals);
	  }
}
