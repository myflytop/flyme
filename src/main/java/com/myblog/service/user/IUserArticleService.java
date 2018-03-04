package com.myblog.service.user;

import java.util.List;
import java.util.Map;

import com.myblog.dto.MSort;
import com.myblog.dto.args.SearchArtArg;
import com.myblog.dto.user.MyArticleAll;
import com.myblog.dto.user.MyUserArticle_title;
import com.myblog.entity.Sort_article;
import com.myblog.entity.rote.ReadRote;
import com.myblog.entity.rote.UpvoteRote;

public interface IUserArticleService {
	public List<MyUserArticle_title> getArticleTitle(SearchArtArg searchArtArg);
	public MyArticleAll getArticleAll(int article_id);
	/**
	 * 添加阅读
	 * @return
	 */
	public int addrtRead(ReadRote readRote);
	/**
	 * 用户是否赞过
	 * @param article_id
	 * @param user_id
	 * @return
	 */
	public int countUpvote(int article_id,int user_id);
	/**
	 * 添加赞
	 * @return
	 */
	public int addrtUpvote(UpvoteRote upvoteRote);
	/**
	 * 添加评论
	 * @return
	 */
	public int addrtCommend(Map<String, Object> comm);
	/**
	 * 简单排行
	 * @return
	 */
	public String getAreicleStar();
	/***
	 * 获取分类列表
	 * @return
	 */
	public List<MSort> getSorts();
}
