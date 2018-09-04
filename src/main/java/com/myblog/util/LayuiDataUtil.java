package com.myblog.util;

import java.util.List;

public class LayuiDataUtil<T> {
	//消息
	private String msg;
	//总数
	private long count;
	//数据
	private List<T> data;
	//状态码  0成功 -1失败
	private int code;
	public LayuiDataUtil() {
		// TODO Auto-generated constructor stub
	}
	

	public LayuiDataUtil(int code, String msg, long count, List<T> data) {
		super();
		this.code = code;
		this.msg=msg;
		this.count = count;
		this.data = data;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "LayuiDataUtil [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
    
	public static LayuiDataUtil<?> ok()
	{
		return new LayuiDataUtil<>(0, "success", -1, null);
	}
	public static LayuiDataUtil<?> fail()
	{
		return new LayuiDataUtil<>(-1, "fail", -1, null);
	}
	
}
