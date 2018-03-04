package com.myblog.util;

import java.util.List;

public class Mypage<T> {	
 //数据
 private List<T> data;
//总个数
private long total;
//总页数
private int pages;
//当前页
private int pageNum;
//每页的数量
private int pageSize;
//当前页的数量
private int size;
 public Mypage(List<T> data, long total, int pages, int pageNum, int pageSize, int size) {
	super();
	this.data = data;
	this.total = total;
	this.pages = pages;
	this.pageNum = pageNum;
	this.pageSize = pageSize;
	this.size = size;
}
public Mypage() {
	super();
}
public List<T> getData() {
	return data;
}
public void setData(List<T> data) {
	this.data = data;
}
public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
}
public int getPageNum() {
	return pageNum;
}
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
@Override
public String toString() {
	return "Mapge [data=" + data + ", total=" + total + ", pages=" + pages + ", pageNum=" + pageNum + ", pageSize="
			+ pageSize + ", size=" + size + "]";
}

 

}
