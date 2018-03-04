package com.myblog.web.bloger;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.entity.Sort_article;
import com.myblog.service.Sort_articleServiceImle;
import com.myblog.util.LayuiDataUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bloger/sort")
public class SortControl {
	@Autowired
	@Qualifier("sort_articleService")
	private Sort_articleServiceImle sort_articleService;

	public Sort_articleServiceImle getSort_articleService() {
		return sort_articleService;
	}

	public void setSort_articleService(Sort_articleServiceImle sort_articleService) {
		this.sort_articleService = sort_articleService;
	}
	
	@RequestMapping(value="/getSorts.do",produces = "text/html; charset=utf-8" )
  public @ResponseBody String getSorts(@RequestParam("page")int page,@RequestParam("limit")int limit)
  {  
		LayuiDataUtil<Sort_article> sor=new LayuiDataUtil<>();
		  sor.setCode(0);
		  sor.setCount(100);
		  sor.setMsg("");
		  sor.setData(sort_articleService.getSorts());
		  JSONObject jsonObject=JSONObject.fromObject(sor);
		return jsonObject.toString();
  }
	
	@RequestMapping(value="/addSort.do",produces = "text/html; charset=utf-8" )
	  public @ResponseBody String addSort(@RequestParam("sort_article_name")String sort_article_name)
	  { Sort_article sort_article=new Sort_article(null, sort_article_name);
	  
	  Map<String,Object> oMap=new HashMap<String, Object>();
		 if (boName(sort_article_name)) {
				oMap.put("code", "success");
				oMap.put("data", sort_articleService.addSort(sort_article));
			}
		 else {
			 oMap.put("code", "fail");
			 
		 }
	  
	  
		
		 
		/*  sor.setData(sort_articleService.addSort(sort_article));*/
		  JSONObject jsonObject=JSONObject.fromObject(oMap);
		return jsonObject.toString();
	  }
	@RequestMapping(value="/reSortname.do",produces = "text/html; charset=utf-8" )
	  public @ResponseBody String reSortname(@Valid @ModelAttribute("sort_article")Sort_article sort_article,BindingResult result)
	  {  
		Map<String,Object> oMap=new HashMap<String, Object>();
		 if (boName(sort_article.getSort_article_name())&&!result.hasErrors()) {
				oMap.put("code", "success");
				oMap.put("data", sort_articleService.reSortname(sort_article));
			}
		 else {
			 oMap.put("code", "fail");
			 
		 }
		System.out.println(result.hasErrors()+"reSort");
			
			
			 
			/*  sor.setData(sort_articleService.reSortname(sort_article));*/
			  JSONObject jsonObject=JSONObject.fromObject(oMap);
			return jsonObject.toString();
	  }

	@RequestMapping(value="/delSort.do",produces = "text/html; charset=utf-8" )
	  public @ResponseBody String delSort(@RequestParam("sort_article_id")int sort_article_id)
	  {
		Map<String,Object> oMap=new HashMap<String, Object>();
		 if (sort_articleService.delSort(sort_article_id)==1) {
				oMap.put("code", "success");
				
			}
		 else {
			 oMap.put("code", "fail");
			 
		 }
		/*  sor.setData(sort_articleService.delSort(sort_article_id));*/
		  JSONObject jsonObject=JSONObject.fromObject(oMap);
		return jsonObject.toString();
	  }
	
	private boolean boName(String sortNa) {
		if(sort_articleService.countsort(sortNa)==0)
		{
		return true;
	}
		else {
		return false;
			
		}
	}
}
