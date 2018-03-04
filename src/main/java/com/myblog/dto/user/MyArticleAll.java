package com.myblog.dto.user;
/**
 * 用户获取文章返回文章和评论的基本类
 * @author Administrator
 *
 */

import java.util.List;

import com.myblog.dto.commend.MyArticle_commend;

public class MyArticleAll {
       private MyUserArticle myUserArticle;
       private List<MyArticle_commend> myArticle_commend;
	public MyUserArticle getMyUserArticle() {
		return myUserArticle;
	}
	public void setMyUserArticle(MyUserArticle myUserArticle) {
		this.myUserArticle = myUserArticle;
	}
	public List<MyArticle_commend> getMyArticle_commend() {
		return myArticle_commend;
	}
	public void setMyArticle_commend(List<MyArticle_commend> myArticle_commend) {
		this.myArticle_commend = myArticle_commend;
	}
	public MyArticleAll(MyUserArticle myUserArticle, List<MyArticle_commend> myArticle_commend) {
		super();
		this.myUserArticle = myUserArticle;
		this.myArticle_commend = myArticle_commend;
	}
	public MyArticleAll() {
		super();
		
	}
	@Override
	public String toString() {
		return "MyArticleAll [myUserArticle=" + myUserArticle + ", myArticle_commend=" + myArticle_commend + "]";
	}
   
}
