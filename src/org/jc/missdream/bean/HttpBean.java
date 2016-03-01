package org.jc.missdream.bean;

import org.jc.volley.RequestQueue;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.Response.Listener;

public class HttpBean {
	private Listener<String> listener;
	private ErrorListener error;
	private RequestQueue request;
	public HttpBean(Listener<String> listener, ErrorListener error,
			RequestQueue request) {
		super();
		this.listener = listener;
		this.error = error;
		this.request = request;
	}
	public Listener<String> getListener() {
		return listener;
	}
	public void setListener(Listener<String> listener) {
		this.listener = listener;
	}
	public ErrorListener getError() {
		return error;
	}
	public void setError(ErrorListener error) {
		this.error = error;
	}
	public RequestQueue getRequest() {
		return request;
	}
	public void setRequest(RequestQueue request) {
		this.request = request;
	}
	
}
