package com.myblog.service.user;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myblog.dao.user.IUserDao;
import com.myblog.dto.BasicUser;
import com.myblog.dto.user.UserBasic;
import com.myblog.entity.Blog_web_record;
import com.myblog.entity.User;
import com.myblog.entity.User_info;
@Service("userService")
public class IUserServiceImpl implements IUserService {
	@Resource(name="IUserDao")
    private  IUserDao userDao;
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int countMail(String mail) {
		// TODO Auto-generated method stub
		return userDao.countMail(mail);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int re=0;
		User_info user_info=new User_info();
		if (userDao.addUser(user)==1) {
			user_info.setUser_id(user.getUser_id());
			user_info.setUser_name("cf"+user.getUser_id());
			user_info.setUser_img("http://welphen.cn/upload/image/20170921/14a58b48908748169d3db56b901e9cf6.jpg");
			userDao.addUser_info(user_info);
			re=1;
		};
		return re;
	}

	@Override
	public BasicUser getBasicUser(String parm) {
		BasicUser basicUser;
		try {
			int user_id=Integer.parseInt(parm);
		basicUser=userDao.getUserPasbyid(user_id);
		} catch (Exception e) {
			if (userDao.countMail(parm)==1) {
				basicUser=userDao.getUserPasbymail(parm);
			}
			else {
				basicUser=null;
			}
		}
		// TODO Auto-generated method stub
		return basicUser;
	}

	@Override
	public int upUserLoginIp(int user_id, String user_lastip) {
		// TODO Auto-generated method stub
		return userDao.upUserLoginIp(user_id, user_lastip);
	}

	@Override
	public String upUserHeard(int user_id, String user_img) {
		// TODO Auto-generated method stub
		String uString="";
		if(userDao.upUserHeard(user_id, user_img)==1)
		    {
		 uString=userDao.gerUserHeard(user_id);
		    }
		return uString;
	}

	@Override
	public UserBasic getUserBasic(int user_id) {
		
		return userDao.getUserBasic(user_id);
	}

	@Override
	public int upUser(UserBasic userBasic) {
		// TODO Auto-generated method stub
		return userDao.upUser(userBasic);
	}
	@Override
	public int adduser_recordlogin(Blog_web_record bl) {
		// TODO Auto-generated method stub
		userDao.upUserLoginIp(Integer.valueOf(bl.getRecord_user()), bl.getRecord_ip());
		 
		return userDao.addRecordlogin(bl);
	}

}
