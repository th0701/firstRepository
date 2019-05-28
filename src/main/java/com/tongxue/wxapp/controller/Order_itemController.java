package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.service.Order_itemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order_item")
public class Order_itemController {
    @Resource
    private Order_itemService order_itemService;

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectList(Integer id){
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("data",order_itemService.selectList(id));
        return map;
    }
}
