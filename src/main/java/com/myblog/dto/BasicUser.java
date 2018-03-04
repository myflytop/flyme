package com.myblog.dto;

public class BasicUser {
	private Integer user_id;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_pas() {
		return user_pas;
	}
	public void setUser_pas(String user_pas) {
		this.user_pas = user_pas;
	}
	private String user_mail;
	private String user_pas;
	public BasicUser(Integer user_id, String user_mail, String user_pas) {
		super();
		this.user_id = user_id;
		this.user_mail = user_mail;
		this.user_pas = user_pas;
	}
	public BasicUser() {
		super();
	}
	@Override
	public String toString() {
		return "BasicUser [user_id=" + user_id + ", user_mail=" + user_mail + ", user_pas=" + user_pas + "]";
	}
	
}
