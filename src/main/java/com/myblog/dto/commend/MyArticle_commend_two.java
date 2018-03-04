package com.myblog.dto.commend;

public class MyArticle_commend_two {
	                
	private Integer article_commend_twoid;
	private String commend_id;
	private Integer user_replyid;
	private String user_replyname;
	private String user_toname;
	private Integer user_toid;
	private String commend_con;
	private String commend_time;
	public String getUser_replyname() {
		return user_replyname;
	}
	public void setUser_replyname(String user_replyname) {
		this.user_replyname = user_replyname;
	}
	public String getUser_toname() {
		return user_toname;
	}
	public void setUser_toname(String user_toname) {
		this.user_toname = user_toname;
	}
	
	@Override
	public String toString() {
		return "MyArticle_commend_two [article_commend_twoid=" + article_commend_twoid + ", commend_id=" + commend_id
				+ ", user_replyid=" + user_replyid + ", user_replyname=" + user_replyname + ", user_toname="
				+ user_toname + ", user_toid=" + user_toid + ", commend_con=" + commend_con + ", commend_time="
				+ commend_time + "]";
	}
	
	public MyArticle_commend_two(Integer article_commend_twoid, String commend_id, Integer user_replyid,
			String user_replyname, String user_toname, Integer user_toid, String commend_con, String commend_time) {
		super();
		this.article_commend_twoid = article_commend_twoid;
		this.commend_id = commend_id;
		this.user_replyid = user_replyid;
		this.user_replyname = user_replyname;
		this.user_toname = user_toname;
		this.user_toid = user_toid;
		this.commend_con = commend_con;
		this.commend_time = commend_time;
	}
	public MyArticle_commend_two() {
		super();
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
	public String getCommend_con() {
		return commend_con;
	}
	public void setCommend_con(String commend_con) {
		this.commend_con = commend_con;
	}
	public String getCommend_time() {
		return commend_time;
	}
	public void setCommend_time(String commend_time) {
		this.commend_time = commend_time;
	}
	public String getCommend_id() {
		return commend_id;
	}
	public void setCommend_id(String commend_id) {
		this.commend_id = commend_id;
	}

	
	
	
}
