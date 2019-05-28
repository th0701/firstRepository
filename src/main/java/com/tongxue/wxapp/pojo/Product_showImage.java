package com.tongxue.wxapp.pojo;

public class Product_showImage {
    private Integer image_id;
    private Integer product_id;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    private String imageUrl;
    private Integer statu;

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Product_showImage(Integer image_id, Integer product_id, String imageUrl, Integer statu) {
        this.image_id = image_id;
        this.product_id = product_id;
        this.imageUrl = imageUrl;
        this.statu = statu;
    }

    public Product_showImage() {
    }
}
