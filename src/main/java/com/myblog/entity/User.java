package com.myblog.entity;

public class User {
	private Integer user_id;
	private String user_mail;
	private Byte user_islock;
	private String user_regtime;
	private String user_regip;
	private String user_lastip;
	private String user_lasttime;
	private String user_uppastime;
	private String user_pas;

	public User() {
		super();
	}

	public User(String user_mail, String user_regip, String user_pas) {
		super();
		this.user_mail = user_mail;
		this.user_regip = user_regip;
		this.user_pas = user_pas;
	}

	public User(Integer user_id, Byte user_islock, String user_regtime, String user_regip, String user_lastip,
			String user_lasttime, String user_uppastime, String user_pas,String user_mail) {
		super();
		this.user_id = user_id;
		this.user_islock = user_islock;
		this.user_regtime = user_regtime;
		this.user_regip = user_regip;
		this.user_lastip = user_lastip;
		this.user_lasttime = user_lasttime;
		this.user_uppastime = user_uppastime;
		this.user_pas = user_pas;
		this.user_mail = user_mail;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Byte getUser_islock() {
		return user_islock;
	}

	public void setUser_islock(Byte user_islock) {
		this.user_islock = user_islock;
	}

	public String getUser_regtime() {
		return user_regtime;
	}

	public void setUser_regtime(String user_regtime) {
		this.user_regtime = user_regtime;
	}

	public String getUser_regip() {
		return user_regip;
	}

	public void setUser_regip(String user_regip) {
		this.user_regip = user_regip;
	}

	public String getUser_lastip() {
		return user_lastip;
	}

	public void setUser_lastip(String user_lastip) {
		this.user_lastip = user_lastip;
	}

	public String getUser_lasttime() {
		return user_lasttime;
	}

	public void setUser_lasttime(String user_lasttime) {
		this.user_lasttime = user_lasttime;
	}

	public String getUser_uppastime() {
		return user_uppastime;
	}

	public void setUser_uppastime(String user_uppastime) {
		this.user_uppastime = user_uppastime;
	}

	public String getUser_pas() {
		return user_pas;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public void setUser_pas(String user_pas) {
		this.user_pas = user_pas;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_islock=" + user_islock + ", user_regtime=" + user_regtime
				+ ", user_regip=" + user_regip + ", user_lastip=" + user_lastip + ", user_lasttime=" + user_lasttime
				+ ", user_uppastime=" + user_uppastime + ", user_pas=" + user_pas + ",user_mail="+user_mail+"]";
	}



}
