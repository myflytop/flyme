package com.myblog.dto;

public class Sys {
 private int sysid;
 private String sysname;
 private String sysstatus;
 
public Sys() {
	super();
}
public Sys(int sysid, String sysname, String sysstsus) {
	super();
	this.sysid = sysid;
	this.sysname = sysname;
	this.sysstatus = sysstsus;
}
public int getSysid() {
	return sysid;
}
public void setSysid(int sysid) {
	this.sysid = sysid;
}
public String getSysname() {
	return sysname;
}
public void setSysname(String sysname) {
	this.sysname = sysname;
}
public String getSysstatus() {
	return sysstatus;
}
public void setSysstatus(String sysstsus) {
	this.sysstatus = sysstsus;
}
 
}
