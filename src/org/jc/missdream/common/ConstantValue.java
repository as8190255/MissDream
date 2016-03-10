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
	 * ����������������
	 */
	public static final String BILIBILI_SEARCH="http://search.bilibili.com/";
	
	/**
	 * ��������Appkey(����������Ҫ��֤�Ľӿ�)
	 */
	public static final String BILIBILIAPPKEY="876fe0ebd0e67a0f";//85eb6835b0a1034e,95acd7f6cc3392f3
	//APPSEC = '2ad42749773c441109bdc0191257a664'
	
	/**
	 * ������-����������
	 */
	public static final String FINDBY_MONTH= BILIBILI+"index/bangumi/{0}-{1}.json";
	/**
	 * ���ݹؼ�����������api
	 */
	public static final String FINDBY_KEY=BILIBILI_API+"search?keyword={0}&page={1}&pagesize={2}";
	/**
	 * ���ݹؼ�����������
	 */
	public static final String FINDBY_KEYWORD=BILIBILI_SEARCH+"bangumi?keyword={0}";
	/**
	 * ����������Ļ����(cid)
	 */
	public static final String BILIBILI_TXT="http://comment.bilibili.tv/{0}.xml";
	
}
