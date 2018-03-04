package com.myblog.dto.args;
/**
 * 
 * @author Administrator
 *
 */

import java.util.List;

public class SearchArtArg {
	//搜索标题参数
private String searchArg;
//分类参数
private List<Integer> sortArgs;
    public String getSearchArg() {
	return searchArg;
}
public void setSearchArg(String searchArg) {
	this.searchArg ="%"+ searchArg+"%";
}
public List<Integer> getSortArgs() {
	return sortArgs;
}
public void setSortArgs(List<Integer> sortArgs) {
	this.sortArgs = sortArgs;
}

public SearchArtArg() {
	super();
}
public SearchArtArg(String searchArg, List<Integer> sortArgs) {
	super();
	this.searchArg = "%"+ searchArg+"%";
	this.sortArgs = sortArgs;
}
@Override
public String toString() {
	return "SearchArtArg [searchArg=" + searchArg + ", sortArgs=" + sortArgs + "]";
}

}
