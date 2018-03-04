package com.myblog.dao;

import org.apache.ibatis.annotations.Param;

import com.myblog.entity.Bloger;
import com.myblog.entity.Bloger_info;

public interface IBlogerDao {
	/**
	 * 获取bloger对象
	 * @param bloger_id
     * @return Bloger
	 */
	Bloger getBloger(int bloger_id);
	/**
	 * 修改bloger密码
	 * @param bloger_id
     * @return Bloger
	 */
	void updateBloger(Bloger bloger);
	/**
	 * 获取用户信息
	 * @param bloger_id
	 * @return
	 */
	Bloger_info getBloger_info(int bloger_id) ;
	/**
	 * 修改用户信息
	 * @param bloger_id
	 * 
	 */
	void updateBloger_info(Bloger_info bloger_info) ;
	/**
	 * 获取头像路径
	 * @param bloger_id
	 * @return
	 */
   public String getBloger_imgurl(int bloger_id);
	/**
	 * 修改用管理头像
	 * @param bloger_id
	 * 
	 */	
	void updateBloger_imgurl(@Param("bloger_imgurl") String bloger_imgurl,@Param("bloger_id") int bloger_id) ;
	/**
	 * 获取职业
	 * @param bloger_id
	 * @return
	 */
   public String getBloger_profession(int bloger_id);
	/**
	 * 添加,删除管理职业
	 * @param bloger_id
	 * 
	 */	
	void upadteBloger_profession(@Param("bloger_profession")String bloger_profession, @Param("bloger_id")int bloger_id) ;
	/**
	 * 获取标签
	 * @param bloger_id
	 * @return
	 */
   public String getBloger_hobby(int bloger_id);
	/**
	 * 添加，删除管理标签
	 * @param bloger_id
	 * 
	 */	
	void updateBloger_hobby(@Param("bloger_hobby")String bloger_profession, @Param("bloger_id")int bloger_id) ;
	/**
	 * 
	 * @param blogerfiled 要修改的字段
	 * @param bloger_public 数据
	 * @param bloger_id
	 */
	void updateBloger_public(@Param("blogerfiled")String blogerfiled,@Param("bloger_public")String bloger_public, @Param("bloger_id")int bloger_id) ;
	/**
	 * 
	 * @param bloger_public 查询的数据
	 * @param bloger_id
	 * @return
	 */
     public	String  getBloger_public (@Param("bloger_public")String bloger_public, @Param("bloger_id")int bloger_id);
	
}
