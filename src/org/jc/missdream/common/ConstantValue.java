package org.jc.missdream.common;

public class ConstantValue {
	/**
	 * ����������վ����
	 */
	public static final String BILIBILI="http://www.bilibili.tv/";
	/**
	 * ��������api����
	 */
	public static final String BILIBILI_API="http://api.bilibili.cn/";
	/**
	 * ��������Appkey(����������Ҫ��֤�Ľӿ�)
	 */
	public static final String BILIBILIAPPKEY="876fe0ebd0e67a0f";//85eb6835b0a1034e,95acd7f6cc3392f3
	
	/**
	 * ������-����������
	 */
	public static final String FINDBY_MONTH= BILIBILI+"index/bangumi/{0}-{1}.json";
	/**
	 * ���ݹؼ�����������
	 */
	public static final String FINDBY_KEY=BILIBILI_API+"search?keyword={0}&page={1}&pagesize={2}";
}
