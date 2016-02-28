package org.jc.missdream.ui;

import java.util.List;

import org.jc.missdream.R;
import org.jc.missdream.R.id;
import org.jc.missdream.R.layout;
import org.jc.missdream.R.menu;
import org.jc.missdream.bean.BaseBean;
import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.engine.BiliFuckEngine;
import org.jc.missdream.utils.AppFactory;
import org.jc.volley.RequestQueue;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.Response.Listener;
import org.jc.volley.VolleyError;
import org.jc.volley.toolbox.BaseBeanRequest;
import org.jc.volley.toolbox.Volley;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WellcomeActivity extends Activity {

	RequestQueue mqueue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wellcome);
		//List<C_Month_Result> result = AppFactory.getImpl(BiliFuckEngine.class).getCartoonByMonth("2015", "4");
		//System.out.println("");
		mqueue=Volley.newRequestQueue(getApplicationContext());
		BaseBeanRequest request=new BaseBeanRequest("http://www.bilibili.tv/index/bangumi/2015-10.json", new Mylistener(), new MyErrorlistener());
		mqueue.add(request);
		mqueue.start();
	}

	private class Mylistener implements Listener<BaseBean>{
		@Override
		public void onResponse(BaseBean response) {
			System.out.println("³É¹¦");
		}
	}
	
	private class MyErrorlistener implements ErrorListener{
		@Override
		public void onErrorResponse(VolleyError error) {
			System.out.println("error");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wellcome, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
