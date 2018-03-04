package com.myblog.entity.rote;

public class CommendRote extends BasicRote{
	private Integer commend_id;
	private Integer commendrote_id;
	private Integer commend_type;
	private String commend_ip;
	private String commend_time;
	public Integer getCommend_id() {
		return commend_id;
	}
	public void setCommend_id(Integer commend_id) {
		this.commend_id = commend_id;
	}
	public Integer getCommendrote_id() {
		return commendrote_id;
	}
	public void setCommendrote_id(Integer commendrote_id) {
		this.commendrote_id = commendrote_id;
	}
	public Integer getCommend_type() {
		return commend_type;
	}
	public void setCommend_type(Integer commend_type) {
		this.commend_type = commend_type;
	}
	public String getCommend_ip() {
		return commend_ip;
	}
	public void setCommend_ip(String commend_ip) {
		this.commend_ip = commend_ip;
	}
	public String getCommend_time() {
		return commend_time;
	}
	public void setCommend_time(String commend_time) {
		this.commend_time = commend_time;
	}
	public CommendRote() {
		super();
	}
	public CommendRote(Integer commend_id, Integer user_id,Integer article_id,Integer commendrote_id, Integer commend_type, String commend_ip,
			String commend_time) {
		super();
		this.setArticle_id(article_id);
		this.setUser_id(user_id);
		this.commend_id = commend_id;
		this.commendrote_id = commendrote_id;
		this.commend_type = commend_type;
		this.commend_ip = commend_ip;
		this.commend_time = commend_time;
	}
	@Override
	public String toString() {
		return "CommendRote [commend_id=" + commend_id + ", commendrote_id=" + commendrote_id + ", commend_type="
				+ commend_type + ", commend_ip=" + commend_ip + ", commend_time=" + commend_time + ", article_id="
				+ getArticle_id() + ", user_id=" + getUser_id() + "]";
	}
	
}
