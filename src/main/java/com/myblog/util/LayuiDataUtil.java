package com.myblog.util;

import java.util.List;

public class LayuiDataUtil<T> {
	//消息
	private String msg;
	//总数
	private int count;
	//数据
	private List<T> data;
	//状态码
	private int code;
	public LayuiDataUtil() {
		// TODO Auto-generated constructor stub
	}
	

	public LayuiDataUtil(int code, String msg, int count, List<T> data) {
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

	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
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

	
}
