package com.tongxue.wxapp.pojo;

public class Product_image {
    private Integer pi_id;
    private String pi_name;
    private String pi_image;
    private String url;
    private Integer pi_productId;
    private Integer statu;

    public Product_image(Integer pi_id, String pi_name, String pi_image, String url, Integer pi_productId, Integer statu) {
        this.pi_id = pi_id;
        this.pi_name = pi_name;
        this.pi_image = pi_image;
        this.url = url;
        this.pi_productId = pi_productId;
        this.statu = statu;
    }

    public Integer getPi_id() {
        return pi_id;
    }

    public void setPi_id(Integer pi_id) {
        this.pi_id = pi_id;
    }

    public String getPi_name() {
        return pi_name;
    }

    public void setPi_name(String pi_name) {
        this.pi_name = pi_name;
    }

    public String getPi_image() {
        return pi_image;
    }

    public void setPi_image(String pi_image) {
        this.pi_image = pi_image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product_image{" +
                "pi_id=" + pi_id +
                ", pi_name='" + pi_name + '\'' +
                ", pi_image='" + pi_image + '\'' +
                ", url='" + url + '\'' +
                ", pi_productId=" + pi_productId +
                ", statu=" + statu +
                '}';
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Integer getPi_productId() {
        return pi_productId;
    }

    public void setPi_productId(Integer pi_productId) {
        this.pi_productId = pi_productId;
    }

    public Product_image() {
    }
}
