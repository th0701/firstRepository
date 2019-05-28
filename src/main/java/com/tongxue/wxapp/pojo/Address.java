package com.tongxue.wxapp.pojo;

public class Address {
    private Integer addr_id;
    private String openId;
    private String tackName;
    private String tackNumber;
    private String tackCity;
    private String tackProvince;
    private Integer statu;

    public Address(Integer addr_id, String tackName, String tackNumber, String tackCity, String tackProvince) {
        this.addr_id = addr_id;
        this.tackName = tackName;
        this.tackNumber = tackNumber;
        this.tackCity = tackCity;
        this.tackProvince = tackProvince;
    }

    public Address(Integer addr_id, String openId, String tackName, String tackNumber, String tackCity, String tackProvince) {
        this.addr_id = addr_id;
        this.openId = openId;
        this.tackName = tackName;
        this.tackNumber = tackNumber;
        this.tackCity = tackCity;
        this.tackProvince = tackProvince;
    }

    public Address() {
    }

    public Integer getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(Integer addr_id) {
        this.addr_id = addr_id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTackName() {
        return tackName;
    }

    public void setTackName(String tackName) {
        this.tackName = tackName;
    }

    public String getTackNumber() {
        return tackNumber;
    }

    public void setTackNumber(String tackNumber) {
        this.tackNumber = tackNumber;
    }

    public String getTackCity() {
        return tackCity;
    }

    public void setTackCity(String tackCity) {
        this.tackCity = tackCity;
    }

    public String getTackProvince() {
        return tackProvince;
    }

    public void setTackProvince(String tackProvince) {
        this.tackProvince = tackProvince;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }
}
