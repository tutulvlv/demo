package com.xdailiao.wechat.validate;

/**
 * 拿到用户消息第一步需要的信息 实体类
 * @author viakiba
 *
 */
public class Openid {
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	
	public Openid() {
		super();
	}
	
	public Openid(String access_token, String expires_in, String refresh_token,
			String openid, String scope) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.openid = openid;
		this.scope = scope;
	}


	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
}
