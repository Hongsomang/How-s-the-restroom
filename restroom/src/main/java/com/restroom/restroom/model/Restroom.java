package com.restroom.restroom.model;

import java.util.Date;

public class Restroom {
    private int code;
    private int subCategoryCode;
    private String name;
    private String address;
    private String time;
    private String unisexYn;
    private String publicYn;
    private String restroomPwd;
    private String rmk;
    private Date insDt;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(int subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUnisexYn() {
        return unisexYn;
    }

    public void setUnisexYn(String unisexYn) {
        this.unisexYn = unisexYn;
    }

    public String getPublicYn() {
        return publicYn;
    }

    public void setPublicYn(String publicYn) {
        this.publicYn = publicYn;
    }

    public String getRestroomPwd() {
        return restroomPwd;
    }

    public void setRestroomPwd(String restroomPwd) {
        this.restroomPwd = restroomPwd;
    }

    public String getRmk() {
        return rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public Date getInsDt() {
        return insDt;
    }

    public void setInsDt(Date insDt) {
        this.insDt = insDt;
    }
}
