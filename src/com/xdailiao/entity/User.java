package com.xdailiao.entity;

import java.io.Serializable;

/**
 * Created by tutu on 2016/10/24.
 */
public class User implements Serializable{
    private Integer userid;
    private String username;
    private String password;
    private String usertel;
    private String subnum;
    private String comname;
    private String comtype;
    private String wcopenid;
    private Integer status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getSubnum() {
        return subnum;
    }

    public void setSubnum(String subnum) {
        this.subnum = subnum;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComtype() {
        return comtype;
    }

    public void setComtype(String comtype) {
        this.comtype = comtype;
    }
    
    
	public String getWcopenid() {
		return wcopenid;
	}

	public void setWcopenid(String wcopenid) {
		this.wcopenid = wcopenid;
	}

	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", usertel=" + usertel
				+ ", subnum=" + subnum + ", comname=" + comname + ", comtype="
				+ comtype + ", wcopenid=" + wcopenid + ", status=" + status
				+ "]";
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
