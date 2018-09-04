package com.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.myblog.dao.IBlogerForUserDao;
import com.myblog.dto.admin.AdUser;
import com.myblog.dto.args.AdUserArg;
@Service("blogerForUserService")
public class IBlogerForUserServiceImpl implements IBlogerForUserService {
	@Autowired
	@Qualifier("IBlogerForUserDao")
     private IBlogerForUserDao blogerForUserDao;
	@Override
	public List<AdUser> getUser(AdUserArg adUserArg) {
		// TODO Auto-generated method stub
		return blogerForUserDao.getUser(adUserArg);
	}
	public IBlogerForUserDao getBlogerForUserDao() {
		return blogerForUserDao;
	}
	public void setBlogerForUserDao(IBlogerForUserDao blogerForUserDao) {
		this.blogerForUserDao = blogerForUserDao;
	}
	@Override
	public int upUserlock(int user_id, int user_lock) {
		// TODO Auto-generated method stub
		return blogerForUserDao.upUserlock(user_id,user_lock);
	}

}
