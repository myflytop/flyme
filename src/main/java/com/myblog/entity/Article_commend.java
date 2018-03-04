package com.myblog.entity;

public class Article_commend {
	private Integer commend_id;
	private Integer article_id;
	private Integer user_id;
	private Byte commend_islock;
	private Byte commend_istwo;
	private String commend_con;
	
	public Article_commend() {
		super();
	}

	public Article_commend(Integer commend_id, Integer article_id, Integer user_id, Byte commend_islock,
			Byte commend_istwo, String commend_con) {
		super();
		this.commend_id = commend_id;
		this.article_id = article_id;
		this.user_id = user_id;
		this.commend_islock = commend_islock;
		this.commend_istwo = commend_istwo;
		this.commend_con = commend_con;
	}

	public Integer getCommend_id() {
		return commend_id;
	}

	public void setCommend_id(Integer commend_id) {
		this.commend_id = commend_id;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Byte getCommend_islock() {
		return commend_islock;
	}

	public void setCommend_islock(Byte comment_islock) {
		this.commend_islock = comment_islock;
	}

	public Byte getCommend_istwo() {
		return commend_istwo;
	}

	public void setCommend_istwo(Byte comment_istwo) {
		this.commend_istwo = comment_istwo;
	}

	public String getCommend_con() {
		return commend_con;
	}

	public void setCommend_con(String commend_con) {
		this.commend_con = commend_con;
	}

	@Override
	public String toString() {
		return "Article_commend [commend_id=" + commend_id + ", article_id=" + article_id + ", user_id=" + user_id
				+ ", commend_islock=" + commend_islock + ", commend_istwo=" + commend_istwo + ", commend_con="
				+ commend_con + "]";
	}
}
