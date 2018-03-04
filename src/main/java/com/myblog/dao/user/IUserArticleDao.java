package com.myblog.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.dto.ArticleNice;
import com.myblog.dto.MSort;
import com.myblog.dto.args.SearchArtArg;
import com.myblog.dto.user.MyUserArticle;
import com.myblog.dto.user.MyUserArticle_title;
import com.myblog.entity.Article_commend;
import com.myblog.entity.Article_commend_two;
import com.myblog.entity.rote.CommendRote;
import com.myblog.entity.rote.ReadRote;
import com.myblog.entity.rote.UpvoteRote;

/**
 * user或者前端操作
 * 
 * @author kiss
 *
 */
public interface IUserArticleDao {
	/**
	 * 获取文章标题
	 * 
	 * @return MyUserArticle
	 */
	public List<MyUserArticle_title> getArticleTitle(SearchArtArg searchArtArg);

	/**
	 * 获取文章
	 * 
	 * @param article_id
	 * @return
	 */
	public MyUserArticle getArticle(int article_id);
	
	/**
	 * 获取热门文章
	 * @return
	 */
	public List<ArticleNice> getArticleHot();
	/**
	 * 获取最多浏览文章
	 * @return
	 */
	public List<ArticleNice> getArticleNice();
	/**
	 * 增加阅读量
	 * 
	 * @param article_id
	 * @return
	 */
	public int plusrtReadCount(int article_id);

	/**
	 * 记录阅读记录
	 * 
	 * @param readRote
	 * @return
	 */
	public int addrtRoteRead(ReadRote readRote);
	/**
	 * 增加赞量记录
	 * 
	 * @param upvoteRote
	 * @return
	 */
	public int addrtRoteUpvote(UpvoteRote upvoteRote);

	/**
	 * 增加赞总数
	 * 
	 * @param article_id
	 * @return
	 */
	public int plusrtUpvoteCount(int article_id);

	/**
	 * 添加一级评论
	 * 
	 * @param article_commmend
	 * @return
	 */
	public int addrtOneCommend(Article_commend article_commmend);

	/**
	 * 添加二级评论
	 * 
	 * @param article_commmend_two
	 * @return
	 */
	public int addrtTwoCommend(Article_commend_two article_commmend_two);

	/**
	 * 增加评论
	 * 
	 * @param article_id
	 * @return
	 */
	public int plusrtCommendCount(int article_id);

	/**
	 * 增加评论记录
	 * 
	 * @param commendRote
	 * @return
	 */
	public int addrtRoteCommend(CommendRote commendRote);
	/**
	 * 用户是否赞过
	 * @param article_id
	 * @param user_id
	 * @return
	 */
	public int countUpvote(@Param("article_id")int article_id,@Param("user_id")int user_id);
	/**
     * 获取分类
     * @return
     */
	public List<MSort> getSorts();
}
