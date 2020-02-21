package com.my.demo5.po;

import java.util.Date;

public class Brand {
    private Integer brandId;

    private String name;

    private Boolean isIpo;

    private Date foundTime;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsIpo() {
        return isIpo;
    }

    public void setIsIpo(Boolean isIpo) {
        this.isIpo = isIpo;
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }
}