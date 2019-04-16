package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.Product_color;
import com.tongxue.wxapp.service.Product_colorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product_color")
public class Product_colorController {
    @Resource
    private Product_colorService product_colorService;

    @RequestMapping("/add")
    public String add(){
        return "product/addProductColor";
    }

    @RequestMapping("/addProductColor")
    @ResponseBody
    public String addProductColor(Product_color product_color){
        int i = product_colorService.addProductColor(product_color);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }

    @ResponseBody
    @RequestMapping("/selectList")
    public Map selectList(Integer id){
        Map map=new HashMap();
        map.put("code",0);
        map.put("data",product_colorService.selectList(id));
        return  map;
    }

    @RequestMapping("/deleteColor")
    @ResponseBody
    public String deleteImage(Integer id){
        String st="";
        int i=product_colorService.deleteColor(id);
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }
}
