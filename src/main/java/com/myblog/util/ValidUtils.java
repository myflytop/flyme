package com.myblog.util;

import java.util.regex.Pattern;

public class ValidUtils {
	
	
	public static boolean isName(String name) {
		String rex="^[\\u0391-\\uFFE5A-Za-z]{2,12}$";
		return Pattern.matches(rex,name);
	}
	public static boolean isName(String name,int start,int end) {
		String rex="^[\\u0391-\\uFFE5A-Za-z]{"+start+","+end+"}$";
		return Pattern.matches(rex,name);
	}
   public static boolean isId() {
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println(ValidUtils.isName("*"));
	}

}
