package com.myblog.service;

import com.myblog.entity.Bloger;
import com.myblog.entity.Bloger_info;

public interface IBlogerService {
	/**
	 * 获取bloger密吗
	 * @param bloger_id
	 * @return Bloger
	 */
	Bloger getBloger(int bloger_id);
	/**
	 * 获取用户信息
	 * @param bloger_id
	 * @return
	 */
	Bloger_info getBloger_info(int bloger_id) ;
	/**
	 * 修改用户信息并返回
	 * @param bloger_id
	 * 
	 */
	Bloger_info updateBloger_info(Bloger_info bloger_info) ;
	/**
	 * 
	 * @param blogertab
	 * @param bloger_public
	 * @param bloger_id
	 * @return
	 */
	
	public String getBloger_profession(String bloger_public, int bloger_id);
	/**
	 * 
	 * @param bloger_public
	 * @param bloger_id
	 * @return
	 */
	
	public String getBloger_hobby(String bloger_public, int bloger_id);
	/**
	 *
	 * @param bloger_public
	 * @param bloger_id
	 * @return
	 */
	public String getBloger_imgurl(String bloger_public, int bloger_id);
	
	
}
