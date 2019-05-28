package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.Order_itemMapper;
import com.tongxue.wxapp.pojo.Order_item;
import com.tongxue.wxapp.service.Order_itemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Order_itemServiceImpl implements Order_itemService {
    @Resource
    private Order_itemMapper order_itemMapper;
    @Override
    @Transactional
    public int addOrder_item(List<Order_item> list) {
        return order_itemMapper.addOrder_item(list);
    }

    @Override
    public int addOneOrder_item(Order_item order_item) {
        return order_itemMapper.addOneOrder_item(order_item);
    }

    @Override
    public List<Order_item> selectList(Integer id) {
        return order_itemMapper.selectList(id);
    }

    @Override
    @Transactional
    public List<Order_item> selectOrderItems(String order_no) {
        return order_itemMapper.selectOrderItems(order_no);
    }

    @Override
    @Transactional
    public int deleteOrderItem(Integer id) {
        return order_itemMapper.deleteOrderItem(id);
    }
}
