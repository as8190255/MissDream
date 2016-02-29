package org.jc.missdream.framework;



import org.jc.volley.RequestQueue;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.VolleyError;
import org.jc.volley.toolbox.Volley;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity implements ErrorListener{

	public RequestQueue mQueue;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		mQueue=Volley.newRequestQueue(getApplicationContext());
		initView();
		
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
	 * 短时间吐司
	 * @param content
	 */
	public void ShowToast(String content){
		Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
	}
}
