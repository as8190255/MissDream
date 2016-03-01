package org.jc.missdream.ui;


import org.jc.missdream.R;
import org.jc.missdream.engine.BiliFuckEngine;
import org.jc.missdream.framework.BaseActivity;
import org.jc.missdream.utils.AppFactory;
import org.jc.volley.Response.Listener;
import org.jc.volley.toolbox.StringRequest;

import android.os.Bundle;
import android.widget.Toast;

public class WellcomeActivity extends BaseActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wellcome);
	}

	@Override
	public void initView() {
		iniHttp();
		BiliFuckEngine engine=AppFactory.getImpl(BiliFuckEngine.class);
		engine.getCartoonByMonth(1, "2015", "4", httpAction);
	}

	@Override
	public void onResponse(int id, String response) {
		super.onResponse(id, response);
		ShowToast("获取数据成功...");
	}
}
