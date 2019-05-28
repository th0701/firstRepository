package com.tongxue.wxapp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer order_id;
    private String order_no;
    private String openId;
    private String nickName;
    private String ship_number;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date order_creteTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date order_payTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date order_sendTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date order_tackTime;
    private Integer addr_id;
    private String product_ser;
    private Double order_payment;
    private Integer order_deli;
    private Double order_sendMoney;
    private Integer statu;
    private String order_remark;
    private String check;
    private List<Order_item> order_items;
    private Address orderAddress;

    public Address getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(Address orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<Order_item> getOrder_items() {
        return order_items;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public void setOrder_items(List<Order_item> order_items) {
        this.order_items = order_items;
    }

    public Integer getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(Integer addr_id) {
        this.addr_id = addr_id;
    }



    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_no='" + order_no + '\'' +
                ", openId='" + openId + '\'' +
                ", ship_number='" + ship_number + '\'' +
                ", order_creteTime=" + order_creteTime +
                ", order_payTime=" + order_payTime +
                ", order_sendTime=" + order_sendTime +
                ", order_tackTime=" + order_tackTime +
                ", product_ser='" + product_ser + '\'' +
                ", order_payment=" + order_payment +
                ", order_deli=" + order_deli +
                ", order_sendMoney=" + order_sendMoney +
                ", statu=" + statu +
                ", order_remark='" + order_remark + '\'' +
                '}';
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getShip_number() {
        return ship_number;
    }

    public void setShip_number(String ship_number) {
        this.ship_number = ship_number;
    }

    public Date getOrder_creteTime() {
        return order_creteTime;
    }

    public void setOrder_creteTime(Date order_creteTime) {
        this.order_creteTime = order_creteTime;
    }

    public Date getOrder_payTime() {
        return order_payTime;
    }

    public void setOrder_payTime(Date order_payTime) {
        this.order_payTime = order_payTime;
    }

    public Date getOrder_sendTime() {
        return order_sendTime;
    }

    public void setOrder_sendTime(Date order_sendTime) {
        this.order_sendTime = order_sendTime;
    }

    public Date getOrder_tackTime() {
        return order_tackTime;
    }

    public void setOrder_tackTime(Date order_tackTime) {
        this.order_tackTime = order_tackTime;
    }

    public String getProduct_ser() {
        return product_ser;
    }

    public void setProduct_ser(String product_ser) {
        this.product_ser = product_ser;
    }

    public Double getOrder_payment() {
        return order_payment;
    }

    public void setOrder_payment(Double order_payment) {
        this.order_payment = order_payment;
    }

    public Integer getOrder_deli() {
        return order_deli;
    }

    public void setOrder_deli(Integer order_deli) {
        this.order_deli = order_deli;
    }

    public Double getOrder_sendMoney() {
        return order_sendMoney;
    }

    public void setOrder_sendMoney(Double order_sendMoney) {
        this.order_sendMoney = order_sendMoney;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getOrder_remark() {
        return order_remark;
    }

    public void setOrder_remark(String order_remark) {
        this.order_remark = order_remark;
    }

    public Order(Integer order_id, String order_no, String openId,String nickName, String ship_number, Date order_creteTime, Date order_payTime, Date order_sendTime, Date order_tackTime, Integer addr_id, String product_ser, Double order_payment, Integer order_deli, Double order_sendMoney, Integer statu, String order_remark) {
        this.order_id = order_id;
        this.order_no = order_no;
        this.openId = openId;
        this.nickName = nickName;
        this.ship_number = ship_number;
        this.order_creteTime = order_creteTime;
        this.order_payTime = order_payTime;
        this.order_sendTime = order_sendTime;
        this.order_tackTime = order_tackTime;
        this.addr_id = addr_id;
        this.product_ser = product_ser;
        this.order_payment = order_payment;
        this.order_deli = order_deli;
        this.order_sendMoney = order_sendMoney;
        this.statu = statu;
        this.order_remark = order_remark;
    }

    public Order() {
    }
}
