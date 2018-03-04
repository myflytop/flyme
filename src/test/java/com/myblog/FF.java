
package com.myblog;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.myblog.util.BasicUtil;

public class FF {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
  public void ff() {
		
  }
	@Test
public void g() {
		System.out.println(BasicUtil.encryptPsa("723586130@qq.com", "723586130@qq.com").toString());
	}
	@Test
	public void gh() {
		String[] fgg="30.png".split("\\.") ;
		System.out.println(fgg[0]);
		
		StringBuilder fileo=new StringBuilder();
		fileo.append(123).append(".");
		System.out.println(fileo.toString());
		
		
	}
	@Test
	public void ghf() {
		String num="1.23.png";
	  String d=	num.substring(num.lastIndexOf(".") + 1).    
        trim().toLowerCase();
		System.out.println(d);
	}
	@Test
	public void gtime() {
		Date dt=new Date();
		System.out.println(dt.getTime());
	}
	
}
