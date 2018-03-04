package com.myblog.entity;

public class Bloger_info {
 private Integer bloger_id;
 private Integer bloger_sex;
 private String bloger_birthday;
 private String bloger_address;
 private String bloger_hobby;
 private String bloger_profession;
 private String bloger_introduce;
 private String bloger_imgurl;
 private String bloger_name;
 private String bloger_nikename;
 private String bloger_regtime;
public Integer getBloger_id() {
	return bloger_id;
}
public void setBloger_id(Integer bloger_id) {
	this.bloger_id = bloger_id;
}
public String getBloger_birthday() {
	return bloger_birthday;
}
public void setBloger_birthday(String bloger_birthday) {
	this.bloger_birthday = bloger_birthday;
}
public String getBloger_address() {
	return bloger_address;
}
public void setBloger_address(String bloger_address) {
	this.bloger_address = bloger_address;
}
public String getBloger_hobby() {
	return bloger_hobby;
}
public void setBloger_hobby(String bloger_hobby) {
	this.bloger_hobby = bloger_hobby;
}
public String getBloger_profession() {
	return bloger_profession;
}
public void setBloger_profession(String bloger_profession) {
	this.bloger_profession = bloger_profession;
}
public String getBloger_introduce() {
	return bloger_introduce;
}
public void setBloger_introduce(String bloger_introduce) {
	this.bloger_introduce = bloger_introduce;
}
public String getBloger_imgurl() {
	return bloger_imgurl;
}
public void setBloger_imgurl(String bloger_imgurl) {
	this.bloger_imgurl = bloger_imgurl;
}
public String getBloger_name() {
	return bloger_name;
}
public void setBloger_name(String bloger_name) {
	this.bloger_name = bloger_name;
}
public String getBloger_nikename() {
	return bloger_nikename;
}
public void setBloger_nikename(String bloger_nikename) {
	this.bloger_nikename = bloger_nikename;
}
public String getBloger_regtime() {
	return bloger_regtime;
}
public void setBloger_regtime(String bloger_regtime) {
	this.bloger_regtime = bloger_regtime;
}

public Bloger_info() {
	super();
}
public Integer getBloger_sex() {
	return bloger_sex;
}
public void setBloger_sex(Integer bloger_sex) {
	this.bloger_sex = bloger_sex;
}

public Bloger_info(Integer bloger_id, Integer bloger_sex, String bloger_birthday, String bloger_address,
		String bloger_hobby, String bloger_profession, String bloger_introduce, String bloger_imgurl,
		String bloger_name, String bloger_nikename, String bloger_regtime) {
	super();
	this.bloger_id = bloger_id;
	this.bloger_sex = bloger_sex;
	this.bloger_birthday = bloger_birthday;
	this.bloger_address = bloger_address;
	this.bloger_hobby = bloger_hobby;
	this.bloger_profession = bloger_profession;
	this.bloger_introduce = bloger_introduce;
	this.bloger_imgurl = bloger_imgurl;
	this.bloger_name = bloger_name;
	this.bloger_nikename = bloger_nikename;
	this.bloger_regtime = bloger_regtime;
}
@Override
public String toString() {
	return "Bloger_info [bloger_id=" + bloger_id + ", bloger_birthday=" + bloger_birthday + ", bloger_address="
			+ bloger_address + ", bloger_hobby=" + bloger_hobby + ", bloger_profession=" + bloger_profession
			+ ", bloger_introduce=" + bloger_introduce + ", bloger_imgurl=" + bloger_imgurl + ", bloger_name="
			+ bloger_name + ", bloger_nikename=" + bloger_nikename + ", bloger_regtime=" + bloger_regtime + ", bloger_sex=" + bloger_sex +"]";
}


 
}
