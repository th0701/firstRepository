package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Order_item;

import java.util.List;

public interface Order_itemService {
    int addOrder_item(List<Order_item> list);

    List<Order_item> selectList(Integer id);

    int addOneOrder_item(Order_item order_item);

    //通过订单号找到订单下的商品
    List<Order_item> selectOrderItems(String order_no);

    //删除订单明细
    int deleteOrderItem(Integer id);
}
