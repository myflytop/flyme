package com.myblog;

import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.myblog.dao.IArticleDao;
import com.myblog.dto.args.ArticleArg;
import com.myblog.entity.Article;
import com.myblog.service.ArticleServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration({"/spring-db.xml","/spring-mybatis.xml","/spring-service.xml","/spring-tx.xml"}) //加载配置文件  
  
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例  
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！  
//@Transactional  
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
//------------  
public class Articletest {
  @Resource(name="IArticleDao")
  private IArticleDao articleDao;
  @Resource(name="articleService")
  private ArticleServiceImpl articleService;
  @Test
  public void getSorts() {
		
		System.out.println(articleDao.getSorts());
	}
   @Test
	public void addArticle() {
	   Article ff=new Article(null, "article_title",null,null, 177, 10001,null,null,null);
		System.out.println(articleService.addArticle(ff));
		System.out.println(ff.getArticle_id());
	}
   @Test
   public void getArticlr() {
 		
 		System.out.println(articleDao.getArticle(15));
 	}
   @Test
   public void getArticlist() {
	    PageHelper.startPage(2, 1);
 		ArticleArg myarg=new ArticleArg(null, "t", null);
 		/*System.out.println(myarg.getArticle_title());*/
 		System.out.println(articleDao.getArticleList(myarg));
 	}
	@Test
	public void tFile() {
		 FileWriter fw=null;
	        try {
	            //在工程的根目录下创建一个FileWriter对象，如果该目录下已有同名文件，旧的文件将被覆盖
	            fw=new FileWriter("FileWriterDemo.txt",false);
	         
	            //要被写入的字符串
	            String str="###科学公式 TeX(KaTeX)\r\n" + 
	            		"                    \r\n" + 
	            		"$$E=mc^2$$\r\n" + 
	            		"\r\n" + 
	            		"行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\r\n" + 
	            		"\r\n" + 
	            		"$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\r\n" + 
	            		"                    \r\n" + 
	            		"$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\r\n" + 
	            		"\r\n" + 
	            		"$$X^2 > Y$$\r\n" + 
	            		"\r\n" + 
	            		"#####上标和下标\r\n" + 
	            		"\r\n" + 
	            		"上标：X&lt;sup&gt;2&lt;/sup&gt;\r\n" + 
	            		"\r\n" + 
	            		"下标：O&lt;sub&gt;2&lt;/sub&gt;\r\n" + 
	            		"\r\n" + 
	            		"##### 代码块里包含的过滤标签及属性不会被过滤\r\n" + 
	            		"\r\n" + 
	            		"```html\r\n" + 
	            		"&lt;style type=\"text/style\"&gt;\r\n" + 
	            		"body{background:red;}\r\n" + 
	            		"&lt;/style&gt;\r\n" + 
	            		"\r\n" + 
	            		"&lt;script type=\"text/javscript\"&gt;\r\n" + 
	            		"alert(\"script\");\r\n" + 
	            		"&lt;/script&gt;\r\n" + 
	            		"\r\n" + 
	            		"&lt;iframe height=498 width=510 src=\"http://player.youku.com/embed/XMzA0MzIwMDgw\" frameborder=0 allowfullscreen&gt;&lt;/iframe&gt;\r\n" + 
	            		"```\r\n" + 
	            		"\r\n" + 
	            		"#####Style\r\n" + 
	            		"\r\n" + 
	            		"&lt;style&gt;\r\n" + 
	            		"body{background:red;}\r\n" + 
	            		"&lt;/style&gt;\r\n" + 
	            		"\r\n" + 
	            		"&lt;style type=\"text/style\"&gt;\r\n" + 
	            		"body{background:red;}\r\n" + 
	            		"&lt;/style&gt;\r\n" + 
	            		"\r\n" + 
	            		"#####Script\r\n" + 
	            		"\r\n" + 
	            		"&lt;script&gt;\r\n" + 
	            		"alert(\"script\");\r\n" + 
	            		"&lt;/script&gt;\r\n" + 
	            		"\r\n" + 
	            		"&lt;script type=\"text/javscript\"&gt;\r\n" + 
	            		"alert(\"script\");\r\n" + 
	            		"&lt;/script&gt;";
	            fw.write(str);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                if(fw!=null){
	                    //关闭数据流
	                    fw.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	
}
