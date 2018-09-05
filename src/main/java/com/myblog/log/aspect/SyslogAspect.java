package com.myblog.log.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * 1.前置通知
 * 2.后置通知
 * 3.环绕通知
 * 4.异常通知
 * 5.最终通知
 * 
 * @author Administrator
 *
 */
@Aspect
@Component
public class SyslogAspect {
	private  static  final Logger logger=LoggerFactory.getLogger(SyslogAspect.class);
	

	
	
	/**
     * 定义一个方法，用于声明切入点表达式，方法中一般不需要添加其他代码
     * 使用@Pointcut声明切入点表达式
     * 后面的通知直接使用方法名来引用当前的切点表达式
     */
	/*@Pointcut("execution(* com.myblog.web.user.*.*(..))")
    public void declearJoinPointExpression(){}*/
	/**
	 * Controller层切点 注解拦截
	 */
	@Pointcut("@annotation(com.myblog.log.aspect.Dolog)")
	public void declearJoinPointExpression(){}
    /**
	 * 前置通知 用于拦截Controller层记录用户的操作的开始时间
	 * @param joinPoint 切点
	 * @throws InterruptedException 
	 */
	@Before("declearJoinPointExpression()")
	public void doBefore(JoinPoint joinPoint) throws InterruptedException{
	System.out.println("前置");
	}
	
	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint 切点
	 */
	@After("declearJoinPointExpression()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("最终通知");
	}
	/**
	 *  异常通知 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "declearJoinPointExpression()", throwing = "e")  
	public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("异常");
		}
	
	//配置controller环绕通知,使用在方法aspect()上注册的切入点
	      /* @Around("declearJoinPointExpression()")
	      public void around(JoinPoint joinPoint){
	    	   System.out.println("环绕");
	 }*/
	       /**
	        * 后置通知
	        * @param joinPoint
	        */
	       @AfterReturning("declearJoinPointExpression()")
	       public void end(JoinPoint joinPoint){
	    	   System.out.println("后置");
	  	 }
	       
}
