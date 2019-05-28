package com.tongxue.wxapp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShoppingCar {
    private Integer shopId;
    private String openId;
    private String nickName;
    private Integer product_id;
    private String pdImage;
    private String productName;
    private Double productPrice;
    private Integer pd_colorId;
    private String colorName;
    private String diopterName;
    private Integer num;
    private Double sumPrice;
    private Integer statu;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getPdImage() {
        return pdImage;
    }

    public void setPdImage(String pdImage) {
        this.pdImage = pdImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getPd_colorId() {
        return pd_colorId;
    }

    public void setPd_colorId(Integer pd_colorId) {
        this.pd_colorId = pd_colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getDiopterName() {
        return diopterName;
    }

    public void setDiopterName(String diopterName) {
        this.diopterName = diopterName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ShoppingCar(String openId, Integer product_id, Integer pd_colorId, String diopterName, Integer num) {
        this.openId = openId;
        this.product_id = product_id;
        this.pd_colorId = pd_colorId;
        this.diopterName = diopterName;
        this.num = num;
    }

    public ShoppingCar(Integer shopId, String openId, String nickName, Integer product_id, String pdImage, String productName, Double productPrice, Integer pd_colorId, String colorName, String diopterName, Integer num, Double sumPrice, Integer statu, Date createTime, Date updateTime) {
        this.shopId = shopId;
        this.openId = openId;
        this.nickName = nickName;
        this.product_id = product_id;
        this.pdImage = pdImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.pd_colorId = pd_colorId;
        this.colorName = colorName;
        this.diopterName = diopterName;
        this.num = num;
        this.sumPrice = sumPrice;
        this.statu = statu;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ShoppingCar() {
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "shopId=" + shopId +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", product_id=" + product_id +
                ", pdImage='" + pdImage + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", pd_colorId=" + pd_colorId +
                ", colorName='" + colorName + '\'' +
                ", diopterName='" + diopterName + '\'' +
                ", num=" + num +
                ", sumPrice=" + sumPrice +
                ", statu=" + statu +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
