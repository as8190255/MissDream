package org.jc.missdream.engine;

import org.jc.missdream.bean.HttpBean;

/**
 * ������������api�ӿ�
 * @author Jc
 * @from https://www.fuckbilibili.com/biliapi.html 
 */
public interface BiliFuckEngine {
	/**
	 * �����·ݻ�ȡ����������Ϣ
	 * @param year ���
	 * @param month �·�(1,4,7,10)
	 * @return
	 */
	public void getCartoonByMonth(int action, String year,String month,HttpBean httpBean);
	
	/**
	 * ���ݹؼ�������������Ϣ
	 * @param keyword �ؼ���
	 */
	public void getCartoonByKey(int action, String keyword,HttpBean httpBean);
}
