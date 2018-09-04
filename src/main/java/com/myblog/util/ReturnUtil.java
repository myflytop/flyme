package com.myblog.util;

public class ReturnUtil {
    private String msg;
    private int code;
    private Object data;
    public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	public Object getData() {
		return data;
	}

	public ReturnUtil() {
		// TODO Auto-generated constructor stub
	}

	public ReturnUtil(String msg, int code, Object data) {
		super();
		this.msg = msg;
		this.code = code;
		this.data = data;
	}
    
    public static ReturnUtil Success(String msg, int code, Object data) {
    	ReturnUtil rUtil=new ReturnUtil(msg, code, data);
    	return rUtil;
    }
    public static ReturnUtil Success(String msg,  Object data) {
    	ReturnUtil rUtil=new ReturnUtil(msg, BasicCode.SUCCESS, data);
    	return rUtil;
    }
    public static ReturnUtil Success(String msg, byte code) {
    	ReturnUtil rUtil=new ReturnUtil(msg, code, null);
    	return rUtil;
    }
    public static ReturnUtil Success(String msg) {
    	ReturnUtil rUtil=new ReturnUtil(msg, BasicCode.SUCCESS, null);
    	return rUtil;
    }
  
    
    public static ReturnUtil Fail(String msg, int code, Object data) {
    	ReturnUtil rUtil=new ReturnUtil(msg, code, data);
    	return rUtil;
    }
    public static ReturnUtil Fail(String msg,  Object data) {
    	ReturnUtil rUtil=new ReturnUtil(msg, BasicCode.SUCCESS, data);
    	return rUtil;
    }
    public static ReturnUtil Fail(String msg, byte code) {
    	ReturnUtil rUtil=new ReturnUtil(msg, code, null);
    	return rUtil;
    }
    public static ReturnUtil Fail(String msg) {
    	ReturnUtil rUtil=new ReturnUtil(msg, BasicCode.FAIL, null);
    	return rUtil;
    }

		
}
