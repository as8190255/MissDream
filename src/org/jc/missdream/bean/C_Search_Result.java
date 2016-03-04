package org.jc.missdream.bean;

import java.util.List;

/**
 * B站 按关键词搜索番剧
 * @author jincai
 *
 */
public class C_Search_Result {
	String img;//头像
	String url;//地址
	String title; //标题
	String year;//年份
	String detail;//介绍
	String info;//例:13话全
	List<Search_Result_Item> lists;//各集数据
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public List<Search_Result_Item> getLists() {
		return lists;
	}
	public void setLists(List<Search_Result_Item> lists) {
		this.lists = lists;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
