package com.tongxue.wxapp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Product {
    private Integer product_id;
    private String product_name;
    private Integer product_type;
    private String product_addr;
    private String product_remark;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date product_uptime;
    private Double product_price;
    private String product_image;
    private String pt_name;
    private Integer shopCount=0;
    private Integer viewCount=0;
    private List<Map<String,String>> allImage;
    private List<Product_color> allColor;
    private List<Diopter> allDiopter;
    private Integer isCollection;
    private List<Map<String,String>> showImages;
    private Product_param productParam;


    public List<Map<String, String>> getShowImages() {
        return showImages;
    }

    public void setShowImages(List<Map<String, String>> showImages) {
        this.showImages = showImages;
    }

    public Product_param getProductParam() {
        return productParam;
    }

    public void setProductParam(Product_param productParam) {
        this.productParam = productParam;
    }

    public Integer getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Integer isCollection) {
        this.isCollection = isCollection;
    }

    public Integer getShopCount() {
        return shopCount;
    }

    public void setShopCount(Integer shopCount) {
        this.shopCount = shopCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public List<Product_color> getAllColor() {
        return allColor;
    }

    public void setAllColor(List<Product_color> allColor) {
        this.allColor = allColor;
    }

    public List<Diopter> getAllDiopter() {
        return allDiopter;
    }

    public void setAllDiopter(List<Diopter> allDiopter) {
        this.allDiopter = allDiopter;
    }

    public Product(Integer product_id, String product_name, List<Map<String ,String>> allImage, Integer product_type, Integer product_stock, String product_addr, Integer pb_id, String pb_name, String product_remark, Date product_uptime, Double product_price, String product_image, String pt_name) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.allImage = allImage;
        this.product_type = product_type;
        this.product_addr = product_addr;

        this.product_remark = product_remark;
        this.product_uptime = product_uptime;
        this.product_price = product_price;
        this.product_image = product_image;
        this.pt_name = pt_name;
    }



    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Product() {
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

    public List<Map<String, String>> getAllImage() {
        return allImage;
    }

    public void setAllImage(List<Map<String, String>> allImage) {
        this.allImage = allImage;
    }

    public Integer getProduct_type() {
        return product_type;
    }

    public void setProduct_type(Integer product_type) {
        this.product_type = product_type;
    }

    public String getProduct_addr() {
        return product_addr;
    }

    public void setProduct_addr(String product_addr) {
        this.product_addr = product_addr;
    }

    public String getProduct_remark() {
        return product_remark;
    }

    public void setProduct_remark(String product_remark) {
        this.product_remark = product_remark;
    }

    public Date getProduct_uptime() {
        return product_uptime;
    }

    public void setProduct_uptime(Date product_uptime) {
        this.product_uptime = product_uptime;
    }

    public Product(Integer product_id) {
        this.product_id = product_id;
    }
}
