package com.myblog.service;

import java.util.List;

import com.myblog.entity.Sort_article;

public interface ISort_articleService {
	/***
	 * 获取分类列表
	 * @return
	 */
	public List<Sort_article> getSorts();
	
	/***
	 * 修改分类
	 * @param sort_article
	 * @return
	 */
	public Sort_article reSortname(Sort_article sort_article);
	/***
	 * 添加分类
	 * @param sort_article_name
	 * @return
	 */
	public Sort_article addSort(Sort_article sort_article);
	/***
	 * 删除分类
	 * @param sort_article_name
	 * @return
	 */
	public int delSort(int sort_article_id);
	/***
	 * 获取分类名
	 * @param sort_article_name
	 * @return
	 */
	public String getSortName(String sort_article_name);
	/***
	 * 获取单条数据
	 * @param sort_article_name
	 */
	public Sort_article getSort(int sort_article_id);
	/***
	 * 统计 sort_article_name
	 * @param sort_article_name
	 */
	public int countsort(String sort_article_name);

}
