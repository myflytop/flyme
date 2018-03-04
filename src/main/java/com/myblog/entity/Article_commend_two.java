package com.myblog.entity;

public class Article_commend_two {
	private Integer commend_id;
	private Integer article_commend_twoid;
	private Integer user_replyid;
	private Integer user_toid;
	private Byte commend_islock;
	private String commend_con;
	
	public Integer getCommend_id() {
		return commend_id;
	}

	public void setCommend_id(Integer commend_id) {
		this.commend_id = commend_id;
	}

	public Integer getArticle_commend_twoid() {
		return article_commend_twoid;
	}

	public void setArticle_commend_twoid(Integer article_commend_twoid) {
		this.article_commend_twoid = article_commend_twoid;
	}

	public Integer getUser_replyid() {
		return user_replyid;
	}

	public void setUser_replyid(Integer user_replyid) {
		this.user_replyid = user_replyid;
	}

	public Integer getUser_toid() {
		return user_toid;
	}

	public void setUser_toid(Integer user_toid) {
		this.user_toid = user_toid;
	}

	public Byte getCommend_islock() {
		return commend_islock;
	}

	public void setCommend_islock(Byte comment_islock) {
		this.commend_islock = comment_islock;
	}

	public String getCommend_con() {
		return commend_con;
	}

	public void setCommend_con(String commend_con) {
		this.commend_con = commend_con;
	}

	public Article_commend_two() {
		super();
	}

	public Article_commend_two(Integer commend_id, Integer article_commend_twoid, Integer user_replyid,
			Integer user_toid, Byte commend_islock, String commend_con) {
		super();
		this.commend_id = commend_id;
		this.article_commend_twoid = article_commend_twoid;
		this.user_replyid = user_replyid;
		this.user_toid = user_toid;
		this.commend_islock = commend_islock;
		this.commend_con = commend_con;
	}

	@Override
	public String toString() {
		return "Article_commend_two [commend_id=" + commend_id + ", article_commend_twoid=" + article_commend_twoid
				+ ", user_replyid=" + user_replyid + ", user_toid=" + user_toid + ", commend_islock=" + commend_islock
				+ ", commend_con=" + commend_con + "]";
	}
	
	
}
