package com.myblog.dto.args;

public class BlogCommend {
	private Integer article_id;
	private Integer  comtype;
	private Integer user_id;
	private Integer user_toid;
	private Integer commend_id;

	private String commend_con;
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getComtype() {
		return comtype;
	}
	public void setComtype(Integer comtype) {
		this.comtype = comtype;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getUser_toid() {
		return user_toid;
	}
	public void setUser_toid(Integer user_toid) {
		this.user_toid = user_toid;
	}

	public Integer getCommend_id() {
		return commend_id;
	}
	public void setCommend_id(Integer commend_id) {
		this.commend_id = commend_id;
	}
	public String getCommend_con() {
		return commend_con;
	}
	public void setCommend_con(String commend_con) {
		this.commend_con = commend_con;
	}

	public BlogCommend(Integer article_id, Integer comtype, Integer user_id, Integer user_toid, 
			Integer commend_id, String commend_con) {
		super();
		this.article_id = article_id;
		this.comtype = comtype;
		this.user_id = user_id;
		this.user_toid = user_toid;
		this.commend_id = commend_id;
		this.commend_con = commend_con;
	}
	public BlogCommend() {
		super();
	}
	@Override
	public String toString() {
		return "BlogCommend [article_id=" + article_id + ", comtype=" + comtype + ", user_id=" + user_id
				+ ", user_toid=" + user_toid  + ", commend_id=" + commend_id
				+", commend_con=" + commend_con + "]";
	}
	
}
