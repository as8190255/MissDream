package org.jc.missdream.ui;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.DeflateInputStream;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jc.missdream.R;
import org.jc.missdream.bean.C_Month_Result;
import org.jc.missdream.bean.C_Search_Result;
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
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.http.client.entity.GZipDecompressingEntity;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class WellcomeActivity extends BaseActivity {

	Long newtime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			//横屏
			
		}else {
			//竖屏
			setContentView(R.layout.activity_wellcome);
		}
	}

	@Override
	public void initView() {
		iniHttp();
		BiliFuckEngine engine=AppFactory.getImpl(BiliFuckEngine.class);
		newtime=new Date().getTime();
		//engine.getCartoonByMonth(BiliAction.BANGUMIBYMONTH, "2015", "4", httpAction);
		//engine.getCartoonByKey(1231, "黑白小姐", httpBean);
		//htmlRequest();
		
		new AsyncTask<Void, Void, Void>() {
			@Override
			protected Void doInBackground(Void... params) {
				try {
					//down();
					name();
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return null;
			}
			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
			}
		}.execute();
		
	}

	
	public void htmlRequest() {
		RequestQueue mQueue=Volley.newRequestQueue(getApplicationContext());
		StringRequest stringRequest=new StringRequest("http://comment.bilibili.tv/6519784.xml", new Listener<String>() {
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
	}
	
	
	
	
	
	
	
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
	 public static void name() {
		 HttpClient httpClient =  new DefaultHttpClient();
		 
		 HttpPost httpPost = new HttpPost("http://comment.bilibili.tv/6519784.xml");
		 //httpPost.addHeader("Referer", "http://my.oschina.net/ososchina");
		 //httpPost.addHeader("X-Requested-With", "XMLHttpRequest");//此处支持ajax请求，这里没太多意义
		 //httpPost.addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
		 httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		 httpPost.addHeader("Accept-Encoding", "gzip, deflate"); //声明给服务器，客户端支持gzip解压
		 httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		 httpPost.addHeader("Pragma", "no-cache");
		 httpPost.addHeader("Cache-Control", "max-age=0");
		  
		/* List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		 params.add(new BasicNameValuePair("name","admin"));
		 params.add(new BasicNameValuePair("password", "admin"));*/
		 
		  HttpEntity httpEntity = null;
		  UrlEncodedFormEntity formEntity = null;
		  HttpResponse response = null;
		  String responseHtml = null;
		  try{
		         //formEntity = new UrlEncodedFormEntity(params, "utf-8");
		         //httpPost.setEntity(formEntity);
		         response = httpClient.execute(httpPost);
		         InputStream is= null;
		         
		          if ("gzip".equalsIgnoreCase(response.getEntity().getContentEncoding().getValue())) { 
		        	  //httpEntity = new GZipDecompressingEntity(response.getEntity()); 
		        	  is= new GZIPInputStream(response.getEntity().getContent());
		           } else if ("deflate".equalsIgnoreCase(response.getEntity().getContentEncoding().getValue())) { 
		                // httpEntity = new DeflateDecompressingEntity(response.getEntity());                    
		        	   is=new DeflateInputStream(response.getEntity().getContent());
		            }
		           
		          BufferedReader br = new BufferedReader(new InputStreamReader(is));
		          String line = null;
		          StringBuffer sb = new StringBuffer();
		            while((line = br.readLine())!=null) {
		             sb.append(line);
		            }
		            responseHtml = sb.toString(); //读取解压数据，当然，你也可以将其保存成文件
		            is.close();
		        } catch (Exception e)
		        {
		           e.printStackTrace();
		        }

	}
	 
	 
}
