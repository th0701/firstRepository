package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    int addOrder(Order order);

    int deleteOrder(Integer id);

    Order selectOrder(Integer id);

    //校检是否生成过订单
    Integer selectCheck(String check);

    //查询所有未支付订单
    List<Order> selectOneList(String order_no, Date order_creteTime);

    //查询该用户所有的订单
    List<Order> selectWxList(String openId);

    //查询该用户未支付订单
    List<Order> selectWxOneList(String openId ,Integer statu);

    //绑定地址信息
    int updateOrderstatu(Order order);

    //修改订单状态
    int updatePayTime(Order order);

    //取消订单修改状态
    int updateStatu(String order_no);

}
