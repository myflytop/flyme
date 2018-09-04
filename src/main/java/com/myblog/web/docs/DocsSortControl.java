package com.myblog.web.docs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.entity.DocsSort;
import com.myblog.service.docs.DocsServiceImpl;
import com.myblog.service.docs.DocsSortServiceImpl;
import com.myblog.util.BasicCode;
import com.myblog.util.BasicUtil;
import com.myblog.util.ReturnUtil;
import com.myblog.util.ReturnUtils;
import com.myblog.util.ValidUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bloger/user/docs")
public class DocsSortControl {
	@Resource(name = "docsSortService")
	private DocsSortServiceImpl docsSortService;

	@RequestMapping(value = "/addDocsSort.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String addDocsSort(@Valid @ModelAttribute("DocsSort") DocsSort docsSort,
			BindingResult result) {
		String re = null;
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			List<String> errMsg = new ArrayList<>();
			for (ObjectError objectError : errors) {
				errMsg.add(objectError.getDefaultMessage());
				// 获取类名
				/* System.out.println(objectError.getObjectName()); */
				// 获取提示消息
				/* System.out.println(objectError.getDefaultMessage()); */
				// 获取验证类型
				/* System.out.println(objectError.getCode()); */
			}
			re = ReturnUtils.basicReturn(BasicCode.SUCCESS, "输入错误", errMsg);
		} else {
			if(docsSortService.countSortName(docsSort.getDocsSortname(),docsSort.getUserId())==0){
			if (docsSortService.addDocsSort(docsSort) == 1) {
				re = ReturnUtils.basicReturn(BasicCode.SUCCESS, "文档分类添加成功", docsSort.getDocsSortid());
			} else {
				re = ReturnUtils.basicReturn(BasicCode.FAIL, "添加失败", null);
			}
			}
			else {
				re=ReturnUtils.basicReturn(-5, "分类名重复", null);
			}

		}

		return re;
	}

	@RequestMapping(value = "/editDocsSort.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String  editDocsSort(@RequestParam("docsSortname")String docsSortname,@RequestParam("docsSortid")long docsSortid,@RequestParam("userId")long userId) {
		String re =null;
		DocsSort docsSort=new DocsSort();
		docsSort.setDocsSortname(docsSortname);
		docsSort.setDocsSortid(docsSortid);
		if (!ValidUtils.isName(docsSortname)) {
			re=ReturnUtils.basicReturn(-4, "分类名不符合规范", null);
		}
		else
		{
			if(docsSortService.countSortName(docsSortname,userId)==0){
				if(docsSortService.updateDocsSort(docsSort)==1) {
					re=JSONObject.fromObject(ReturnUtil.Success("Success")).toString();
				}
				else {
					re=JSONObject.fromObject(ReturnUtil.Fail("Fail")).toString();
				}
				
			}
			else {
				re=ReturnUtils.basicReturn(-5, "分类名重复", null);
			}
			
		}
		
		return re;
	}

	@RequestMapping(value = "/delDocsSort.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String delDocsSort(int docsSortid, int docsSortstatus) {
		String re = null;
		if (docsSortService.delDocsSort(docsSortid, docsSortstatus) == 1) {
			re = JSONObject.fromObject(ReturnUtil.Success("success")).toString();
		} else {
			re = JSONObject.fromObject(ReturnUtil.Fail("Fail")).toString();
		}
		return re;
	}

	@RequestMapping(value = "/getDocsSorts.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getDocsSorts(@ModelAttribute("DocsSort") DocsSort docsSort, int page, int limit) {

		return JSONObject.fromObject(docsSortService.getDocsSorts(docsSort, page, limit)).toString();
	}

}
