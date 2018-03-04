package com.myblog.dao.user;

import com.myblog.entity.rote.CommendRote;

public interface IUserAricleDao {
	/**
	 * 增加阅读量
	 * 
	 * @param article_id
	 * @return
	 */
	public int addrtReadCount(int article_id);
	/**
	 * 记录阅读记录
	 * @param commendRote
	 * @return
	 */
    public int rotertRead(CommendRote commendRote);
	/**
	 * 增加赞
	 * 
	 * @param article_id
	 * @return
	 */
	public int addrtUpvoteCount(int article_id);

	/**
	 * 增加赞记录
	 * 
	 * @param article_id
	 * @return
	 */
	public int addrtUpvoteRecord(int article_id);

	/**
	 * 统计评论
	 * 
	 * @param article_id
	 * @return
	 */
	public int addrtCommentCount(int article_id);

	/**
	 * 增加评论记录
	 * 
	 * @param article_id
	 * @return
	 */
	public int addrtCommentRecord(int article_id);
}
