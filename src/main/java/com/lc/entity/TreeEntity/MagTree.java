package com.lc.entity.TreeEntity;

import java.util.List;

public class MagTree {

	private String id;
	private String text;
	private String state = "opened";
	private List<MagTree> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<MagTree> getChildren() {
		return children;
	}
	public void setChildren(List<MagTree> children) {
		this.children = children;
	}
	
	
	
}
