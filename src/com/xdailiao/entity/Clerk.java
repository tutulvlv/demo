package com.xdailiao.entity;

import java.io.Serializable;

/**
 * Created by tutu on 2016/10/24.
 */
public class Clerk implements Serializable{
    private Integer clerkid;
    private String clerkname;
    private String clerktel;
    private String wcopenid;
    public Integer getClerkid() {
        return clerkid;
    }

    public void setClerkid(Integer clerkid) {
        this.clerkid = clerkid;
    }

    public String getClerkname() {
        return clerkname;
    }

    public void setClerkname(String clerkname) {
        this.clerkname = clerkname;
    }

    public String getClerktel() {
        return clerktel;
    }

    public void setClerktel(String clerktel) {
        this.clerktel = clerktel;
    }

	public String getWcopenid() {
		return wcopenid;
	}

	public void setWcopenid(String wcopenid) {
		this.wcopenid = wcopenid;
	}
    
}
