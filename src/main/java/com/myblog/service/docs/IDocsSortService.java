package com.myblog.service.docs;

import java.util.List;

import com.myblog.entity.DocsSort;
import com.myblog.util.LayuiDataUtil;

public interface IDocsSortService {
	/**
	 * 添加docs分类
	 * @return
	 * @param docsSort
	 */
	int addDocsSort(DocsSort docsSort);
	/**
	 * 修改docs分类
	 * @return
	 * @param docsSort
	 */
	int updateDocsSort(DocsSort docsSort);
	/**
	 * 物理删除docs分类
	 * @return
	 */
	int delDocsSort(int docsSortid,int docsSortstatus);
	/**
	 * 获取docs分类
	 * @param docsSort
	 * @return
	 */
	LayuiDataUtil<DocsSort> getDocsSorts(DocsSort docsSort,int page,int limit);
	/**
	 * 统计分类是否重复
	 * @param docsSortname
	 * @param userId
	 * @return
	 */
	int countSortName(String docsSortname, long userId);
}
