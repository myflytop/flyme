package com.myblog.dto.user;

public class MyUserArticle_title {
	//blog id
	private Integer article_id;
	//blog 标题
	private String  article_title;
	//blog 添加时间
	private String  article_time;
	//blog 图片简介
	private String  article_img_brief;
	//blog 内容简介
	private String  article_con_brief;
	//blog 类别id
	private Integer sort_article_id;
	//blog 类别名
	private String  sort_article_name;
	//blog 发布者id
	private Integer bloger_id;
	//blog 发布者名字
	private String  bloger_name;
	//blog 阅读统计
	private Integer reading_count;
	//blog 点赞统计
	private Integer upvote_count;
	//blog 评论统计
	private Integer commend_count;
	public String getArticle_img_brief() {
		return article_img_brief;
	}
	public void setArticle_img_brief(String article_img_brief) {
		this.article_img_brief = article_img_brief;
	}
	public String getArticle_con_brief() {
		return article_con_brief;
	}
	public void setArticle_con_brief(String article_con_brief) {
		this.article_con_brief = article_con_brief;
	}
	public MyUserArticle_title() {
		super();
	}
	
	public MyUserArticle_title(Integer article_id, String article_title, String article_time, String article_img_brief,
			String article_con_brief, Integer sort_article_id, String sort_article_name, Integer bloger_id,
			String bloger_name, Integer reading_count, Integer upvote_count, Integer commend_count) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_time = article_time;
		this.article_img_brief = article_img_brief;
		this.article_con_brief = article_con_brief;
		this.sort_article_id = sort_article_id;
		this.sort_article_name = sort_article_name;
		this.bloger_id = bloger_id;
		this.bloger_name = bloger_name;
		this.reading_count = reading_count;
		this.upvote_count = upvote_count;
		this.commend_count = commend_count;
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
	public Integer getSort_article_id() {
		return sort_article_id;
	}
	public void setSort_article_id(Integer sort_article_id) {
		this.sort_article_id = sort_article_id;
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
	@Override
	public String toString() {
		return "MyUserArticle [article_id=" + article_id + ", article_title=" + article_title + ", article_time="
				+ article_time + ", article_img_brief=" + article_img_brief + ", article_con_brief=" + article_con_brief
				+ ", sort_article_id=" + sort_article_id + ", sort_article_name=" + sort_article_name + ", bloger_id="
				+ bloger_id + ", bloger_name=" + bloger_name + ", reading_count=" + reading_count + ", upvote_count="
				+ upvote_count + ", commend_count=" + commend_count + "]";
	}
	public Integer getCommend_count() {
		return commend_count;
	}
	public void setCommend_count(Integer commend_count) {
		this.commend_count = commend_count;
	}


}
