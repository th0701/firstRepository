package com.tongxue.wxapp.pojo;

public class Ot_product {
    private Integer ot_productId;
    private Integer product_id;
    private String product_name;
    private Double product_price;
    private String product_image;
    private String otName;
    private Integer parent_id;

    public String getOtName() {
        return otName;
    }

    public void setOtName(String otName) {
        this.otName = otName;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }



    public Integer getOt_productId() {
        return ot_productId;
    }

    public void setOt_productId(Integer ot_productId) {
        this.ot_productId = ot_productId;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Ot_product(Integer ot_productId, Integer product_id, String product_name, Double product_price, String product_image, String otName, Integer parent_id) {
        this.ot_productId = ot_productId;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_image = product_image;
        this.otName = otName;
        this.parent_id = parent_id;
    }

    public Ot_product() {
    }
}
