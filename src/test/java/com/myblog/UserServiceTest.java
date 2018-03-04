package com.myblog;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.entity.User;
import com.myblog.service.user.IUserServiceImpl;
import com.myblog.util.BasicUtil;
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "/spring-db.xml", "/spring-mybatis.xml", "/spring-service.xml", "/spring-tx.xml" }) // 加载配置文件
public class UserServiceTest {
	@Resource(name ="userService")
	private IUserServiceImpl userService;
    @Test
    public void addUser() {
    	User user=new User();
    	user.setUser_mail("mail");
    	user.setUser_regip("user_regip");
    	user.setUser_pas("user_pas");
    	userService.addUser(user);
    }
    @Test
    public void getpas() {
    	System.out.println(userService.getBasicUser("634866553@qq.com"));
    }
    @Test
    public void pas() {
    	System.out.println(BasicUtil.encryptPsa("hua634866553","634866553@qq.com"));
    }
    @Test
    public void upIp() {
    	System.out.println(userService.upUserLoginIp(2, "192.168.0.1"));
    }
    @Test
    public void ff() {
    	System.out.println(Integer.parseInt(null));
    }
}
