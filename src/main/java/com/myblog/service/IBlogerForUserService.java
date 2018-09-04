package com.myblog.service;

import java.util.List;

import com.myblog.dto.admin.AdUser;
import com.myblog.dto.args.AdUserArg;

/**
 * 管理对用户的相关操作
 * @author Administrator
 *
 */
public interface IBlogerForUserService {
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
	public int upUserlock(int user_id, int user_lock);

}
