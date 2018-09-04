package com.myblog.web.bloger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.dto.MyArticle;
import com.myblog.dto.admin.AdUser;
import com.myblog.dto.args.AdUserArg;
import com.myblog.service.IBlogerForUserServiceImpl;
import com.myblog.service.user.IUserArticleServiceImpl;
import com.myblog.util.LayuiDataUtil;
import com.myblog.util.ReturnUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bloger/user")
public class AdUserConterol {
	 @Resource(name="blogerForUserService")
    private IBlogerForUserServiceImpl blogerForUserService;

	
	@RequestMapping(value="/getUser.do",produces="text/html; charset=utf-8")
	public@ResponseBody String getUser(@ModelAttribute("AdUserArg")AdUserArg adUserArg,@RequestParam("page")int page,@RequestParam("limit")int limit) {
		
		PageHelper.startPage(page, limit);
		PageInfo<AdUser> pageart=new PageInfo<AdUser>(blogerForUserService.getUser(adUserArg));
		LayuiDataUtil<AdUser> layuiDataUtil=new LayuiDataUtil<>(0, "获取成功", (int)pageart.getTotal(), pageart.getList());
		return JSONObject.fromObject(layuiDataUtil).toString();
	}
	@RequestMapping(value="/upUserlock.do",produces="text/html; charset=utf-8")
	public@ResponseBody String upUserlock(@RequestParam("user_id")int user_id,@RequestParam("user_lock")int user_lock) {
		if (blogerForUserService.upUserlock(user_id,user_lock)==1) {
			return ReturnUtils.basicReturn(1, "修改成功", null);
		}
		
		return ReturnUtils.basicReturn(0, "修改失败", null);
	}
	 
}
