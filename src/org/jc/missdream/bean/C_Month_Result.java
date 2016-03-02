package org.jc.missdream.bean;

/**
 * B站 按月份获取动画新番
 * @author Jc
 *
 */
//public class C_Month_Result extends BaseBean{
public class C_Month_Result {
	
	String spid;
	/**
	 * 番剧周信息
	 */
	String weekday;
	/**
	 * 标题
	 */
	String title;
	/**
	 * 封面(小) 
	 */
	String scover;
	/**
	 * 封面(中)
	 */
	String mcover;
	/**
	 * 封面(大)
	 */
	String cover;
	/**
	 * 
	 */
	String typeid;
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScover() {
		return scover;
	}
	public void setScover(String scover) {
		this.scover = scover;
	}
	public String getMcover() {
		return mcover;
	}
	public void setMcover(String mcover) {
		this.mcover = mcover;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	
}
