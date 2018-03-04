package com.myblog.dto;
/**
 * 好文章,热门文章
 * @author Administrator
 *
 */
public class ArticleNice {
	private Integer article_id;
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	private String article_name;
	@Override
	public String toString() {
		return "ArticleNice [article_id=" + article_id + ", article_name=" + article_name + "]";
	}
    
}
