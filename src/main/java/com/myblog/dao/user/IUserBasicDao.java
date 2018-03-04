package com.myblog.dao.user;

public interface IUserBasicDao {
	/**
	 * 增加阅读量
	 * @param article_id
	 * @return
	 */
       public int addrtReadCount(int article_id);
       /**
        * 增加赞
        * @param article_id
        * @return
        */
       public int addrtUpvoteCount(int article_id);
       /**
        * 增加赞记录
        * @param article_id
        * @return
        */
       public int addrtUpvoteRecord(int article_id);
       /**
        * 增加评论
        * @param article_id
        * @return
        */
       public int addrtCommenCount(int article_id);
       /**
        * 增加评论记录
        * @param article_id
        * @return
        */
       public int addrtCommentRecord(int article_id);
}
