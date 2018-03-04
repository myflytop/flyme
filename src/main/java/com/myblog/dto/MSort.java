package com.myblog.dto;

public class MSort {
	private Integer sort_article_id;
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
	private String sort_article_name;
	@Override
	public String toString() {
		return "MSort [sort_article_id=" + sort_article_id + ", sort_article_name=" + sort_article_name + "]";
	}
	

}
