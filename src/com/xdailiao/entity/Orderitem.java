package com.xdailiao.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by tutu on 2016/10/24.
 */
public class Orderitem implements Serializable{
    private Integer orderitemid;
    private Double weight;
    private Integer quantity;
    private Double price;
    private String orderimg;
    private String orderdet;//
    private Timestamp createtime;//订单提交时间
    private String usertel;//用户的手机号
    private Timestamp allottime;
    private Timestamp subtime;
    private String subimg;
    private Integer instatus;
    private String indet;
    private Integer pickstatus;
    private Timestamp picktime;
    private String pickimg;
    private Integer putstatus;
    private Timestamp puttime;
    private String putimg;
    private String putdet;
    private Integer paystatus;
	public Integer getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOrderimg() {
		return orderimg;
	}
	public void setOrderimg(String orderimg) {
		this.orderimg = orderimg;
	}
	public String getOrderdet() {
		return orderdet;
	}
	public void setOrderdet(String orderdet) {
		this.orderdet = orderdet;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public Timestamp getAllottime() {
		return allottime;
	}
	public void setAllottime(Timestamp allottime) {
		this.allottime = allottime;
	}
	public Timestamp getSubtime() {
		return subtime;
	}
	public void setSubtime(Timestamp subtime) {
		this.subtime = subtime;
	}
	public String getSubimg() {
		return subimg;
	}
	public void setSubimg(String subimg) {
		this.subimg = subimg;
	}
	public Integer getInstatus() {
		return instatus;
	}
	public void setInstatus(Integer instatus) {
		this.instatus = instatus;
	}
	public String getIndet() {
		return indet;
	}
	public void setIndet(String indet) {
		this.indet = indet;
	}
	public Integer getPickstatus() {
		return pickstatus;
	}
	public void setPickstatus(Integer pickstatus) {
		this.pickstatus = pickstatus;
	}
	public Timestamp getPicktime() {
		return picktime;
	}
	public void setPicktime(Timestamp picktime) {
		this.picktime = picktime;
	}
	public String getPickimg() {
		return pickimg;
	}
	public void setPickimg(String pickimg) {
		this.pickimg = pickimg;
	}
	public Integer getPutstatus() {
		return putstatus;
	}
	public void setPutstatus(Integer putstatus) {
		this.putstatus = putstatus;
	}
	public Timestamp getPuttime() {
		return puttime;
	}
	public void setPuttime(Timestamp puttime) {
		this.puttime = puttime;
	}
	public String getPutimg() {
		return putimg;
	}
	public void setPutimg(String putimg) {
		this.putimg = putimg;
	}
	public String getPutdet() {
		return putdet;
	}
	public void setPutdet(String putdet) {
		this.putdet = putdet;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	@Override
	public String toString() {
		return "Orderitem [orderitemid=" + orderitemid + ", weight=" + weight
				+ ", quantity=" + quantity + ", price=" + price + ", orderimg="
				+ orderimg + ", orderdet=" + orderdet + ", createtime="
				+ createtime + ", usertel=" + usertel + ", allottime="
				+ allottime + ", subtime=" + subtime + ", subimg=" + subimg
				+ ", instatus=" + instatus + ", indet=" + indet
				+ ", pickstatus=" + pickstatus + ", picktime=" + picktime
				+ ", pickimg=" + pickimg + ", putstatus=" + putstatus
				+ ", puttime=" + puttime + ", putimg=" + putimg + ", putdet="
				+ putdet + ", paystatus=" + paystatus + "]";
	}
	
}
