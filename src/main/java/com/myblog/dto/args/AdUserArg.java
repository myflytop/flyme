package com.myblog.dto.args;

public class AdUserArg {
	private Integer user_id;
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getOlasttime() {
		return olasttime;
	}

	public void setOlasttime(Integer olasttime) {
		this.olasttime = olasttime;
	}

	private Integer oid;
	private String user_name;
	private Integer olasttime;
	private Integer user_lock;
	
	@Override
	public String toString() {
		return "AdUserArg [user_id=" + user_id + ", oid=" + oid + ", user_name=" + user_name
				+ ", olasttime=" + olasttime + "user_lock=" + user_lock + "]";
	}

	public Integer getUser_lock() {
		return user_lock;
	}

	public void setUser_lock(Integer user_lock) {
		this.user_lock = user_lock;
	}
	
}
