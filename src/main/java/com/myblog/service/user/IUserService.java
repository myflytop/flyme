package com.myblog.service.user;
import org.apache.ibatis.javassist.runtime.Inner;

import com.myblog.dto.BasicUser;
import com.myblog.dto.user.UserBasic;
import com.myblog.entity.User;

public interface IUserService {
	/**
	 * 统计用户邮箱
	 * @param mail
	 * @return
	 */
public int countMail(String mail);
/**
 * 添加用户
 * @param user
 * @return
 */
public int addUser(User user);
/**
 * 获取用户基本信息
 * @return
 */
public BasicUser getBasicUser(String parm);
/**
 * 更新用户登录ip
 * @param user_id
 * @param user_lastip
 * @return
 */
public int upUserLoginIp(int user_id,String user_lastip );
/**
 * 更新用户头像
 * @param user_id
 * @param user_img
 * @return
 */
public String upUserHeard(int user_id,String user_img);
/**
 * 获取用户资料
 * @param user_id
 * @return
 */
public UserBasic getUserBasic(int user_id);
/**
 * 修改用户资料
 * @param userBasic
 */
public int upUser(UserBasic userBasic);
}
