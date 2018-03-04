package com.myblog.entity;

public class Blog_web_record {
    private int record_id;
    private String record_ip;
    private String record_time;
    private String record_dervice;
    private String record_brow;
    private String record_user;
	public Blog_web_record() {
		super();
	}
	public Blog_web_record(int record_id, String record_ip, String record_time, String record_dervice,
			String record_brow, String record_user) {
		super();
		this.record_id = record_id;
		this.record_ip = record_ip;
		this.record_time = record_time;
		this.record_dervice = record_dervice;
		this.record_brow = record_brow;
		this.record_user = record_user;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public String getRecord_ip() {
		return record_ip;
	}
	public void setRecord_ip(String record_ip) {
		this.record_ip = record_ip;
	}
	public String getRecord_time() {
		return record_time;
	}
	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}
	public String getRecord_dervice() {
		return record_dervice;
	}
	public void setRecord_dervice(String record_dervice) {
		this.record_dervice = record_dervice;
	}
	public String getRecord_brow() {
		return record_brow;
	}
	public void setRecord_brow(String record_brow) {
		this.record_brow = record_brow;
	}
	public String getRecord_user() {
		return record_user;
	}
	public void setRecord_user(String record_user) {
		this.record_user = record_user;
	}
	@Override
	public String toString() {
		return "Blog_web_record [record_id=" + record_id + ", record_ip=" + record_ip + ", record_time=" + record_time
				+ ", record_dervice=" + record_dervice + ", record_brow=" + record_brow + ", record_user=" + record_user
				+ "]";
	}
	
}
