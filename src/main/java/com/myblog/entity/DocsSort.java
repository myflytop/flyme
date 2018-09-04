package com.myblog.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class DocsSort {
	private Long docsSortid;
	@NotNull
	@Pattern(regexp="^[\\u0391-\\uFFE5A-Za-z]{2,12}$",message="{mes.docsSortname}")
	private String docsSortname;
	private String docsSortretime;
	private String docsSorttime;
	@NotNull
	@Range(min=10001L,max=99999999999L,message="{mes.docsSortid}")
	private Long userId;
	private int docsSortstatus;
	public Long getDocsSortid() {
		return docsSortid;
	}
	public void setDocsSortid(Long docsSortid) {
		this.docsSortid = docsSortid;
	}
	public String getDocsSortname() {
		return docsSortname;
	}
	public void setDocsSortname(String docsSortname) {
		this.docsSortname = docsSortname;
	}
	public String getDocsSortretime() {
		return docsSortretime;
	}
	public void setDocsSortretime(String docsSortretime) {
		this.docsSortretime = docsSortretime;
	}
	public String getDocsSorttime() {
		return docsSorttime;
	}
	public void setDocsSorttime(String docsSorttime) {
		this.docsSorttime = docsSorttime;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getDocsSortstatus() {
		return docsSortstatus;
	}
	public void setDocsSortstatus(int docsSortstatus) {
		this.docsSortstatus = docsSortstatus;
	}
	

}
