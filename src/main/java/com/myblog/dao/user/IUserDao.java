package com.myblog.dao.user;

import org.apache.ibatis.annotations.Param;

import com.myblog.dto.BasicUser;
import com.myblog.dto.user.UserBasic;
import com.myblog.entity.User;
import com.myblog.entity.User_info;

public interface IUserDao {
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
 * 获取用户信息
 * @param user_info
 * @return
 */
public int addUser_info(User_info user_info);
/**
 * 获取用户邮箱，密码，mail通过id
 * @param user_id
 * @return
 */
public BasicUser getUserPasbyid(int user_id);
/**
 * 获取用户邮箱，密码，mail通过mail
 * @param user_id
 * @return
 */
public BasicUser getUserPasbymail(String user_mail);
/**
 * 用户最后登录时间
 * @param user_id
 * @param user_lastip
 * @return
 */
public int upUserLoginIp(@Param("user_id") int user_id,@Param("user_lastip")String user_lastip );
/**
 * 更新用户头像
 * @param user_id
 * @param user_img
 * @return
 */
public int upUserHeard(@Param("user_id")int user_id,@Param("user_img")String user_img);
/**
 * 获取用户头像
 * @param user_id
 * @return
 */
public String gerUserHeard(int user_id);
/**
 * 获取用户资料
 * @param user_id
 * @return
 */
public UserBasic getUserBasic(int user_id);
/**
 * 修改用户资料
 * @param userBasic
 * @return
 */
public int upUser(UserBasic userBasic);
}
