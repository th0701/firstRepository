package com.tongxue.wxapp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShoppingCar {
    private Integer shopId;
    private Integer wxUId;
    private Integer productId;
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

    public Integer getWxUId() {
        return wxUId;
    }

    public void setWxUId(Integer wxUId) {
        this.wxUId = wxUId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public ShoppingCar() {
    }

    public ShoppingCar(Integer shopId, Integer wxUId, Integer productId, Integer num, Double sumPrice, Integer statu, Date createTime, Date updateTime) {
        this.shopId = shopId;
        this.wxUId = wxUId;
        this.productId = productId;
        this.num = num;
        this.sumPrice = sumPrice;
        this.statu = statu;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
