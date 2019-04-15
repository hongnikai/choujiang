package com.lc.bean;

import java.util.List;

/**
 ** @author MengJinyue   
 *  创建时间：2017-12-11 下午04:50:44 
 */
public class SpecBean {
	private Integer spec_id;
	private String spec_name;
	private List<Object> specValueList;
	
	public Integer getSpec_id() {
		return spec_id;
	}
	public void setSpec_id(Integer spec_id) {
		this.spec_id = spec_id;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
	public List<Object> getSpecValueList() {
		return specValueList;
	}
	public void setSpecValueList(List<Object> specValueList) {
		this.specValueList = specValueList;
	}
	
}
