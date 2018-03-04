package com.myblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.dto.commend.MyArticle_commend;
import com.myblog.entity.Article_commend;
import com.myblog.entity.Article_commend_two;

public interface IArticleCommendDao {
	   /**
	    * 添加一级评论
	    *@param article_commmend
	    * @return
	    */
       public int addCommend(Article_commend article_commmend);
       /**
        * 获取一条一级评论
        * 
        * @return
        */
       public MyArticle_commend getCommend(int commend_id);
       /**
        * 获取评论
        * @param commend_id
        * @return
        */
       public List<MyArticle_commend> getCommends(int article_id);
       /**
        * 审核一级评论权限 
        * @param commend_id
        * @return
        */
       public int auditCommend(@Param("commend_id") int commend_id,@Param("commend_islock") int commend_islock);
       /**
        * 删除评论  物理删除
        * @param commend_id
        * @return
        */
       public int delrealCommend(int commend_id);
       /**
	    * 添加二级评论
	    * @param article_commmend_two
	    * @return
	    */
       public int addtwoCommend(Article_commend_two article_commmend_two);
       /**
        * 审核二级评论权限
        * @param article_commmend_twoid
        * @return
        */
       public int audittwoCommend(@Param("article_commend_twoid") int article_commend_twoid,@Param("commend_islock") int commend_islock);
       /**
        * 删除二级评论 物理删除
        * @param article_commmend_twoid
        * @return
        */
       public int deltworealCommend(int article_commmend_twoid);
     
}
