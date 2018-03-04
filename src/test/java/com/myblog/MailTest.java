package com.myblog;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.util.BasicUtil;
import com.myblog.util.MailUtil;  
  
  
/** 
 * 
 * 
 * @author <a href="ls.zhaoxiangyu@gmail.com">zhao</> 
 * @date 2015-9-23 
 */  
@RunWith(SpringJUnit4ClassRunner.class)//@RunWith(SpringJUnit4ClassRunner.class) 来启动 Spring 对测试类的支持  
@ContextConfiguration("/spring-mail.xml")//@ContextConfiguration 注释标签来指定 Spring 配置文件或者配置类的位置  
public class MailTest {  
    private static final Logger log = LoggerFactory.getLogger(MailTest.class);  
      
    @Autowired  
    private MailUtil mailUtil;  
      
    @Test  
    public void sendSingleTest(){  
        log.info("sendSingleTest");  
        mailUtil.send("634866553@qq.com", "你的验证码为------", "Hello Single!kkkkkkkkkkkkkkk");  
    }  
      
    @Test  
    public void sendMassTest(){  
        log.info("sendMassTest");  
        List<String> recipients=new ArrayList<String>();  
        
        recipients.add("2771576141@qq.com");  
        mailUtil.send(recipients, "测试邮件！", "Hello Mass!");  
    }  
    @Test
    public void tsetismail() {
    	System.out.println(BasicUtil.creCode());
    	System.out.println(BasicUtil.isEmail("63@q.com"));
    }
    @Test
    public void tsetpas() {
    	System.out.println(BasicUtil.encryptPsa("123","ooo"));
    }
    @Test
    public void tset() {
    	System.out.println(BasicUtil.boolPas("d1234567"));
    }
}  
