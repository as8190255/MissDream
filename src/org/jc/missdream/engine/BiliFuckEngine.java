package org.jc.missdream.engine;

import java.util.List;

import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.bean.HttpBean;
import org.jc.volley.RequestQueue;

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
}
