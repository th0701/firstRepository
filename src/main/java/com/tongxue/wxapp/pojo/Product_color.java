package com.tongxue.wxapp.pojo;

public class Product_color {
    private Integer pd_colorId;
    private Integer product_id;
    private String pd_colorName;
    private String pd_colorImage;


    public Integer getPd_colorId() {
        return pd_colorId;
    }

    public void setPd_colorId(Integer pd_colorId) {
        this.pd_colorId = pd_colorId;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getPd_colorName() {
        return pd_colorName;
    }

    public void setPd_colorName(String pd_colorName) {
        this.pd_colorName = pd_colorName;
    }

    public String getPd_colorImage() {
        return pd_colorImage;
    }

    public void setPd_colorImage(String pd_colorImage) {
        this.pd_colorImage = pd_colorImage;
    }

    public Product_color(Integer pd_colorId, Integer product_id, String pd_colorName, String pd_colorImage) {
        this.pd_colorId = pd_colorId;
        this.product_id = product_id;
        this.pd_colorName = pd_colorName;
        this.pd_colorImage = pd_colorImage;
    }

    public Product_color() {
    }
}
