package com.myblog.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.shiro.crypto.hash.SimpleHash;

public class BasicUtil {
  public static int creCode() {
	  int cod=(int)(Math.random()*(9999-1000+1))+1000;
	  return cod;
  }
  public static boolean isEmail(String string) {
      if (string == null)
          return false;
      String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
      Pattern p;
      Matcher m;
      p = Pattern.compile(regEx1);
      m = p.matcher(string);
      if (m.matches())
          return true;
      else
          return false;
  }
  public static boolean boolPas(String pas) { 
	  String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
	  return pas.matches(regex);
  }
  public static Object encryptPsa(String pas,String sad) {
	  String hashAlgorithmName="MD5";//加密方式String hashAlgorithmName = "MD5";//加密方式  
	    Object crdentials = pas;//密码原值  
	    Object salt = sad;//盐值  
	    int hashIterations = 2;//加密2次  
	    Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);  
	  return result;
  }
  /**
   * 获取时间戳
   * @return
   */
  public static long getTime() {
	  
	  return new Date().getTime();
  }
}
