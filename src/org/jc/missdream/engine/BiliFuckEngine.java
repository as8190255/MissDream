package org.jc.missdream.engine;

import java.util.List;

import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.bean.HttpBean;
import org.jc.volley.RequestQueue;

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
}
