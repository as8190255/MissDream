package org.jc.missdream.ui;

import java.util.Date;
import java.util.List;

import org.jc.missdream.R;
import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.bean.C_Search_Result;
import org.jc.missdream.bean.Search_Result_Item;
import org.jc.missdream.common.FusionAction.BiliAction;
import org.jc.missdream.engine.BiliFuckEngine;
import org.jc.missdream.framework.BaseActivity;
import org.jc.missdream.utils.AppFactory;
import org.jc.missdream.utils.BILIBILI;
import org.jc.volley.RequestQueue;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.Response.Listener;
import org.jc.volley.VolleyError;
import org.jc.volley.toolbox.StringRequest;
import org.jc.volley.toolbox.Volley;

import com.alibaba.fastjson.JSON;

import android.R.string;
import android.os.Bundle;

public class WellcomeActivity extends BaseActivity {

	Long newtime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wellcome);
	}

	@Override
	public void initView() {
		iniHttp();
		BiliFuckEngine engine=AppFactory.getImpl(BiliFuckEngine.class);
		newtime=new Date().getTime();
		//engine.getCartoonByMonth(BiliAction.BANGUMIBYMONTH, "2015", "4", httpAction);
		engine.getCartoonByKey(1231, "黑白小姐", httpBean);
		//htmlRequest();
	}

	
	/*public void htmlRequest() {
		RequestQueue mQueue=Volley.newRequestQueue(getApplicationContext());
		StringRequest stringRequest=new StringRequest("http://search.bilibili.com/bangumi?keyword=%E9%BB%91%E7%99%BD%E5%B0%8F%E5%A7%90", new Listener<String>() {
			@Override
			public void onResponse(int id, String response) {
				ShowToast(response);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(int id, VolleyError error) {
				ShowToast("失败");
			}
		} );
		mQueue.add(stringRequest);
		mQueue.start();
	}*/
	
	
	
	
	
	
	
	@Override
	public void onResponse(int id, String response) {
		super.onResponse(id, response);
		//ShowToast("获取数据成功...");
		Long newDate=new Date().getTime();
		ShowToast(""+(newDate-this.newtime));
		switch (id) {
		case BiliAction.BANGUMIBYMONTH:
			List<C_Month_Result> list=JSON.parseArray(response, C_Month_Result.class);
			ShowToast(list.size()+"");
			break;
		case 1231:
			//Long a=new Date().getTime();
			List<C_Search_Result> searchResult =BILIBILI.parseResultByKey(response);
			//ShowToast("成功"+((new Date().getTime())-a));
			break;
		default:
			break;
		}
		
	}
}
