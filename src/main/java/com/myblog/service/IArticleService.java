package com.myblog.service;

import java.util.List;

import com.myblog.dto.MSort;
import com.myblog.dto.MyArticle;
import com.myblog.dto.args.ArticleArg;
import com.myblog.entity.Article;

public interface IArticleService {
	/**
     * 获取分类
     * @return
     */
	public List<MSort> getSorts();
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public int addArticle(Article article);
	/**
	 * 获取一条文章
	 * @param article
	 * @return
	 */
	public Article getArticle(int article_id);
	/**
	 * 获取文章列表
	 * @param arg
	 * @return
	 */
	public List<MyArticle> getArticleList(ArticleArg arg);
}
