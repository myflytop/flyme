package com.myblog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myblog.dao.IBlogerDao;
import com.myblog.dao.ISort_articleDao;
import com.myblog.entity.Bloger_info;
import com.myblog.entity.Sort_article;
import com.myblog.service.BlogerServiceImpl;
import com.myblog.service.ISort_articleService;
import com.myblog.util.LayuiDataUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration({"/spring-db.xml","/spring-mybatis.xml","/spring-service.xml","/spring-tx.xml"}) //加载配置文件  
  
//------------如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例  
//这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！  
//@Transactional  
//这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时//指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
//------------  
public class Bl {
	@Autowired
	@Qualifier("blogerService")
	private BlogerServiceImpl blogerService;
	@Autowired
	@Qualifier("IBlogerDao")
	private IBlogerDao blogerDao;
	@Autowired
	@Qualifier("ISort_articleDao")
	private ISort_articleDao sort_articleDao;
	@Autowired
	@Qualifier("sort_articleService")
	private ISort_articleService sort_articleService;
	@Test
	public void testgetbloger() {
		
		System.out.println(blogerService.getBloger(10001));
		
	}
	@Test
	public void testgetbloger_info() {
		
		System.out.println(blogerService.getBloger_info(10001));
		
	}
	@Test
	public void testupdatebloger_info() {
		
		
		System.out.println(blogerService.getBloger_info(10001));
		Bloger_info bloger_info=new Bloger_info();
		bloger_info.setBloger_address("张家口");
		bloger_info.setBloger_birthday("2017-10-23");
		bloger_info.setBloger_id(10001);
		bloger_info.setBloger_name("张哈哈");
		bloger_info.setBloger_nikename("票琵琶");
		bloger_info.setBloger_sex(1);
        bloger_info.setBloger_introduce("撒大声地所多");
        blogerService.updateBloger_info(bloger_info);
		
		System.out.println(blogerService.getBloger_info(10001));
		
	}
	@Test
	public void updatebloder_imgurl() {
		System.out.println(blogerService.getBloger_info(10001));
		int bloger_id=10001;
		String bloger_public="7777";
		blogerDao.updateBloger_imgurl("1111", 10001);
		System.out.println(blogerDao.getBloger_imgurl(10001));
		blogerDao.updateBloger_hobby("1111", 10001);
		System.out.println(blogerDao.getBloger_hobby(10001));
		blogerDao.upadteBloger_profession("1111", 10001);
		System.out.println(blogerDao.getBloger_profession(10001));
		
		
		/*System.out.println(blogerService.getBloger_profession(bloger_public, bloger_id));
		System.out.println(blogerService.getBloger_imgurl(bloger_public, bloger_id));*/
     	System.out.println(blogerService.getBloger_hobby(bloger_public, bloger_id));
		System.out.println(blogerService.getBloger_profession(bloger_public, bloger_id));
		System.out.println(blogerService.getBloger_imgurl(bloger_public, bloger_id));
		
	}
	@Test
	public void jsonarrytest() {
		
		JSONArray jsonArray=new JSONArray();
		jsonArray.add("zhangsan");
		jsonArray.add("zhangsan8");
		jsonArray.add("zhangsanppp3");
		jsonArray.add("zhangyuyhu");
		jsonArray.add("zhang网二san3");
		jsonArray.add("zhangsan3");
		jsonArray.add("zhangsan3");
		
	/*	jsonArray.discard(0);
		System.out.println(jsonArray.get(0));
		System.out.println(jsonArray.toString());*/
		String myjd=jsonArray.toString();
		/*blogerService.getBloger_profession(myjd, 10001);*/
		JSONArray jsonArray2=JSONArray.fromObject(blogerService.getBloger_hobby(myjd, 10001));
		System.out.println(jsonArray2);	
	}
	@Test
	public void jsonmap() {
	List<Map<String,String>> listmap=new ArrayList<>();
	Map<String, String> my=new HashMap<String, String>();
	my.put("ddd", "ddd");
	listmap.add(my);
	System.out.println(listmap);	
	}
	@Test
	public void testimg() {
		blogerDao.updateBloger_imgurl("fff", 10001);
		System.out.println(blogerDao.getBloger_imgurl(10001));
		
	}
	@Test
	public void fanx() {
		List<String> strings=new ArrayList<>();
		strings.add("1");
		strings.add("2");
		LayuiDataUtil<String> olo=new LayuiDataUtil<>();
		olo.setData(strings);
		System.out.println(olo);
		
	}
	@Test
	public void sort() {
		
		System.out.println(sort_articleDao.getSorts());
		
	}
	@Test
	public void sort1() {
		
		System.out.println(sort_articleService.getSorts());
		System.out.println(sort_articleService.delSort(23));
		
	}
	@Test
	public void sort2() {
		
		System.out.println(sort_articleService.getSorts());
		
		
	}
	@Test
	public void sortadd() {
		Sort_article sort_article=new Sort_article();
		sort_article.setSort_article_name("test");
		sort_articleService.addSort(sort_article);
		System.out.println(sort_article);
		
		
	}
	@Test
	public void getsortname() {
		
		System.out.println(sort_articleDao.getSortName("222"));
		
	}
	@Test
	public void sort3() {
		
		System.out.println(sort_articleService.getSorts());
		System.out.println(sort_articleService.reSortname(new Sort_article(42,"嘿嘿")));
		
	}
	@Test
	public void sortget() {
		
		System.out.println(sort_articleDao.getSort(45));
		
	}
	@Test
	public void shet() {
		String msg="{msg:\"success\"}";
	   JSONObject o=JSONObject.fromObject(msg);
		System.out.println(JSONObject.fromObject(msg));
		
	}
}
