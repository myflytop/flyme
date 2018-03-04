package com.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myblog.dao.IBlogerDao;
import com.myblog.entity.Bloger;
import com.myblog.entity.Bloger_info;
@Service("blogerService")
public class BlogerServiceImpl implements IBlogerService {
	@Autowired
	@Qualifier("IBlogerDao")
    private IBlogerDao blogerDao;
	public IBlogerDao getBlogerDao() {
		return blogerDao;
	}
	public void setBlogerDao(IBlogerDao blogerDao) {
		this.blogerDao = blogerDao;
	}
	@Override
	public Bloger getBloger(int bloger_id) {
		// TODO Auto-generated method stub
		
		return blogerDao.getBloger(bloger_id);
	}
	@Override
	public Bloger_info getBloger_info(int bloger_id) {
		// TODO Auto-generated method stub
		return blogerDao.getBloger_info(bloger_id);
	}
	@Override
	public Bloger_info updateBloger_info(Bloger_info bloger_info) {
		// TODO Auto-generated method stub
		blogerDao.updateBloger_info(bloger_info);
		
		return blogerDao.getBloger_info(bloger_info.getBloger_id());
	}
	@Override
	public String getBloger_profession( String bloger_profession, int bloger_id) {
		// TODO Auto-generated method stub
		blogerDao.upadteBloger_profession(bloger_profession, bloger_id);
		return blogerDao.getBloger_profession(bloger_id);
	}
	@Override
	public String getBloger_hobby(String bloger_hobby, int bloger_id) {
		// TODO Auto-generated method stub
		
		blogerDao.updateBloger_hobby( bloger_hobby, bloger_id);
		return blogerDao.getBloger_hobby( bloger_id);
	}
	@Override
	public String getBloger_imgurl(String bloger_imgurl, int bloger_id) {
		// TODO Auto-generated method stub
		blogerDao.updateBloger_imgurl( bloger_imgurl, bloger_id);
		return blogerDao.getBloger_imgurl(bloger_id);
	}
	

}
