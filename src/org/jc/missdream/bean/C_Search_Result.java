package org.jc.missdream.bean;

import java.util.List;

/**
 * Bվ ���ؼ�����������
 * @author jincai
 *
 */
public class C_Search_Result {
	String img;//ͷ��
	String url;//��ַ
	String title; //����
	String year;//���
	String detail;//����
	String info;//��:13��ȫ
	List<Search_Result_Item> lists;//��������
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
