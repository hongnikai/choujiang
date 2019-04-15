package com.lc.util;
/**
 *  @描述：	响应信号yes or no
 *  @author LC   
 *  创建时间：2018-2-26 上午9:35
 */
public class ResponseSuccessOrFail {

	private String response_state;
	private Object object;
	
	public String getResponse_state() {
		return response_state;
	}
	public void setResponse_state(String response_state) {
		this.response_state = response_state;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public ResponseSuccessOrFail(String response_state, Object object) {
		super();
		this.response_state = response_state;
		this.object = object;
	}
	
	
	

}
