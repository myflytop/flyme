package com.myblog.service.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myblog.dao.IArticleCommendDao;
import com.myblog.dao.user.IUserArticleDao;
import com.myblog.dto.MSort;
import com.myblog.dto.args.SearchArtArg;
import com.myblog.dto.user.MyArticleAll;
import com.myblog.dto.user.MyUserArticle_title;
import com.myblog.entity.Article_commend;
import com.myblog.entity.Article_commend_two;
import com.myblog.entity.Sort_article;
import com.myblog.entity.rote.CommendRote;
import com.myblog.entity.rote.ReadRote;
import com.myblog.entity.rote.UpvoteRote;

import net.sf.json.JSONObject;
@Service("userArticleService")
public class IUserArticleServiceImpl implements IUserArticleService {
	@Resource(name="IUserArticleDao")
    private IUserArticleDao userArticleDao;
	@Resource(name="IArticleCommendDao")
	private IArticleCommendDao articleCommendDao;
	
	public IUserArticleDao getUserArticleDao() {
		return userArticleDao;
	}
	public void setUserArticleDao(IUserArticleDao userArticleDao) {
		this.userArticleDao = userArticleDao;
	}
	public IArticleCommendDao getArticleCommendDao() {
		return articleCommendDao;
	}
	public void setArticleCommendDao(IArticleCommendDao articleCommendDao) {
		this.articleCommendDao = articleCommendDao;
	}
	@Override
	public List<MyUserArticle_title> getArticleTitle(SearchArtArg searchArtArg) {
		// TODO Auto-generated method stub
		return userArticleDao.getArticleTitle(searchArtArg);
	}
	@Override
	public MyArticleAll getArticleAll(int article_id) {
		// TODO Auto-generated method stub
		MyArticleAll myArticleAll=new MyArticleAll();
		
	
		myArticleAll.setMyUserArticle(userArticleDao.getArticle(article_id));
		if (myArticleAll.getMyUserArticle()!=null) {
			myArticleAll.setMyArticle_commend(articleCommendDao.getCommends(article_id));
		}
		else 
		{
			myArticleAll=null;
		}
		
		return myArticleAll;
	}
	@Override
	public int addrtRead(ReadRote readRote) {
		// TODO Auto-generated method stub
		int re=0;
		if(userArticleDao.addrtRoteRead(readRote)==1)
		{
			
			if (userArticleDao.plusrtReadCount(readRote.getArticle_id())==1) {
				{
					re=1;
				}
			}
		}
		return re;
	}
	@Override
	public int addrtUpvote(UpvoteRote upvoteRote) {
		// TODO Auto-generated method stub
		int re=0;
		if (userArticleDao.countUpvote(upvoteRote.getArticle_id(), upvoteRote.getUser_id())==0)
		{
		if (userArticleDao.addrtRoteUpvote(upvoteRote)==1) {
			if (userArticleDao.plusrtUpvoteCount(upvoteRote.getArticle_id())==1) {
				re=1;
			}
		}
		}
		return re;
	}
	@Override
	public int addrtCommend(Map<String, Object> comm) {
		// TODO Auto-generated method stub
		int re=0;
		try {
			//1表示一级评论,2表示二级评论
			int comtype=(int) comm.get("comtype");
			String commend_con=(String) comm.get("commend_con");
			String commend_ip=(String) comm.get("commend_ip");
			int article_id=(int)comm.get("article_id");
			if (comtype==1) {
				Article_commend one=new Article_commend();
				one.setCommend_con(commend_con);
				one.setArticle_id(article_id);
				one.setUser_id((int)comm.get("user_id"));
				if (userArticleDao.addrtOneCommend(one)==1) {
					System.err.println(new CommendRote(one.getCommend_id(), one.getUser_id(), one.getArticle_id(), -1, comtype, commend_ip, null));
					if (userArticleDao.addrtRoteCommend(new CommendRote(one.getCommend_id(), one.getUser_id(), one.getArticle_id(), -1, comtype, commend_ip, null))==1) {
					  
					   if (userArticleDao.plusrtCommendCount(one.getArticle_id())==1) {
						re=1;
						
					}
				}	
				}	
			}
			else
			{
		  Article_commend_two two=new Article_commend_two();
		  two.setCommend_id((int)comm.get("commend_id"));
		  two.setUser_replyid((int) comm.get("user_replyid"));
		  two.setUser_toid((int) comm.get("user_toid"));
		  two.setCommend_con(commend_con);
		   if (userArticleDao.addrtTwoCommend(two)==1) {
			  if (userArticleDao.addrtRoteCommend(new CommendRote(two.getArticle_commend_twoid(), two.getUser_toid(), (int) comm.get("article_id"), null, comtype, commend_ip, null))==1) {
				if (userArticleDao.plusrtCommendCount(article_id)==1) {
					re=1;
				}
			}
		}
		  
			}
		} catch (Exception e) {
			// TODO: handle exception
			re=0;
		}
		
		return re;
	}
	@Override
	public int countUpvote(int article_id, int user_id) {
		// TODO Auto-generated method stub
		return userArticleDao.countUpvote(article_id, user_id);
	}
	@Override
	public String getAreicleStar() {
		// TODO Auto-generated method stu
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("ArticleHot", userArticleDao.getArticleHot());
		jsonObject.accumulate("ArticleNice", userArticleDao.getArticleNice());	
		return jsonObject.toString();
	}
	@Override
	public List<MSort> getSorts() {
		// TODO Auto-generated method stub
		return userArticleDao.getSorts();
	}

	
	
}
