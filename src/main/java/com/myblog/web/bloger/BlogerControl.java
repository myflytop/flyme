package com.myblog.web.bloger;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myblog.entity.Bloger_info;
import com.myblog.service.BlogerServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/bloger")
public class BlogerControl {
	 @Autowired
	 @Qualifier("blogerService")
     private BlogerServiceImpl blogerService;
	
	 @RequestMapping(value="/blogerData_info.do",produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	  public @ResponseBody String getbloerinfo(@RequestParam("bloger_id")int bloger_id)throws IOException
	  {
		 return JSONObject.fromObject(blogerService.getBloger_info(bloger_id)).toString();
	  }
	 @RequestMapping(value="/blogerData_hobby.do",produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	  public @ResponseBody String getbloer_hobby(@RequestParam("bloger_id")int bloger_id,@RequestParam("mydata")String mydata)throws IOException
	  {
		 return JSONArray.fromObject(blogerService.getBloger_hobby(mydata, bloger_id)).toString();
	  }
	 @RequestMapping(value="/blogerData_profession.do",produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	  public @ResponseBody String getbloer_profession(@RequestParam("bloger_id")int bloger_id,@RequestParam("mydata")String mydata)throws IOException
	  {
		
		 return JSONArray.fromObject(blogerService.getBloger_profession(mydata, bloger_id)).toString();
	  }
	 @RequestMapping(value="/blogerData_imgurl.do",produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	  public @ResponseBody String getbloer_imgurl(@RequestParam("bloger_id")int bloger_id,@RequestParam("file") MultipartFile file,HttpServletRequest request)throws IOException
	  {
		 JSONObject jsonObject=new JSONObject();
		   if(!file.isEmpty()){  
	            try {  
	                  
	            	String realPath = request.getSession().getServletContext().getRealPath("/upload");   
	                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,   
	                        file.getOriginalFilename()));  
	           System.out.println(realPath);
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }
		StringBuilder bloger_imgurl=new StringBuilder(request.getContextPath());
		bloger_imgurl.append("/upload/").append(file.getOriginalFilename());
		 jsonObject.put("data", blogerService.getBloger_imgurl(bloger_imgurl.toString(), bloger_id));
		 jsonObject.put("msg", 200);
		 return  jsonObject.toString();
	  }
	 
	 @RequestMapping(value="/updateBloger_info.do",produces = "text/html; charset=utf-8",method=RequestMethod.POST)
	  public @ResponseBody String updateBloger_info(@ModelAttribute("bloger_info")Bloger_info bloger_info)throws IOException
	  {
		 
		 System.err.println(bloger_info);
		 
		 
		 return JSONObject.fromObject(blogerService.updateBloger_info(bloger_info)).toString();
	  }
}