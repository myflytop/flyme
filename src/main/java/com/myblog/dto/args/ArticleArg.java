package com.myblog.dto.args;
/**
 * 
 * @author Administrator
 * 文章模糊查询参数
 *
 */
public class ArticleArg {
	private Integer article_id;
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = +article_id;
	}
	@Override
	public String toString() {
		return "ArticleArg [article_id=" + article_id + ", article_title=" + article_title + ", sort_article_id="
				+ sort_article_id + "]";
	}
	public ArticleArg() {
		super();
	}
	public ArticleArg(Integer article_id, String article_title, Integer sort_article_id) {
		super();
		this.article_id = article_id;
		this.article_title = "%"+ article_title+"%";
		this.sort_article_id = sort_article_id;
	}
	private String  article_title;
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title ="%"+ article_title+"%";
	}
	public Integer getSort_article_id() {
		return sort_article_id;
	}
	public void setSort_article_id(Integer sort_article_id) {
		this.sort_article_id = sort_article_id;
	}
	private Integer sort_article_id;
}
