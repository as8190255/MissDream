package org.jc.missdream.engine.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import org.jc.missdream.bean.HttpBean;
import org.jc.missdream.common.ConstantValue;
import org.jc.missdream.engine.BiliFuckEngine;
import org.jc.volley.toolbox.StringRequest;

/**
 * 哔哩接口实现类
 * @author Jc
 *
 */
public class BiliFuckEngineImpl extends BaseImpl implements BiliFuckEngine{
	
	@Override
	public void getCartoonByMonth(int action, String year,
			String month, HttpBean httpBean) {
		StringRequest stringRequest=new StringRequest(MessageFormat.format(ConstantValue.FINDBY_MONTH, year, month), action, httpBean.getListener(), httpBean.getError());
		startAction(httpBean, stringRequest);
	}

	@Override
	public void getCartoonByKey(int action, String keyword, HttpBean httpBean) {
		StringRequest stringRequest = null;
		try {
			stringRequest = new StringRequest(MessageFormat.format(ConstantValue.FINDBY_KEYWORD, URLEncoder.encode(keyword, "UTF-8")), action , httpBean.getListener(), httpBean.getError());
		} catch (UnsupportedEncodingException e) {
			stringRequest = new StringRequest(MessageFormat.format(ConstantValue.FINDBY_KEYWORD, keyword), action , httpBean.getListener(), httpBean.getError());
		}
		startAction(httpBean, stringRequest);
	}

}
