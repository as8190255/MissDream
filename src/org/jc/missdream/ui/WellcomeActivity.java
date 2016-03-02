package org.jc.missdream.ui;

import java.util.List;

import org.jc.missdream.R;
import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.common.FusionAction.BiliAction;
import org.jc.missdream.engine.BiliFuckEngine;
import org.jc.missdream.framework.BaseActivity;
import org.jc.missdream.utils.AppFactory;

import com.alibaba.fastjson.JSON;

import android.os.Bundle;

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
		engine.getCartoonByMonth(BiliAction.BANGUMIBYMONTH, "2015", "4", httpAction);
	}

	@Override
	public void onResponse(int id, String response) {
		super.onResponse(id, response);
		//ShowToast("获取数据成功...");
		switch (id) {
		case BiliAction.BANGUMIBYMONTH:
			List<C_Month_Result> list=JSON.parseArray(response, C_Month_Result.class);
			ShowToast(list.size()+"");
			break;
		default:
			break;
		}
		
	}
}
