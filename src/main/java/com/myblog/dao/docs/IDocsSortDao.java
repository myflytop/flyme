package com.myblog.dao.docs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.entity.DocsSort;

public interface IDocsSortDao {
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
int delDocsSort(@Param("docsSortid")int docsSortid,@Param("docsSortstatus")int docsSortstatus);
/**
 * 获取docs分类
 * @param docsSort
 * @return
 */
List<DocsSort> getDocsSorts(DocsSort docsSort);
/**
 * 统计分类名
 * @param docsSortname
 * @param docsSortid
 * @return
 */
int countSortName(@Param("docsSortname")String docsSortname,@Param("userId") long userId);

}
