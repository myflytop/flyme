package com.myblog.dto.admin;

public class AdUser {
	private Integer user_id;
	private String user_name;
	private String user_lasttime;
	private String user_time;
	private Byte user_sex;
	private String user_signature;
	private String user_birthday;
	private String user_location;
	private Byte user_lock;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Byte getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(Byte user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_signature() {
		return user_signature;
	}
	public void setUser_signature(String user_signature) {
		this.user_signature = user_signature;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_location() {
		return user_location;
	}
	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}
	public Byte getUser_lock() {
		return user_lock;
	}
	public void setUser_lock(Byte user_lock) {
		this.user_lock = user_lock;
	}
	@Override
	public String toString() {
		return "AdUser [user_id=" + user_id + ", user_name=" + user_name + ", user_sex=" + user_sex
				+ ", user_signature=" + user_signature + ", user_birthday=" + user_birthday + ", user_location="
				+ user_location + ", user_lock=" + user_lock + ", user_lasttime=" + user_lasttime +", user_time=" + user_time +"]";
	}
	public String getUser_lasttime() {
		return user_lasttime;
	}
	public void setUser_lasttime(String user_lasttime) {
		this.user_lasttime = user_lasttime;
	}
	public String getUser_time() {
		return user_time;
	}
	public void setUser_time(String user_time) {
		this.user_time = user_time;
	}
	
}
