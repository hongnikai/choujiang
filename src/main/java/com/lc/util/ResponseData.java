/** 
 * @ClassName:     ResponseData.java 
 * @author         MengJinyue
 * @描述：仅适用于分页查询
 */

package com.lc.util;

public class ResponseData<T> {

	private String responseState;
	private String message;
	private T data;
	private T page;

	public ResponseData(T data,T page) {
		this.responseState ="1";
		this.message = "查询成功";
		this.data = data;
		this.page = page;
	}

	public ResponseData() {

	}

	public String getResponseState() {
		return responseState;
	}

	public void setResponseState(String responseState) {
		this.responseState = responseState;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getPage() {
		return page;
	}

	public void setPage(T page) {
		this.page = page;
	}
}
