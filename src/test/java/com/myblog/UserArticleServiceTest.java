package com.myblog;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.entity.rote.ReadRote;
import com.myblog.entity.rote.UpvoteRote;
import com.myblog.service.user.IUserArticleServiceImpl;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "/spring-db.xml", "/spring-mybatis.xml", "/spring-service.xml", "/spring-tx.xml" }) // 加载配置文件
public class UserArticleServiceTest {
	@Resource(name = "userArticleService")
	private IUserArticleServiceImpl userArticleService;
    @Test
    public void getArticleAll() {
    	JSONObject object=JSONObject.fromObject(userArticleService.getArticleAll(1));
    	System.out.println(object.toString());
    	
    }
    @Test
    public void gaddread() {
    	userArticleService.addrtRead(new ReadRote(1, 5, "fff",  "fff", 16));
    
    }
    @Test
    public void gaddup() {
    	userArticleService.addrtUpvote(new UpvoteRote(1,1,16,"fff","fff"));
    
    }
    @Test
    public void gaddcomm() {
    	Map<String, Object> coMap=new HashMap<>();
    	coMap.put("article_id", 16);
    	coMap.put("comtype", 1);
    	coMap.put("user_id", 1);
    	/*coMap.put("comtype",2);
    	coMap.put("user_toid", 1);
    	coMap.put("user_replyid", 2);*/
    	/*coMap.put("commend_id", 13);*/
    	coMap.put("commend_ip", "192.168.0.1");
    	coMap.put("commend_con", "这个属性用于定义建立布局时元素生成的显示框类型。对于 HTML 等文档类型，如果使用 display 不谨慎会很危险，因为可能违反 HTML 中已经定义的显示层次结构。对于 XML，由于 XML 没有内置的这种层次结构，所有 display 是绝对必要的。");
    	System.out.println(userArticleService.addrtCommend(coMap));
    
    }
    @Test
    public void gg() {
    	
    	System.out.println(userArticleService.getAreicleStar());
    }
}