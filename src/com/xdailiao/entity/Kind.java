package com.xdailiao.entity;

import java.io.Serializable;

/**
 * Created by tutu on 2016/10/24.
 */
public class Kind implements Serializable{
    private String kindid;
    private String kindname;

    public String getKindid() {
        return kindid;
    }

    public void setKindid(String kindid) {
        this.kindid = kindid;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }
}
