package org.jc.missdream.ui;


import org.jc.missdream.R;
import org.jc.missdream.framework.BaseActivity;
import org.jc.volley.Response.Listener;
import org.jc.volley.toolbox.StringRequest;

import android.os.Bundle;
import android.widget.Toast;

public class WellcomeActivity extends BaseActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wellcome);
		//List<C_Month_Result> result = AppFactory.getImpl(BiliFuckEngine.class).getCartoonByMonth("2015", "4");
		//System.out.println("");
		/*mqueue=Volley.newRequestQueue(getApplicationContext());
		BaseBeanRequest request=new BaseBeanRequest("http://www.bilibili.tv/index/bangumi/2015-10.json", new Mylistener(), new MyErrorlistener());
		mqueue.add(request);
		mqueue.start();*/
		StringRequest stringRequest=new StringRequest("https://www.baidu.com", 1, new Listener<String>() {
			@Override
			public void onResponse(int id,String arg0) {
				Toast.makeText(getApplicationContext(), "成功"+id
						, 0).show();
			}
		}, this);
		mQueue.add(stringRequest);
		mQueue.start();
	}

	@Override
	public void initView() {
		
	}

	/*
	private class Mylistener implements Listener<BaseBean>{
		@Override
		public void onResponse(BaseBean response) {
			@SuppressWarnings("unused")
			List<C_Month_Result>asdasdC_Month_Results=JSON.parseArray(response.getResultString(), C_Month_Result.class);
			System.out.println("成功");
		}
	}
	
	private class MyErrorlistener implements ErrorListener{
		@Override
		public void onErrorResponse(VolleyError error) {
			System.out.println("error");
		}
	}
	*/
}
