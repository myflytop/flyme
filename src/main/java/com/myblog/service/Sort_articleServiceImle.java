package com.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myblog.dao.ISort_articleDao;
import com.myblog.entity.Sort_article;
@Service("sort_articleService")
public class Sort_articleServiceImle implements ISort_articleService {
	@Autowired
	@Qualifier("ISort_articleDao")
    private ISort_articleDao sort_articleDao;
	public ISort_articleDao getSort_articleDao() {
		return sort_articleDao;
	}

	public void setSort_articleDao(ISort_articleDao sort_articleDao) {
		this.sort_articleDao = sort_articleDao;
	}

	@Override
	public List<Sort_article> getSorts() {
		// TODO Auto-generated method stub
		return sort_articleDao.getSorts();
	}

	@Override
	public Sort_article reSortname(Sort_article sort_article) {
		// TODO Auto-generated method stub
       
		sort_articleDao.reSortname(sort_article);
		
		return sort_articleDao.getSort(sort_article.getSort_article_id());
	}

	@Override
	public Sort_article addSort(Sort_article sort_article) {
		// TODO Auto-generated method stub
		
		sort_articleDao.addSort(sort_article);
		return sort_articleDao.getSort(sort_article.getSort_article_id());
	}

	@Override
	public int delSort(int sort_article_id) {
		// TODO Auto-generated method stub
		
		return sort_articleDao.delSort(sort_article_id);
	}

	
	
	
	@Override
	public String getSortName(String sort_article_name) {
		// TODO Auto-generated method stub
		return sort_articleDao.getSortName(sort_article_name);
	}

	@Override
	public Sort_article getSort(int sort_article_id) {
		// TODO Auto-generated method stub
		return sort_articleDao.getSort(sort_article_id);
	}

	@Override
	public int countsort(String sort_article_name) {
		// TODO Auto-generated method stub
		return sort_articleDao.countsort(sort_article_name);
	}

	

	


}
