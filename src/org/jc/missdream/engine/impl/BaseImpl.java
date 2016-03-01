package org.jc.missdream.engine.impl;

import org.jc.missdream.bean.HttpBean;
import org.jc.volley.toolbox.StringRequest;

public class BaseImpl {
	public void startAction(HttpBean bean, StringRequest stringRequest){
		bean.getRequest().add(stringRequest);
		bean.getRequest().start();
	}
}
