package com.xdailiao.entity.json;

import java.io.Serializable;
import java.sql.Date;


/**
 * 牵涉五张表    user  pick  clerk  orderitem  relorder   
 * @author viakiba
 *
 */
public class AdminList implements Serializable{
	private String username;
	private String usertel;
	private Integer clerkid;
	private String clerktel;
	private String clerkname;
	private Double price;
	private Double weight;
	private Integer quantity;
	private Integer instatus ;
	private Date subtime;
	private Integer pickid;
	private String picktel;
	private Integer pickstatus;
	private Date picktime;
	private Integer paystatus;
	private Integer putstatus;
	private Integer orderitemid;
	private String orderimg;
	private String comname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getInstatus() {
		return instatus;
	}
	public void setInstatus(Integer instatus) {
		this.instatus = instatus;
	}
	
	public Integer getPickstatus() {
		return pickstatus;
	}
	public void setPickstatus(Integer pickstatus) {
		this.pickstatus = pickstatus;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	
	public Integer getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}
	public Integer getClerkid() {
		return clerkid;
	}
	public void setClerkid(Integer clerkid) {
		this.clerkid = clerkid;
	}
	public Integer getPickid() {
		return pickid;
	}
	public void setPickid(Integer pickid) {
		this.pickid = pickid;
	}
	
	public Integer getPutstatus() {
		return putstatus;
	}
	public void setPutstatus(Integer putstatus) {
		this.putstatus = putstatus;
	}
	public String getClerktel() {
		return clerktel;
	}
	public void setClerktel(String clerktel) {
		this.clerktel = clerktel;
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
	public String getClerkname() {
		return clerkname;
	}
	public void setClerkname(String clerkname) {
		this.clerkname = clerkname;
	}
	public String getPicktel() {
		return picktel;
	}
	public void setPicktel(String picktel) {
		this.picktel = picktel;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public Date getSubtime() {
		return subtime;
	}
	public void setSubtime(Date subtime) {
		this.subtime = subtime;
	}
	public Date getPicktime() {
		return picktime;
	}
	public void setPicktime(Date picktime) {
		this.picktime = picktime;
	}
	@Override
	public String toString() {
		return "AdminList [username=" + username + ", usertel=" + usertel
				+ ", clerkid=" + clerkid + ", clerktel=" + clerktel
				+ ", clerkname=" + clerkname + ", price=" + price + ", weight="
				+ weight + ", quantity=" + quantity + ", instatus=" + instatus
				+ ", subtime=" + subtime + ", pickid=" + pickid + ", picktel="
				+ picktel + ", pickstatus=" + pickstatus + ", picktime="
				+ picktime + ", paystatus=" + paystatus + ", putstatus="
				+ putstatus + ", orderitemid=" + orderitemid + ", orderimg="
				+ orderimg + ", comname=" + comname + "]";
	}
	
}
