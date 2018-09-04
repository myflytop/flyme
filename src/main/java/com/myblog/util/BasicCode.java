package com.myblog.util;
//code 返回码 0请求失败,1 请求成功 ,-1 用户未登录  ,-2 用户被踢出 
public class BasicCode {
 //请求失败
   public static final int FAIL=0;
 //请求成功
   public static final int SUCCESS=1;
 //请求用户未登陆
   public static final int NOLOGIN=-1;
 //请求用户被踢出
   public static final int KITOUT=-2;
   
}
