package com.myblog.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.myblog.dto.Sys;

public class BasicUtil {
	public static int creCode() {
		int cod = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
		return cod;
	}

	public static boolean isEmail(String string) {
		if (string == null) {
			return false;
		}
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx1);
		m = p.matcher(string);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean boolPas(String pas) {
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		return pas.matches(regex);
	}

	public static Object encryptPsa(String pas, String sad) {
		String hashAlgorithmName = "MD5";// 加密方式String hashAlgorithmName = "MD5";//加密方式
		Object crdentials = pas;// 密码原值
		Object salt = sad;// 盐值
		int hashIterations = 2;// 加密2次
		Object result = new SimpleHash(hashAlgorithmName, crdentials, salt, hashIterations);
		return result;
	}

	/**
	 * 获取时间戳
	 * 
	 * @return
	 */
	public static long getTime() {

		return System.currentTimeMillis();
	}
	
	/**
	 * 时间戳转换为时间
	 * 
	 * @return
	 */
	public static String getTime(long time) {
        long day;//天
        long hour;//小时
        long minute;//分钟
        long second;//秒
       StringBuilder s=new StringBuilder();
        second=(long)(time/(long)1000);//取整数部分,总秒数
        if (second>59) {
             s.append(second%60+"秒");
             minute=(long)(second/60);//取整数部分,总分数  
             if (minute>0) {
                 s.insert(0,minute%60+"分:");
                 hour=(long)(minute/60);//总小时
                 if (hour>0) {
                     s.insert(0,hour%24+"时:");
                     day=(long)(hour/24);//总天
                     System.out.println(hour);
                     if (day>0) {
                         s.insert(0,day+"天:");
					}
                    
				}
			}
		}
       
        else {
        	s.append(second+"秒");
		}
     
        
        
        
      
		return s.toString();
	}
	
	public static List serverBasic(HttpServletRequest request) {
		List<Sys> list =new ArrayList<>();
		int i=1;
		list.add(new Sys(i,"网站部署路径",request.getContextPath()));
		
		
		return list;
	}
}
