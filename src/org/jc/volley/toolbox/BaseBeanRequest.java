package org.jc.volley.toolbox;

import java.io.UnsupportedEncodingException;

import org.jc.missdream.bean.BaseBean;
import org.jc.volley.NetworkResponse;
import org.jc.volley.ParseError;
import org.jc.volley.Response;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.Response.Listener;

public class BaseBeanRequest extends BeanRequest<BaseBean>{

	public BaseBeanRequest(int method,String url,String requestBody,
			Listener<BaseBean> listener,ErrorListener errorListener) {
		super(method, url, requestBody, listener, errorListener);
	}
	
	public BaseBeanRequest (String url,Listener<BaseBean> listener,ErrorListener errorListener) {
		super(Method.GET, url, null, listener, errorListener);
	}

	
	@Override
	protected Response<BaseBean> parseNetworkResponse(NetworkResponse response) {
		String content;
		try {
			content = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
			return Response.success(new BaseBean(content), 
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		}
	}
}
