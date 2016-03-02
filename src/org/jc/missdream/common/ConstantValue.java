package org.jc.missdream.common;

public class ConstantValue {
	/**
	 * 哔哩哔哩主站域名
	 */
	public static final String BILIBILI="http://www.bilibili.tv/";
	/**
	 * 哔哩哔哩api域名
	 */
	public static final String BILIBILI_API="http://api.bilibili.cn/";
	/**
	 * 哔哩哔哩Appkey(用于请求需要认证的接口)
	 */
	public static final String BILIBILIAPPKEY="876fe0ebd0e67a0f";//85eb6835b0a1034e,95acd7f6cc3392f3
	
	/**
	 * 根据年-月搜索番剧
	 */
	public static final String FINDBY_MONTH= BILIBILI+"index/bangumi/{0}-{1}.json";
	/**
	 * 根据关键词搜索番剧
	 */
	public static final String FINDBY_KEY=BILIBILI_API+"search?keyword={0}&page={1}&pagesize={2}";
}
