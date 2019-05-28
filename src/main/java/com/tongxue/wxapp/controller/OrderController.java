package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Order;
import com.tongxue.wxapp.pojo.Order_item;
import com.tongxue.wxapp.pojo.ShoppingCar;
import com.tongxue.wxapp.service.OrderService;
import com.tongxue.wxapp.service.Order_itemService;
import com.tongxue.wxapp.service.ShoppingCarService;
import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private Order_itemService order_itemService;
    @Resource
    private ShoppingCarService shoppingCarService;

    //购物车选取商品下单
    @RequestMapping("/addOrder")
    @ResponseBody
    public Map addOrder(@RequestBody JSONArray array) {
        Map map = new HashMap();
        List<ShoppingCar> list = JSONObject.parseArray(array.toJSONString(), ShoppingCar.class);
        List<ShoppingCar> selectList = shoppingCarService.selectArrayShopping(list);
        String check = "";
        for (ShoppingCar sh : list) {
            check = check + sh.getShopId();
        }
        int ii = orderService.selectCheck(check);
        if (ii == 0) {
            if (selectList != null) {
                Order order = new Order();
                Date date = new Date();
                int no = (int) ((Math.random() * 9 + 1) * 100000);
                String order_no = new SimpleDateFormat("yyyyMMdd").format(date) + no;
                order.setOrder_no(order_no);
                order.setCheck(check);
                order.setOrder_creteTime(date);
                order.setOpenId(selectList.get(0).getOpenId());
                order.setProduct_ser("不支持7天退货");
                Double payment = 0.0;
                List<Order_item> order_items = new ArrayList<>();
                for (ShoppingCar shoppingCar : selectList) {
                    payment += shoppingCar.getSumPrice();
                }
                order.setOrder_payment(payment);
                order.setOrder_deli(1);
                order.setOrder_sendMoney(0.0);
                order.setStatu(1);
                int i = orderService.addOrder(order);
                int j = 0;
                if (i > 0) {
                    for (ShoppingCar shoppingCar : selectList) {
                        Order_item order_item = new Order_item(i, shoppingCar.getProduct_id(), shoppingCar.getPd_colorId(), shoppingCar.getDiopterName(), shoppingCar.getProductPrice(), shoppingCar.getNum(), shoppingCar.getSumPrice(), date);
                        order_item.setItem_deli(1);
                        order_item.setItem_sendMoney(0.0);
                        order_item.setItem_ser("本商品不支持7天退换");
                        order_items.add(order_item);
                    }
                    j = order_itemService.addOrder_item(order_items);
                    if (j > 0) {
                        map.put("statu", 0);
                        map.put("msg", "添加成功");
                        map.put("order_id", i);
                    } else {
                        map.put("statu", 1);
                        map.put("msg", "添加失败");
                        orderService.deleteOrder(i);
                    }
                }
            }
        } else {
            map.put("statu", 0);
            map.put("msg", "添加成功");
            map.put("order_id", ii);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectOrder")
    public Map selectOrder(Integer order_id) {
        Map map = new HashMap();
        Order order = orderService.selectOrder(order_id);
        if (order != null) {
            map.put("statu", 0);
            map.put("msg", "");
            map.put("data", order);
        } else {
            map.put("statu", 1);
            map.put("msg", "没有找到该订单");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectOrderDetail")
    public Map selectOrderDetail(Integer order_id) {
        Map map = new HashMap();
        Order order = orderService.selectOrder(order_id);
        if (order != null) {
            map.put("code", 0);
            map.put("msg", "请求成功！");
            map.put("data", order);
        } else {
            map.put("code", 1);
            map.put("msg", "没有找到该订单");
        }
        return map;
    }


    @RequestMapping("/indexOne")
    public String indexOne() {
        return "order/orderOneList";
    }

    @RequestMapping("selectOneList")
    @ResponseBody
    public Map selectOneList(Integer page, Integer limit, String order_no, String order_creteTime) {
        Map map = new HashMap();
        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd");
        Date parse = null;
        try {
            parse = format.parse(order_creteTime);
        } catch (Exception e) {
            System.out.println(e);
        }
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(orderService.selectOneList(order_no, parse));
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    //商品详情页直接下单
    @RequestMapping("/addOneOrder")
    @ResponseBody
    public Map addOneOrder(Order_item order_item, String openId) {
        Map map = new HashMap();
        if (order_item.getProduct_id() != null && order_item.getPd_colorId() != null && order_item.getDiopterName() != null && order_item.getNum() != null  && order_item.getProduct_price() != null&openId!=null) {
            String check = order_item.getDiopterName() + order_item.getProduct_id() + order_item.getPd_colorId() + order_item.getNum();
            int ii = orderService.selectCheck(check);
            if (ii == 0) {
                Order order = new Order();
                Date date = new Date();
                int no = (int) ((Math.random() * 9 + 1) * 100000);
                String order_no = new SimpleDateFormat("yyyyMMdd").format(date) + no;
                order.setOrder_no(order_no);
                order.setCheck(check);
                order.setOrder_creteTime(date);
                order.setOpenId(openId);
                Double payment = order_item.getNum() * order_item.getProduct_price();
                order.setOrder_payment(payment);
                order.setStatu(1);
                int i = orderService.addOrder(order);
                if (i > 0) {
                    order_item.setOrder_id(i);
                    order_item.setItem_deli(1);
                    order_item.setItem_sendMoney(0.0);
                    order_item.setItem_ser("本商品不支持7天退换");
                    order_item.setSumPrice(payment);
                    order_item.setCreteTime(date);
                    int j=order_itemService.addOneOrder_item(order_item);
                    if (j > 0) {
                        map.put("statu", 0);
                        map.put("msg", "添加成功");
                        map.put("order_id", i);
                    } else {
                        map.put("statu", 1);
                        map.put("msg", "添加失败");
                        orderService.deleteOrder(i);
                    }
                }
            } else {
                map.put("statu", 0);
                map.put("msg", "添加成功");
                map.put("order_id", ii);
            }
        } else {
            map.put("statu", 1);
            map.put("msg", "参数不能为空");
        }
        return map;
    }

    @RequestMapping("/selectWxList")
    @ResponseBody
    public Map selectWxList(String openId){
        Map map=new HashMap();
        if(openId!=null && !"undefined".equals(openId)){
            List<Order> orders = orderService.selectWxList(openId);
            if(orders!=null && !orders.isEmpty()){
                map.put("code", 0);
                map.put("msg", "请求成功");
                map.put("data", orders);
            }else{
                map.put("code", 1);
                map.put("msg", "暂无数据");
            }
        }else{
            map.put("code", 1);
            map.put("msg", "参数不能为空或者是undifined");
        }
        return map;
    }

    @RequestMapping("/selectWxOneList")
    @ResponseBody
    public Map selectWxOneList(String openId,Integer statu){
        Map map=new HashMap();
        if(openId!=null & !"undefined".equals(openId)){
            List<Order> orders = orderService.selectWxOneList(openId ,statu);
            if(!orders.isEmpty()){
                map.put("code", 0);
                map.put("msg", "请求成功");
                map.put("data", orders);
            }else{
                map.put("code", 1);
                map.put("msg", "暂无数据");
            }
        }else{
            map.put("code", 1);
            map.put("msg", "参数不能为空或者是undefined");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteOrder")
    public Map deleteOrder(Integer order_id){
        Map map=new HashMap();
        if(order_id!=null){
            int i=orderService.deleteOrder(order_id);
            if(i>0){
                map.put("code", 0);
                map.put("msg", "删除成功!");
            }else{
                map.put("code", 1);
                map.put("msg", "删除失败!");
            }
        }else {
            map.put("code",1);
            map.put("msg","参数不能为空");
        }
        return map;
    }


}
