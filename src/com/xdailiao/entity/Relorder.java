package com.xdailiao.entity;

import java.io.Serializable;

/**
 * Created by tutu on 2016/10/24.
 */
public class Relorder implements Serializable{
    private Integer relid;
    private Integer orderitemid;
    private Integer userid;
    private Integer clerkid;
    private Integer pickid;
    private Integer kindid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRelid() {
        return relid;
    }

    public void setRelid(Integer relid) {
        this.relid = relid;
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

    public Integer getKindid() {
        return kindid;
    }

    public void setKindid(Integer kindid) {
        this.kindid = kindid;
    }
}
