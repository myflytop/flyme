package com.myblog.web.bloger;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.dto.Sys;
import com.myblog.entity.Article;
import com.myblog.sigar.SigarInfoEntity;
import com.myblog.sigar.SigarUtils;
import com.myblog.util.BasicUtil;
import com.myblog.util.LayuiDataUtil;
import com.myblog.util.ReturnUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bloger/sys")
public class SysConlterol {
    
	@RequestMapping(value = "/getsysinfo.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getsysinfo() {
		LayuiDataUtil<Sys> layuiDataUtil = new LayuiDataUtil<Sys>();
		layuiDataUtil.setCode(0);
		layuiDataUtil.setMsg("ok");
		List<Sys> syss=new ArrayList<>();
		List<SigarInfoEntity> sigarInfos = new ArrayList<>();
		try {
			sigarInfos.addAll(SigarUtils.getSysBasic());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=1;
		 for (SigarInfoEntity sigarInfo : sigarInfos) {
            syss.add(new Sys(i++,sigarInfo.getName(),sigarInfo.getValue()));
         }
		layuiDataUtil.setCount(syss.size());
		layuiDataUtil.setData(syss);
		return JSONObject.fromObject(layuiDataUtil).toString();
	}
	@RequestMapping(value = "/getwebinfo.do", produces = "text/html; charset=utf-8")
	public @ResponseBody String getwebinfo(HttpServletRequest request) {
		int i=1;
		/**
		 * 1.获取部署路径
		 * 2.获取运行时间
		 * 3.获取服务器ip
		 * 4.获取运行状态
		 * 
		 * 1.获取总访问量
		 * 2.获取单日访问量
		 * 3.获取总注册用户
		 * 4.获取单日注册用户
		 * 
		 */	
		LayuiDataUtil<Sys> layuiDataUtil = new LayuiDataUtil<Sys>();
		layuiDataUtil.setCode(0);
		layuiDataUtil.setMsg("ok");
		List<Sys> syss=new ArrayList<>();
		syss.add(new Sys(i++,"网站部署路径",request.getContextPath()));
		syss.add(new Sys(i++,"服务器运行时间",String.valueOf(BasicUtil.getTime(BasicUtil.getTime()-(long)request.getServletContext().getAttribute("startTime")))));
		
		
		
		layuiDataUtil.setCount(syss.size());
		layuiDataUtil.setData(syss);
		return JSONObject.fromObject(layuiDataUtil).toString();
	}
	
}
