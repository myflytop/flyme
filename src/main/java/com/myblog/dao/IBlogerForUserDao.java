package com.myblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myblog.dto.admin.AdUser;
import com.myblog.dto.args.AdUserArg;

/**
 * 管理对用户的相关操作
 * @author Administrator
 *
 */
public interface IBlogerForUserDao {
	/**
	 * 获取用户
	 * @return
	 */
	public List<AdUser> getUser(AdUserArg adUserArg);
   /**
    * 是否锁定用户
    * @param user_id
    * @param user_lock
    * @return
    */
	public int upUserlock(@Param("user_id")int user_id,@Param("user_lock") int user_lock);
	

}
