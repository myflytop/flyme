package com.myblog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.dao.user.IUserArticleDao;
import com.myblog.dto.args.SearchArtArg;
import com.myblog.entity.rote.CommendRote;
import com.myblog.entity.rote.ReadRote;
import com.myblog.entity.rote.UpvoteRote;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "/spring-db.xml", "/spring-mybatis.xml", "/spring-service.xml", "/spring-tx.xml" }) // 加载配置文件
public class UserArticleDaoTest {
	@Resource(name = "IUserArticleDao")
	private IUserArticleDao userArticleDao;
    @Test
	public void testgetArticleTitle() {
    	SearchArtArg searchArtArg=new SearchArtArg();
    	/*searchArtArg.setSearchArg("art");*/
    	List<Integer> sorta=new ArrayList<Integer>();
    	sorta.add(177);
    	searchArtArg.setSortArgs(sorta);
    System.out.println(userArticleDao.getArticleTitle(searchArtArg));
	}
    @Test
   	public void testgetArticle() {
       System.out.println(userArticleDao.getArticle(1));
   	}
    @Test
   	public void readcount() {
       System.out.println(userArticleDao.plusrtReadCount(100));
   	}
    @Test
   	public void addrotertRead() {
       System.out.println(userArticleDao.addrtRoteRead(new ReadRote(1, 5, "fff",  "fff", 16)));
   	}
    @Test
   	public void addrotertup() {
    	System.out.println(new UpvoteRote(1,1,16,"fff","fff"));
       System.out.println(userArticleDao.addrtRoteUpvote(new UpvoteRote(1,1,16,"fff","fff")));
           System.out.println(userArticleDao.plusrtUpvoteCount(16));
   	}
    @Test
   	public void commendtest() {
    	 /* Article_commend article_commmend=new Article_commend();
    	  article_commmend.setArticle_id(1);
    	  article_commmend.setCommend_con("testdao");
    	  article_commmend.setUser_id(1);
    	  System.out.println(userArticleDao.addrtOneCommend(article_commmend));
    	System.out.println(article_commmend);*/
     /*  Article_commend_two article_commend_two =new Article_commend_two();
  	   article_commend_two.setCommend_id(2);
  	   article_commend_two.setCommend_con("testtwo commend");
  	   article_commend_two.setUser_replyid(1);
  	   article_commend_two.setUser_toid(2);
  	   userArticleDao.addrtTwoCommend(article_commend_two);
  	   System.out.println(article_commend_two);  */
    	
    	/*System.out.println(userArticleDao.plusrtCommendCount(16));*/
    	System.out.println(userArticleDao.addrtRoteCommend(new CommendRote(2, 1, 16, -1, 1, "commend_ip", "commend_time")));
    	System.out.println();
   	}
    @Test
    public void boolup() {
    	/*System.out.println(userArticleDao.getrtUpvote(16, 1));*/
    	System.out.println(userArticleDao.getArticleHot());
    }
    @Test
    public void countUpvote() {
    	System.out.println(userArticleDao.countUpvote(16,4));
    }
    
}