package com.myblog.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class ReturnUtils {
	    /**
	     * ajax 数据返回
	     * @param code 返回码 0请求失败,1 请求成功 ,-1 用户未登录  ,-2 用户被踢出  
	     * @param msg  返回消息
	     * @param object  返回数据
	     * @return
	     */
         public static String basicReturn(int code,String msg,Object object) {
        	  Map<String, Object> map=new HashMap<>();
        	  map.put("code", code);
        	  map.put("msg", msg);
        	  map.put("data", object);
        	  JSONObject jsonObject=JSONObject.fromObject(map);
        	 return jsonObject.toString();
         }
         /**
          * 基本请求数据返回
          * @param code
          * @param msg
          * @param object
          * @return
          */
         public static Map<String, Object> normlReturn(int code,String msg,Object object) {
       	  Map<String, Object> map=new HashMap<>();
       	  map.put("code", code);
       	  map.put("msg", msg);
       	  map.put("data", object);
       	 return map;
        }
         /**
          * ajax 请求异常返回
          * @param code
          * @param msg
          * @param object
          * @return
          */
         public static String basicExceptionReturn(int code,String msg,String ex,Object object) {
       	  Map<String, Object> map=new HashMap<>();
       	  map.put("code", code);
       	  map.put("ex", ex);
       	  map.put("msg", msg);
       	  map.put("data", object);
       	  JSONObject jsonObject=JSONObject.fromObject(map);
       	 return jsonObject.toString();
        }
         /**
          * 基本请求异常
          * @param code
          * @param msg
          * @param object
          * @return
          */
         public static Map<String, Object> normlExcptionReturn(int code,String msg,String ex,Object object) {
          	  Map<String, Object> map=new HashMap<>();
           	  map.put("code", code);
           	  map.put("ex", ex);
           	  map.put("msg", msg);
           	  map.put("data", object);	 
       	 return map;
        }
         
}
