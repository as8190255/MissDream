package org.jc.missdream.framework;



import org.jc.missdream.bean.HttpBean;
import org.jc.volley.RequestQueue;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.Response.Listener;
import org.jc.volley.VolleyError;
import org.jc.volley.toolbox.Volley;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity implements ErrorListener,Listener<String>{

	public RequestQueue mQueue;
	public HttpBean httpAction;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		mQueue=Volley.newRequestQueue(getApplicationContext());
		initView();
		
	}
	
	@Override
	public void onResponse(int id, String response) {
		
	}
	
	/**
	 * 数据获取失败
	 */
	@Override
	public void onErrorResponse(int id, VolleyError arg0) {
		ShowToast(arg0.getMessage());
	}
	
	
	public abstract void initView();
	
	/**
	 * 初始化网络
	 */
	protected void iniHttp() {
		httpAction=new HttpBean(this, this, mQueue);
	}
	
	/**
	 * 短时间吐司
	 * @param content
	 */
	public void ShowToast(String content){
		Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
	}
}
