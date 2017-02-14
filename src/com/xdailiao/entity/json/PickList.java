package com.xdailiao.entity.json;

import java.io.Serializable;

public class PickList implements Serializable{
	private Integer orderitemid;
	private String username;
	private String comname;
	private String usertel;
	private Integer pickstatus;
	private String orderimg;
	private Double weight;
	private Integer quantity;
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
	public Integer getPickstatus() {
		return pickstatus;
	}
	public void setPickstatus(Integer pickstatus) {
		this.pickstatus = pickstatus;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrderimg() {
		return orderimg;
	}
	public void setOrderimg(String orderimg) {
		this.orderimg = orderimg;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	@Override
	public String toString() {
		return "PickList [orderitemid=" + orderitemid + ", username="
				+ username + ", comname=" + comname + ", usertel=" + usertel
				+ ", pickstatus=" + pickstatus + ", orderimg=" + orderimg
				+ ", weight=" + weight + ", quantity=" + quantity + "]";
	}
	
}
