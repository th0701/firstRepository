package com.tongxue.wxapp.pojo;

public class TypeOne {
    private Integer toId;
    private String toName;
    private Integer ptId;
    private String toImage;
    private Integer statu;
    private String toRemark;
    private String pt_name;

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public TypeOne(String toName, Integer ptId, String toImage, Integer statu, String toRemark) {
        this.toName = toName;
        this.ptId = ptId;
        this.toImage = toImage;
        this.statu = statu;
        this.toRemark = toRemark;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public String getToImage() {
        return toImage;
    }

    public void setToImage(String toImage) {
        this.toImage = toImage;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getToRemark() {
        return toRemark;
    }

    public void setToRemark(String toRemark) {
        this.toRemark = toRemark;
    }

    public TypeOne() {
    }
}
