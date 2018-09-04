package com.myblog;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myblog.util.BasicUtil;

public class BasicTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test1() {
		Object object=1;
		System.out.println((Integer)object);
	}
	@Test
	public void testint() {
		//Long 加L
		/*System.out.println((int)1.6);*/
		long a=106000*60*60*24L+1000L;
		System.out.println("---");
		System.out.println(a);
		System.out.println(BasicUtil.getTime(a));
		System.out.println((long)100000*60*60*24);
		System.out.println(((long)100000*60*60*24));
		
	}

}
