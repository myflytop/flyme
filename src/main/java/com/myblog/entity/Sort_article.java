package com.myblog.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Sort_article {
	@Min(value=1,message="{mes.id}")
	private Integer sort_article_id;
	public Integer getSort_article_id() {
		return sort_article_id;
	}
	public void setSort_article_id(Integer sort_article_id) {
		this.sort_article_id = sort_article_id;
	}
	@Size(min=2,max=12,message="{mes.name}")
	private String sort_article_name;
	private String sort_article_time;
	private String sort_article_retime;
	public Sort_article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSort_article_name() {
		return sort_article_name;
	}
	public String getSort_article_time() {
		return sort_article_time;
	}

	public void setSort_article_name(String sort_article_name) {
		this.sort_article_name = sort_article_name;
	}
	public void setSort_article_time(String sort_article_time) {
		this.sort_article_time = sort_article_time;
	}
	public Sort_article(Integer sort_article_id, String sort_article_name) {
		super();
		this.sort_article_id = sort_article_id;
		this.sort_article_name = sort_article_name;
		
	}
	@Override
	public String toString() {
		return "Sort_article [sort_article_id=" + sort_article_id + ", sort_article_name=" + sort_article_name
				+ ", sort_article_time=" + sort_article_time +", sort_article_retime=" + sort_article_retime +"]";
	}

	public String getSort_article_retime() {
		return sort_article_retime;
	}

	public void setSort_article_retime(String sort_article_retime) {
		this.sort_article_retime = sort_article_retime;
	}
}
