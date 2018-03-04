package com.myblog;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.dao.IArticleCommendDao;
import com.myblog.entity.Article_commend;
import com.myblog.entity.Article_commend_two;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration({"/spring-db.xml","/spring-mybatis.xml","/spring-service.xml","/spring-tx.xml"}) //加载配置文件  
  
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例  
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！  
//@Transactional  
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
//------------ 
public class Article_commmendtest {
	@Resource(name="IArticleCommendDao")
	private IArticleCommendDao articleCommendDao;
	
	
	@Test
  public void testaddcommend() {
	  Article_commend article_commmend=new Article_commend();
	  article_commmend.setArticle_id(1);
	  article_commmend.setCommend_con("testdao");
	  article_commmend.setUser_id(1);
	  articleCommendDao.addCommend(article_commmend);
	  System.out.println(article_commmend);
	  
  }    @Test
	  public void testauditCommend() {
		 System.out.println(articleCommendDao.auditCommend(1, 0));
		  
	  }
  @Test
  public void testrealdelCommend() {
	 System.out.println(articleCommendDao.delrealCommend(1));
	  
  }
  
   @Test
   public void testaddtwoCommend() {
	   Article_commend_two article_commend_two =new Article_commend_two();
	   article_commend_two.setCommend_id(2);
	   article_commend_two.setCommend_con("testtwo commend");
	   article_commend_two.setUser_replyid(1);
	   article_commend_two.setUser_toid(2);
	   articleCommendDao.addtwoCommend(article_commend_two);
	   System.out.println(article_commend_two);  
   }
   @Test
   public void testaudittwoCommend() {
 	  System.out.println(articleCommendDao.audittwoCommend(2, 1));
   }
   @Test
   public void testdeltworealCommend() {
 	  System.out.println(articleCommendDao.deltworealCommend(2));
   }
   @Test
   public void testgetCommends() {
 	  System.out.println(articleCommendDao.getCommends(1));
   }
	@Test
	public void test() {
		fail("Not yet implementedorg.springframework.dao.DataIntegrityViolationException: \r\n" + 
				"### Error querying database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'user_id' in field list is ambiguous\r\n" + 
				"### The error may exist in com/myblog/dao/IArticleCommendDao.xml\r\n" + 
				"### The error may involve com.myblog.dao.IArticleCommendDao.getCommends-Inline\r\n" + 
				"### The error occurred while setting parameters\r\n" + 
				"### SQL: select commend_id,commend_con,commend_time,article_id,user_id,user_img,user_name from article_commend,user_info where article_commend.article_id=? and  article_commend.commend_islock=0 and article_commend.user_id=user_info.user_id\r\n" + 
				"### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'user_id' in field list is ambiguous\r\n" + 
				"; SQL []; Column 'user_id' in field list is ambiguous; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'user_id' in field list is ambiguous\r\n" + 
				"	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:85)\r\n" + 
				"	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)\r\n" + 
				"	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)\r\n" + 
				"	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:75)\r\n" + 
				"	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:447)\r\n" + 
				"	at com.sun.proxy.$Proxy18.selectList(Unknown Source)\r\n" + 
				"	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:231)\r\n" + 
				"	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:137)\r\n" + 
				"	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)\r\n" + 
				"	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)\r\n" + 
				"	at com.sun.proxy.$Proxy25.getCommends(Unknown Source)\r\n" + 
				"	at com.myblog.Article_commmendtest.testgetCommends(Article_commmendtest.java:70)\r\n" + 
				"	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n" + 
				"	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n" + 
				"	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n" + 
				"	at java.lang.reflect.Method.invoke(Unknown Source)\r\n" + 
				"	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)\r\n" + 
				"	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\r\n" + 
				"	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)\r\n" + 
				"	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\r\n" + 
				"	at org.springframework.test.context.junit4.statements.RunBeforeTestMethodCallbacks.evaluate(RunBeforeTestMethodCallbacks.java:75)\r\n" + 
				"	at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:86)\r\n" + 
				"	at org.springframework.test.context.junit4.statements.SpringRepeat.evaluate(SpringRepeat.java:84)\r\n" + 
				"	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)\r\n" + 
				"	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:254)\r\n" + 
				"	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:89)\r\n" + 
				"	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n" + 
				"	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n" + 
				"	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n" + 
				"	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n" + 
				"	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n" + 
				"	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)\r\n" + 
				"	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)\r\n" + 
				"	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n" + 
				"	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:193)\r\n" + 
				"	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n" + 
				"	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n" + 
				"	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n" + 
				"	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n" + 
				"	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n" + 
				"	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\n" + 
				"Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'user_id' in field list is ambiguous\r\n" + 
				"	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n" + 
				"	at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n" + 
				"	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n" + 
				"	at java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n" + 
				"	at com.mysql.jdbc.Util.handleNewInstance(Util.java:389)\r\n" + 
				"	at com.mysql.jdbc.Util.getInstance(Util.java:372)\r\n" + 
				"	at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:973)\r\n" + 
				"	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3835)\r\n" + 
				"	at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3771)\r\n" + 
				"	at com.mysql.jdbc.MysqlIO.sendCommand(MysqlIO.java:2435)\r\n" + 
				"	at com.mysql.jdbc.MysqlIO.sqlQueryDirect(MysqlIO.java:2582)\r\n" + 
				"	at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2535)\r\n" + 
				"	at com.mysql.jdbc.PreparedStatement.executeInternal(PreparedStatement.java:1911)\r\n" + 
				"	at com.mysql.jdbc.PreparedStatement.execute(PreparedStatement.java:1203)\r\n" + 
				"	at com.mchange.v2.c3p0.impl.NewProxyPreparedStatement.execute(NewProxyPreparedStatement.java:989)\r\n" + 
				"	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n" + 
				"	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n" + 
				"	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n" + 
				"	at java.lang.reflect.Method.invoke(Unknown Source)\r\n" + 
				"	at org.apache.ibatis.logging.jdbc.PreparedStatementLogger.invoke(PreparedStatementLogger.java:59)\r\n" + 
				"	at com.sun.proxy.$Proxy30.execute(Unknown Source)\r\n" + 
				"	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)\r\n" + 
				"	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)\r\n" + 
				"	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)\r\n" + 
				"	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)\r\n" + 
				"	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)\r\n" + 
				"	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)\r\n" + 
				"	at com.github.pagehelper.PageInterceptor.intercept(PageInterceptor.java:141)\r\n" + 
				"	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)\r\n" + 
				"	at com.sun.proxy.$Proxy28.query(Unknown Source)\r\n" + 
				"	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)\r\n" + 
				"	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:141)\r\n" + 
				"	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n" + 
				"	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n" + 
				"	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n" + 
				"	at java.lang.reflect.Method.invoke(Unknown Source)\r\n" + 
				"	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:434)\r\n" + 
				"	... 36 more\r\n" + 
				"\r\n" + 
				"");
	}

}
