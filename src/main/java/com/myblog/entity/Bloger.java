package com.myblog.entity;

public class Bloger {	
	private Integer bloger_id;
	public void setBloger_id(Integer bloger_id) {
		this.bloger_id = bloger_id;
	}

	private String  bloger_pas;
	
	public Bloger() {
		super();
	}
	
	public String getBloger_pas() {
		return bloger_pas;
	}
	public void setBloger_pas(String bloger_pas) {
		this.bloger_pas = bloger_pas;
	}
	
	public Integer getBloger_id() {
		return bloger_id;
	}

	@Override
	public String toString() {
		return "Bloger [bloger_id=" + bloger_id + ", bloger_pas=" + bloger_pas +  "]";
	}
	 
	

}
