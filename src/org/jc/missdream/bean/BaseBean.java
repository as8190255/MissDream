package org.jc.missdream.bean;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * ����ģ��
 * @author jincai
 *
 */
public class BaseBean {

	String resultString;
	List<BaseBean> baseBeans;
	public BaseBean(){
	}
	public BaseBean(String content){
		resultString=content;
	}
	public String getResultString(){
		return resultString;
	}
	
}
