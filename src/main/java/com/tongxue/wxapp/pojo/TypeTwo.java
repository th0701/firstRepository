package com.tongxue.wxapp.pojo;

public class TypeTwo {
    private Integer ttId;
    private String ttName;
    private Integer ptId;
    private String ttImage;
    private Integer statu;
    private String ttRemark;
    private String pt_name;

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public Integer getTtId() {
        return ttId;
    }

    public void setTtId(Integer ttId) {
        this.ttId = ttId;
    }

    public String getTtName() {
        return ttName;
    }

    public void setTtName(String ttName) {
        this.ttName = ttName;
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public String getTtImage() {
        return ttImage;
    }

    public void setTtImage(String ttImage) {
        this.ttImage = ttImage;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getTtRemark() {
        return ttRemark;
    }

    public void setTtRemark(String ttRemark) {
        this.ttRemark = ttRemark;
    }

    public TypeTwo(Integer ttId, String ttName, Integer ptId, String ttImage, Integer statu, String ttRemark) {
        this.ttId = ttId;
        this.ttName = ttName;
        this.ptId = ptId;
        this.ttImage = ttImage;
        this.statu = statu;
        this.ttRemark = ttRemark;
    }

    public TypeTwo() {
    }
}
