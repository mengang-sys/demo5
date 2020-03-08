package com.my.demo55.po;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5890970457397521906L;
    private Long uid;

    private String uname;

    private String pwd;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}