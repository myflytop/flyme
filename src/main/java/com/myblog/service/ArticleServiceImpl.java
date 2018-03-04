package com.myblog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.dao.IArticleDao;
import com.myblog.dto.MSort;
import com.myblog.dto.MyArticle;
import com.myblog.dto.args.ArticleArg;
import com.myblog.entity.Article;
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {
	@Resource(name="IArticleDao")
	private IArticleDao  articleDao;

	@Override
	public List<MSort> getSorts() {
		// TODO Auto-generated method stub
		return articleDao.getSorts();
	}

	@Override
	@Transactional
	public int addArticle(Article article) {
		// TODO Auto-generated method stub
		   if (articleDao.addArticle(article)==1) {
			  articleDao.addArticle_star(article.getArticle_id());
			  
		} 
		    
		return 1;
	}

	@Override
	public Article getArticle(int article_id) {
		// TODO Auto-generated method stub
		return articleDao.getArticle(article_id);
	}

	public IArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public List<MyArticle> getArticleList(ArticleArg arg) {
		// TODO Auto-generated method stub
		return articleDao.getArticleList(arg);
	}

}
