package com.myblog.dto.user;

public class MyUserArticle {
	private Integer article_id;
	private String  article_title;
	private String  article_time;
	private Integer sort_article_id;
	public Integer getSort_article_id() {
		return sort_article_id;
	}

	public void setSort_article_id(Integer sort_article_id) {
		this.sort_article_id = sort_article_id;
	}

	private String  sort_article_name;
	private Integer bloger_id;
	private String  bloger_name;
	private Integer reading_count;
	private Integer upvote_count;
	private Integer commend_count;
	private String  article_content;
	public MyUserArticle() {
		super();
	}

	public MyUserArticle(Integer article_id, String article_title, String article_time, Integer sort_article_id,
			String sort_article_name, Integer bloger_id, String bloger_name, Integer reading_count,
			Integer upvote_count, Integer commend_count, String article_content) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_time = article_time;
		this.sort_article_id = sort_article_id;
		this.sort_article_name = sort_article_name;
		this.bloger_id = bloger_id;
		this.bloger_name = bloger_name;
		this.reading_count = reading_count;
		this.upvote_count = upvote_count;
		this.commend_count = commend_count;
		this.article_content = article_content;
	}

	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_time() {
		return article_time;
	}
	public void setArticle_time(String article_time) {
		this.article_time = article_time;
	}
	public String getSort_article_name() {
		return sort_article_name;
	}
	public void setSort_article_name(String sort_article_name) {
		this.sort_article_name = sort_article_name;
	}
	public Integer getBloger_id() {
		return bloger_id;
	}
	public void setBloger_id(Integer bloger_id) {
		this.bloger_id = bloger_id;
	}
	public String getBloger_name() {
		return bloger_name;
	}
	public void setBloger_name(String bloger_name) {
		this.bloger_name = bloger_name;
	}
	public Integer getReading_count() {
		return reading_count;
	}
	public void setReading_count(Integer reading_count) {
		this.reading_count = reading_count;
	}
	public Integer getUpvote_count() {
		return upvote_count;
	}
	public void setUpvote_count(Integer upvote_count) {
		this.upvote_count = upvote_count;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public Integer getCommend_count() {
		return commend_count;
	}
	public void setCommend_count(Integer commend_count) {
		this.commend_count = commend_count;
	}

	@Override
	public String toString() {
		return "MyUserArticle [article_id=" + article_id + ", article_title=" + article_title + ", article_time="
				+ article_time + ", sort_article_id=" + sort_article_id + ", sort_article_name=" + sort_article_name
				+ ", bloger_id=" + bloger_id + ", bloger_name=" + bloger_name + ", reading_count=" + reading_count
				+ ", upvote_count=" + upvote_count + ", commend_count=" + commend_count + ", article_content="
				+ article_content + "]";
	} 
	
}
