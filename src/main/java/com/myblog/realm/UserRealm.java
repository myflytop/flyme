package com.myblog.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

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

import com.myblog.dto.BasicUser;
import com.myblog.service.user.IUserServiceImpl;
import com.myblog.shiro.CustomizedToken;
import com.myblog.shiro.LoginType;

public class UserRealm extends AuthorizingRealm {
	@Resource(name="userService")
    private IUserServiceImpl  userService;
	public IUserServiceImpl getUserService() {
		return userService;
	}

	public void setUserService(IUserServiceImpl userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.err.println("UserRealm doGetAuthorizationInfo");
		SimpleAuthorizationInfo info = null;
		// 获取当前登录类型
		String loginType = (String) SecurityUtils.getSubject().getSession().getAttribute("loginType");
		System.out.println(loginType);
		if (LoginType.USER.toString().equals(loginType)) {
			Set<String> roles = new HashSet<>();
			System.out.println("授权");
			roles.add("user");
			info = new SimpleAuthorizationInfo(roles);
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("UserRealm");
		BasicUser basicUser=null;
		// 1. 把AuthenticationToken转换为CustomizedToken
	   CustomizedToken upToken = (CustomizedToken) token;
		//2. 从 UsernamePasswordToken 中来获取 username(用户id或者邮箱)
		String username = upToken.getUsername();
		 //3.获取基本登陆信息
		 basicUser=userService.getBasicUser(username);
		
        //4.获取到的用户不存在，抛出UnknownAccountException异常
		if (basicUser==null) {
			throw new UnknownAccountException("用户不存在!");
		}
		
		
		//5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		//以下信息是从数据库中获取的.
		//1). principal: 认证的实体信息. 可以是 用户id, 也可以是数据表对应的用户的实体类对象. 
		Object principal = basicUser.getUser_id();
		//2). credentials: 密码.
		Object hashedCredentials = basicUser.getUser_pas();
		//3）salt 加盐为邮箱号
		ByteSource credentialsSalt = ByteSource.Util.bytes(basicUser.getUser_mail());
		//4）realmName：当前realm对象的name，调用父类的getName()方法即可.
		String realmName=getName();
		
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal, //用户名
				hashedCredentials, //用户密码
				credentialsSalt, //salt 加盐为用户账号
				realmName);//当前realm对象的name
		/*SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(principal, credentials, realmName);*/
		return info;
	}

}
