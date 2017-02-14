package com.xdailiao.entity;

import java.io.Serializable;

/**
 * Created by tutu on 2016/10/24.
 */
public class Pick implements Serializable{
    private Integer pickid;
    private String pickname;
    private String picktel;
    private String pickdet;
    private String wcopenid;

    public Integer getPickid() {
        return pickid;
    }

    public void setPickid(Integer pickid) {
        this.pickid = pickid;
    }

    public String getPickname() {
        return pickname;
    }

    public void setPickname(String pickname) {
        this.pickname = pickname;
    }

    public String getPicktel() {
        return picktel;
    }

    public void setPicktel(String picktel) {
        this.picktel = picktel;
    }

    public String getPickdet() {
        return pickdet;
    }

    public void setPickdet(String pickdet) {
        this.pickdet = pickdet;
    }
    
	public String getWcopenid() {
		return wcopenid;
	}

	public void setWcopenid(String wcopenid) {
		this.wcopenid = wcopenid;
	}

	@Override
	public String toString() {
		return "Pick [pickid=" + pickid + ", pickname=" + pickname
				+ ", picktel=" + picktel + ", pickdet=" + pickdet
				+ ", wcopenid=" + wcopenid + "]";
	}

}
