package com.myblog;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.dto.admin.AdUser;
import com.myblog.dto.args.AdUserArg;
import com.myblog.entity.Blog_web_record;
import com.myblog.entity.User;
import com.myblog.service.IBlogerForUserServiceImpl;
import com.myblog.util.BasicUtil;
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "/spring-db.xml", "/spring-mybatis.xml", "/spring-service.xml", "/spring-tx.xml" }) // 加载配置文件
public class BlogerForUserTset {
	@Resource(name ="blogerForUserService")
	private IBlogerForUserServiceImpl ib;
   
    @Test
    public void fkkf() {
    	AdUserArg adUser=new AdUserArg();
    	adUser.setOid(null);
    	adUser.setOlasttime(2);
    	
    	adUser.setUser_id(null);
    	adUser.setUser_name(null);
    	System.out.println(ib.getUser(adUser));
    }
}
