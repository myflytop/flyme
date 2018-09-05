package com.myblog.web.user;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.dto.MSort;
import com.myblog.dto.args.BlogCommend;
import com.myblog.dto.args.SearchArtArg;
import com.myblog.dto.user.MyArticleAll;
import com.myblog.dto.user.MyUserArticle_title;
import com.myblog.entity.Blog_web_record;
import com.myblog.entity.rote.ReadRote;
import com.myblog.entity.rote.UpvoteRote;
import com.myblog.log.aspect.Dolog;
import com.myblog.service.user.IUserArticleService;
import com.myblog.shiro.LoginType;
import com.myblog.util.CusAccessObjectUtil;
import com.myblog.util.LayuiDataUtil;
import com.myblog.util.ReturnUtils;
import com.myblog.util.WebRecordUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
@Controller
@RequestMapping("/user/basic")
public class UserBasicControl {
	private static final String USER_LOGIN_TYPE = LoginType.USER.toString();
	@Resource(name="userArticleService")
	private IUserArticleService userArticleService;
	/**
	 * 获取文章列表
	 * @return
	 */
	@RequestMapping(value = "/getArticleTitle.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getArticlelist() {
		return JSONArray.fromObject(userArticleService.getArticleTitle(null)).toString();
	}
	/**
	 * 获取文章及评论
	 * @param article_id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getSorts.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getSorts() {
		Map<String, Object> msortmap = new HashMap<>();
		List<MSort> mSorts = userArticleService.getSorts();
		if (mSorts.size() > 0) {
			msortmap.put("data", mSorts);
			msortmap.put("code", "success");
		} else {
			msortmap.put("code", "fail");
		}
		return JSONObject.fromObject(msortmap).toString();
	}
	
	@RequestMapping(value = "/getArticleAll.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getArticleAll(@RequestParam("article_id")int article_id,HttpServletRequest request) {
		MyArticleAll myArticleAll=userArticleService.getArticleAll(article_id);	            
		if (myArticleAll!=null) {
			Blog_web_record bl=WebRecordUtils.getAgent(request, getUser());
						userArticleService.addrtRead(new ReadRote(null, getUser(), bl.getRecord_ip(), null, article_id,bl.getRecord_brow(),bl.getRecord_dervice()));
					}
		
		return JSONObject.fromObject(myArticleAll).toString();
	}
	/**
	 * 获取文章标题
	 * @param page
	 * @param se
	 * @return
	 */
  @Dolog
	@RequestMapping(value = "/getArticleTitles.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getArticlelist(@RequestParam("page")int  page,@ModelAttribute("SearchArtArg")SearchArtArg se)  {
		System.err.println(page);
		System.err.println(se);
		List<MyUserArticle_title> titles=new ArrayList<MyUserArticle_title>();
		PageHelper.startPage(page, 10);
		titles=userArticleService.getArticleTitle(se);
		PageInfo<MyUserArticle_title> pageInfo=new PageInfo<MyUserArticle_title>(titles);
	    LayuiDataUtil<MyUserArticle_title> layuiDataUtil=new LayuiDataUtil<>();
	    layuiDataUtil.setData(titles);
	    layuiDataUtil.setCode(200);
	    layuiDataUtil.setMsg("success");
	    layuiDataUtil.setCount((int)pageInfo.getTotal());
		return JSONObject.fromObject(layuiDataUtil).toString();
	}
	
	/**
	 * 赞
	 * @param article_id
	 * @param user_id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addUpvote.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String addUpvote(@RequestParam("article_id")int article_id,@RequestParam("user_id")int user_id,HttpServletRequest request)  {
		int re=0;
		String msg="";
		if (user_id==getUser()) {
		if (userArticleService.countUpvote(article_id, user_id)==0 ) {
			if (userArticleService.addrtUpvote(new UpvoteRote(null, getUser(), article_id, CusAccessObjectUtil.getIpAddress(request), null))==1) {
				re=1;
				msg="点赞成功";
			}
			else {
				msg="点赞失败";
			}
		}
		
		else {
			msg="不能重复点赞，或者系统异常";
		}
		}
		else {
			msg="认证用户不符，或者用户未认证";
		}
		
		return ReturnUtils.basicReturn(re, msg, null);
	}
	@RequestMapping(value = "/addCommend.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String addCommend(@ModelAttribute("BlogCommend") BlogCommend blogCommend,HttpServletRequest request)  {
		int re=1;
		Map<String, Object> map=null;
		String msg="";
		if (getUser()==blogCommend.getUser_id()) {	
			map=new HashMap<>();
			if (blogCommend.getComtype()==1) {
				map.put("article_id", blogCommend.getArticle_id());
		    	map.put("comtype", blogCommend.getComtype());
		    	map.put("user_id", blogCommend.getUser_id());
		    	map.put("commend_id", blogCommend.getCommend_id());
		    	map.put("commend_ip", CusAccessObjectUtil.getIpAddress(request));
		    	map.put("commend_con", blogCommend.getCommend_con());
		    	if (userArticleService.addrtCommend(map)==1) {
		    		msg ="添加一级评论成功";
				}
		    	else {
		    		msg ="添加一级评论失败";	
		    	}
			}
			else if (blogCommend.getComtype()==2&&blogCommend.getUser_id()!=blogCommend.getUser_toid()) {
				map.put("article_id", blogCommend.getArticle_id());
		    	map.put("comtype", blogCommend.getComtype());
		    	map.put("user_replyid", blogCommend.getUser_id());
		    	map.put("user_toid", blogCommend.getUser_toid());
		    	map.put("commend_id", blogCommend.getCommend_id());
		    	map.put("commend_ip", CusAccessObjectUtil.getIpAddress(request));
		    	map.put("commend_con", blogCommend.getCommend_con());
		    	if (userArticleService.addrtCommend(map)==1) {
		    		msg ="添加二级评论成功";
				}
		    	else {
		    		msg ="添加二级评论失败";	
		    	}
			}
			else {
				re=0;
				msg ="参数错误";
			}
			
		}
		else {
			re=0;
			msg ="登陆不符";
		}
		return ReturnUtils.basicReturn(re, msg, map);
	}
	/**
	 * 获取用户是否点赞
	 * @param user_id
	 * @param article_id
	 * @return
	 */
	@RequestMapping(value = "/countUpvote.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String countUpvote(@RequestParam("user_id")int user_id,@RequestParam("article_id")int article_id)  {
		   int recode=0;
		   String msg="";
		   if(user_id==getUser())
		    {
		    	if (userArticleService.countUpvote(article_id, user_id)==1) {
					recode=1;
				}
		    	else {
		    		msg="系统错误或者用户未点赞!";
		    	}
		    }
		   else {
			   msg="用户未登录或者登陆不符!";
		   }
		return ReturnUtils.basicReturn(recode, msg, null);
	}
	@RequestMapping(value = "/getArticleStar.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getArticleStar()  {
		
		return userArticleService.getAreicleStar();
	}
	
	private Integer getUser() {
		Subject currentUser = SecurityUtils.getSubject();
		Object gObject=currentUser.getPrincipal();
	    Integer principal=null;
	    if (gObject==null||"".equals(gObject.toString())) {
			principal=null;
		}
	    else {
			principal=Integer.valueOf(gObject.toString());
		}
		boolean getu = USER_LOGIN_TYPE.equals((String)currentUser.getSession().getAttribute("loginType"));
		
		if (principal==null||!getu) {
			principal=-1;
		}
		return principal;
	}
	
}
