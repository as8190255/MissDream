package org.jc.missdream.engine.impl;

import java.util.ArrayList;
import java.util.List;

import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.engine.BiliFuckEngine;

/**
 * 哔哩接口实现类
 * @author Jc
 *
 */
public class BiliFuckEngineImpl implements BiliFuckEngine{

	
	@Override
	public List<C_Month_Result> getCartoonByMonth(String year, String month) {
		return new ArrayList<C_Month_Result>();
	}

}
