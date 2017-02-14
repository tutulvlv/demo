package com.xdailiao.entity.json;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UserOrder {
	private Integer orderitemid;
	private Double price;
	private Timestamp createtime;
	private Integer instatus;
	private Timestamp subtime;
	private Integer pickstatus;
	private Timestamp picktime;
	private Integer paystatus;
	public Integer getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCreatetime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(createtime);
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getInstatus() {
		return instatus;
	}
	public void setInstatus(Integer instatus) {
		this.instatus = instatus;
	}
	public String getSubtime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(subtime);
	}
	public void setSubtime(Timestamp subtime) {
		this.subtime = subtime;
	}
	public Integer getPickstatus() {
		return pickstatus;
	}
	public void setPickstatus(Integer pickstatus) {
		this.pickstatus = pickstatus;
	}
	public String getPicktime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(picktime);
	}
	public void setPicktime(Timestamp picktime) {
		this.picktime = picktime;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	@Override
	public String toString() {
		return "UserOrderList [orderitemid=" + orderitemid + ", price=" + price
				+ ", createtime=" + createtime + ", instatus=" + instatus
				+ ", subtime=" + subtime + ", pickstatus=" + pickstatus
				+ ", picktime=" + picktime + ", paystatus=" + paystatus + "]";
	}
	
}
