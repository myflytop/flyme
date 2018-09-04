package com.myblog.log.model;

import java.util.Date;

public class Syslog {
	    //操作者
	    private String id;
        //描述
	    private String description;
        //方法
	    private String method;
        //日志类型
	    private Long logType;
        //请求Ip
	    private String requestIp;
        //异常代码
	    private String exceptionCode;
	    //异常处理
	    private String exceptionDetail;
        //参数
	    private String params;
        //创建者
	    private String createBy;
        //处理时间
	    private Date createDate;

}
