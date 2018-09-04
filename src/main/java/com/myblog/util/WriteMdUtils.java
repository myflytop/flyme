package com.myblog.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 写入md文件工具
 * @author Administrator
 *
 */
public class WriteMdUtils {
       public static int writreMd(String url,String data,String encoding,boolean append) {
    	   
    	   
           File file = new File( url) ;

           try {
               FileUtils.writeStringToFile( file , data , "UTF-8" , append); 
           }catch (IOException e) {
               e.printStackTrace();
           }
    	   
    	   
    	   return 0;
       }
}
