package org.jc.missdream.engine;

import java.util.List;

import org.jc.missdream.bean.C_Month_Result;

/**
 * ������������api�ӿ�
 * @author Jc
 * @from ttps://www.fuckbilibili.com/biliapi.html 
 */
public interface BiliFuckEngine {
	/**
	 * �����·ݻ�ȡ����������Ϣ
	 * @param year ���
	 * @param month �·�(1,4,7,10)
	 * @return
	 */
	public List<C_Month_Result> getCartoonByMonth(String year,String month);
}
