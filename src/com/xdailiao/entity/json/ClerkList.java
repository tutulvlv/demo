package com.xdailiao.entity.json;

import java.io.Serializable;

public class ClerkList implements Serializable{
	private Integer orderitemid;
	private String username;
	private String comname;
	private String usertel;
	private Integer instatus;
	public Integer getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getInstatus() {
		return instatus;
	}
	public void setInstatus(Integer instatus) {
		this.instatus = instatus;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	@Override
	public String toString() {
		return "ClerkList [orderitemid=" + orderitemid + ", username="
				+ username + ", comname=" + comname + ", usertel=" + usertel
				+ ", instatus=" + instatus + "]";
	}
	
}
