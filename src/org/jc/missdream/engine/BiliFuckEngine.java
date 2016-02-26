package org.jc.missdream.engine;

import java.util.List;

import org.jc.missdream.bean.C_Month_Result;

/**
 * 哔哩哔哩动画api接口
 * @author Jc
 * @from ttps://www.fuckbilibili.com/biliapi.html 
 */
public interface BiliFuckEngine {
	/**
	 * 根据月份获取动画番剧信息
	 * @param year 年份
	 * @param month 月份(1,4,7,10)
	 * @return
	 */
	public List<C_Month_Result> getCartoonByMonth(String year,String month);
}
