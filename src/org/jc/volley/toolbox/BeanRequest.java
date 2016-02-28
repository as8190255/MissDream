package org.jc.volley.toolbox;

import java.io.UnsupportedEncodingException;

import org.jc.volley.AuthFailureError;
import org.jc.volley.NetworkResponse;
import org.jc.volley.Request;
import org.jc.volley.Response;
import org.jc.volley.VolleyLog;
import org.jc.volley.Response.ErrorListener;
import org.jc.volley.Response.Listener;

public abstract class BeanRequest<T> extends Request<T>{
	protected static final String PROTOCOL_CHARSET = "utf-8";
	
	private Listener<T> mListener;
	private final String mRequestBody;
	
	public BeanRequest(String url,String requestBody,Listener<T>listener,
			ErrorListener errorListener){
		this(Method.DEPRECATED_GET_OR_POST,url, requestBody, listener, errorListener);
	}
	
	public BeanRequest(int method, String url, String requestBody, Listener<T> listener,
            ErrorListener errorListener) {
        super(method, url, errorListener);
        mListener = listener;
        mRequestBody = requestBody;
    }

	@Override
	protected void onFinish() {
		super.onFinish();
		mListener=null;
	}
	
	@Override
	protected void deliverResponse(T response) {
		if (mListener!=null) {
			mListener.onResponse(response);
		}
	}
	
	/**
	 * 子类实现
	 */
	@Override
	abstract protected Response<T> parseNetworkResponse(NetworkResponse response);

	
	@Override
	public String getPostBodyContentType() {
		return getBodyContentType();
	}
	
	@Override
	public byte[] getPostBody() throws AuthFailureError {
		return getBody();
	}
	
	@Override
    public String getBodyContentType() {
        return mRequestBody;
    }
	
	@Override
	public byte[] getBody() {
		try {
			return mRequestBody==null?null:mRequestBody.getBytes(PROTOCOL_CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s",
                    mRequestBody, PROTOCOL_CHARSET);
			return null;
		}
		
	}
}
