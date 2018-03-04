package com.myblog.dao.pub;

import com.myblog.entity.Blog_web_record;

/**
 * 公共Dao
 * @author Administrator
 *
 */
public interface IPubDao {
	//记录用户访问网站
    public int recordbower(Blog_web_record web_rocord);
}
