package com.lc.bean;
/**
 ** @author MengJinyue   
 *  创建时间：2017-7-25 下午05:23:22 
 */
public class OAuthInfo {
	private String accessToken;
	private Integer expiresIn;
	private String refreshToken;
	private String openId;
	private String scope;
	private String session_key;
	private String unionid;
	private int sex;
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	private String headimgurl;
	private String nickname;
	
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
}
