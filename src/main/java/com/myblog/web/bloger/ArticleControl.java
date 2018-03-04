package com.myblog.web.bloger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.dto.MSort;
import com.myblog.dto.MyArticle;
import com.myblog.dto.args.ArticleArg;
import com.myblog.entity.Article;
import com.myblog.service.ArticleServiceImpl;
import com.myblog.util.LayuiDataUtil;
import com.myblog.util.ReturnUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bloger/article")
public class ArticleControl {
	@Resource(name = "articleService")
	private ArticleServiceImpl articleService;
	public ArticleServiceImpl getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleServiceImpl articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(value = "/addArticle.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String addArticle(@ModelAttribute("Article") Article article) {
		String msg="";
		int code=1;
		if (articleService.addArticle(article) == 1) {
			msg = "添加成功";
		} else
		{
			msg = "添加失败";
			code=0;
		}
		return ReturnUtils.basicReturn(code, msg, null);
	}

	@RequestMapping(value = "/getSorts.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getSorts() {
		Map<String, Object> msortmap = new HashMap<>();
		List<MSort> mSorts = articleService.getSorts();
		if (mSorts.size() > 0) {
			msortmap.put("data", mSorts);
			msortmap.put("code", "success");
		} else {
			msortmap.put("code", "fail");
		}
		return JSONObject.fromObject(msortmap).toString();
	}

	@RequestMapping(value = "/getArticlelist.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getArticlelist(@ModelAttribute("articleArg") ArticleArg articleArg,@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) {
		 System.out.println(articleArg);
		LayuiDataUtil<MyArticle> layuiData=new LayuiDataUtil<MyArticle>();
       PageHelper.startPage(page, limit);
       PageInfo<MyArticle> pageart=new PageInfo<MyArticle>(articleService.getArticleList(articleArg));
		layuiData.setCode(0);
		layuiData.setMsg("");
		layuiData.setData(pageart.getList());
		layuiData.setCount((int)pageart.getTotal());
		return JSONObject.fromObject(layuiData).toString();
	}
	@RequestMapping(value = "/getArticle.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getArticle(@RequestParam("article_id") int article_id) {
		
		return JSONObject.fromObject(articleService.getArticle(article_id)).toString();
	}
}
