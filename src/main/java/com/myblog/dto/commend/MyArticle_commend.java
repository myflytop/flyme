package com.myblog.dto.commend;

import java.util.List;

public class MyArticle_commend {
	private Integer commend_id;
	private Integer article_id;
	private Integer user_id;
	private String  user_img;
	private String  user_name;
	private String commend_con;
	private String commend_time;
	private List<MyArticle_commend_two> myArticle_commend_twos;
	public MyArticle_commend() {
		super();
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
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public List<MyArticle_commend_two> getMyArticle_commend_twos() {
		return myArticle_commend_twos;
	}
	public void setMyArticle_commend_twos(List<MyArticle_commend_two> myArticle_commend_twos) {
		this.myArticle_commend_twos = myArticle_commend_twos;
	}
	@Override
	public String toString() {
		return "MyArticle_commend [commend_id=" + commend_id + ", article_id=" + article_id + ", user_id=" + user_id
				+ ", user_img=" + user_img + ", user_name=" + user_name + ", commend_con=" + commend_con
				+ ", commend_time=" + commend_time + ", myArticle_commend_twos=" + myArticle_commend_twos + "]";
	}
 
	
	
}
