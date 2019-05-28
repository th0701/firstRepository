package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.OrderMapper;
import com.tongxue.wxapp.pojo.Order;
import com.tongxue.wxapp.service.AddressService;
import com.tongxue.wxapp.service.OrderService;
import com.tongxue.wxapp.service.Order_itemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private Order_itemService order_itemService;
    @Resource
    private AddressService addressService;
    @Override
    @Transactional
    public int addOrder(Order order) {
        orderMapper.addOrder(order);
        return order.getOrder_id();
    }

    @Override
    public Integer selectCheck(String check) {
        Integer i = orderMapper.selectCheck(check);
        if(i==null){
            i=0;
        }
        return i;
    }

    @Override
    public List<Order> selectWxOneList(String openId ,Integer statu) {
        List<Order> orders = orderMapper.selectWxOneList(openId,statu);
        for(Order order : orders){
            order.setOrder_items(order_itemService.selectList(order.getOrder_id()));
        }
        return orders;
    }

    @Override
    public int updatePayTime(Order order) {
        return orderMapper.updatePayTime(order);
    }

    @Override
    public int updateOrderstatu(Order order) {
        return orderMapper.updateOrderstatu(order);
    }

    @Override
    public Order selectOrder(Integer id) {
        Order order = orderMapper.selectOrder(id);
        if(null!=order){
            order.setOrder_items(order_itemService.selectList(order.getOrder_id()));
            if(null!=order.getAddr_id()){
                order.setOrderAddress(addressService.selectOrderAddr(order.getAddr_id()));
            }
        }
        return order;
    }

    @Override
    public List<Order> selectWxList(String openId) {
        List<Order> orders = orderMapper.selectWxList(openId);
        for(Order order : orders){
            order.setOrder_items(order_itemService.selectList(order.getOrder_id()));
        }
        return orders;
    }

    @Override
    public List<Order> selectOneList(String order_no, Date order_creteTime) {
        return orderMapper.selectOneList(order_no,order_creteTime);
    }

    @Override
    public int updateStatu(String order_no) {
        return orderMapper.updateStatu(order_no);
    }

    @Override
    public int deleteOrder(Integer id) {
        int i=orderMapper.deleteOrder(id);
        int j=0;
        if(i>0){
            j=order_itemService.deleteOrderItem(id);
        }
        return j;
    }
}
