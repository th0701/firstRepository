package com.tongxue.wxapp.pojo;

public class ProductBrand {
    private Integer pb_id;
    private String pb_name;
    private String pb_remark;
    private String pb_image;

    public Integer getPb_id() {
        return pb_id;
    }

    public void setPb_id(Integer pb_id) {
        this.pb_id = pb_id;
    }

    public String getPb_name() {
        return pb_name;
    }

    public void setPb_name(String pb_name) {
        this.pb_name = pb_name;
    }

    public String getPb_remark() {
        return pb_remark;
    }

    public void setPb_remark(String pb_remark) {
        this.pb_remark = pb_remark;
    }

    public String getPb_image() {
        return pb_image;
    }

    public void setPb_image(String pb_image) {
        this.pb_image = pb_image;
    }

    public ProductBrand(Integer pb_id, String pb_name, String pb_remark, String pb_image) {
        this.pb_id = pb_id;
        this.pb_name = pb_name;
        this.pb_remark = pb_remark;
        this.pb_image = pb_image;
    }

    public ProductBrand() {
    }
}
