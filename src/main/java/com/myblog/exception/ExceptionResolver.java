package com.myblog.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.myblog.util.ReturnUtils;

public class ExceptionResolver implements HandlerExceptionResolver {


	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.err.println("异常");
		ModelAndView modelAndView=null;
		 // 判断是否ajax请求
        if ((request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With") != null && request.getHeader(
                "X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                 // 如果是ajax请求，JSON格式返回
        	
        	 try {
        	        response.setCharacterEncoding("UTF-8");
        	        response.setContentType("text/html; charset=UTF-8");
        	        PrintWriter pw = response.getWriter();
        	        pw.write(ReturnUtils.basicExceptionReturn(-3, "请求异常", ex.toString(), null));
        	        pw.flush();
        	        pw.close();
        	    } catch (Exception e) {
        	        e.printStackTrace();
        	    }
        	
        }
        else {
        	System.err.println("fff");
        	
        	modelAndView=new ModelAndView("forward:/WEB-INF/err/errUnPowerNew.jsp");
        	System.out.println(ex.toString());
        	
        	modelAndView.addObject("msg",ReturnUtils.normlExcptionReturn(-3, "请求发生异常", ex.toString(), "运行异常"));
        }
        return modelAndView;
	}

}
