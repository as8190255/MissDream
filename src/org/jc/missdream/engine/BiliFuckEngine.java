package org.jc.missdream.engine;

import org.jc.missdream.bean.HttpBean;

/**
 * 哔哩哔哩动画api接口
 * @author Jc
 * @from https://www.fuckbilibili.com/biliapi.html 
 */
public interface BiliFuckEngine {
	/**
	 * 根据月份获取动画番剧信息
	 * @param year 年份
	 * @param month 月份(1,4,7,10)
	 * @return
	 */
	public void getCartoonByMonth(int action, String year,String month,HttpBean httpBean);
	
	/**
	 * 根据关键词搜索番剧信息
	 * @param keyword 关键词
	 */
	public void getCartoonByKey(int action, String keyword,HttpBean httpBean);
}
