package com.myblog.entity;

public class Article {
	//文章标题id
	private Integer article_id;
	//文章名字
	private String article_title;
	//发布时间
	private String article_time;
	//修改时间
	private String article_retime;
	//所属分类
	private Integer sort_article_id;
	//发布者
	private Integer bloger_id;
	//内容
	private String article_content;
	//blog 图片简介
	private String  article_img_brief;
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
	//blog 内容简介
	private String  article_con_brief;
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
	public String getArticle_retime() {
		return article_retime;
	}
	public void setArticle_retime(String article_retime) {
		this.article_retime = article_retime;
	}
	public Integer getSort_article_id() {
		return sort_article_id;
	}
	public void setSort_article_id(Integer sort_article_id) {
		this.sort_article_id = sort_article_id;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public Article(Integer article_id, String article_title, String article_time, String article_retime,
			Integer sort_article_id, Integer bloger_id, String article_content, String article_img_brief,
			String article_con_brief) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_time = article_time;
		this.article_retime = article_retime;
		this.sort_article_id = sort_article_id;
		this.bloger_id = bloger_id;
		this.article_content = article_content;
		this.article_img_brief = article_img_brief;
		this.article_con_brief = article_con_brief;
	}
	
	public Article() {
		super();
	}
	public Integer getBloger_id() {
		return bloger_id;
	}
	public void setBloger_id(Integer bloger_id) {
		this.bloger_id = bloger_id;
	}
	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", article_title=" + article_title + ", article_time="
				+ article_time + ", article_retime=" + article_retime + ", sort_article_id=" + sort_article_id
				+ ", bloger_id=" + bloger_id + ", article_content=" + article_content + ", article_img_brief="
				+ article_img_brief + ", article_con_brief=" + article_con_brief + "]";
	}
}
