package com.myblog.entity.rote;

public class UpvoteRote extends BasicRote{
	private Integer upvote_id;
	private String upvote_ip;
	private String upvote_time;
	public Integer getUpvote_id() {
		return upvote_id;
	}
	public void setUpvote_id(Integer upvote_id) {
		this.upvote_id = upvote_id;
	}
	public String getUpvote_ip() {
		return upvote_ip;
	}
	public void setUpvote_ip(String upvote_ip) {
		this.upvote_ip = upvote_ip;
	}
	public String getUpvote_time() {
		return upvote_time;
	}
	public void setUpvote_time(String upvote_time) {
		this.upvote_time = upvote_time;
	}
	public UpvoteRote() {
		super();
	}
	public UpvoteRote(Integer upvote_id, Integer user_id,Integer article_id,String upvote_ip, String upvote_time) {
		super();
		this.setArticle_id(article_id);
		this.setUser_id(user_id);
		this.upvote_id = upvote_id;
		this.upvote_ip = upvote_ip;
		this.upvote_time = upvote_time;
	}
	@Override
	public String toString() {
		return "UpvoteRote [upvote_id=" + upvote_id + ", upvote_ip=" + upvote_ip + ", upvote_time=" + upvote_time
				+ ", article_id=" + getArticle_id() + ", user_id=" + getUser_id() + "]";
	}
	
}
