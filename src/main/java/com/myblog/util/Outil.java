package com.myblog.util;

import com.myblog.entity.Sort_article;

public class Outil {
	private int code;
	private Sort_article sort_article;
	public Sort_article getSort_article() {
		return sort_article;
	}
	public void setSort_article(Sort_article sort_article) {
		this.sort_article = sort_article;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Outil [code=" + code + ", sort_article=" + sort_article + "]";
	}

}
