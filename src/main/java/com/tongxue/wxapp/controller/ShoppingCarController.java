package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.ShoppingCar;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.ShoppingCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/shoppingCar")
public class ShoppingCarController {
    @Resource
    private ShoppingCarService shoppingCarService;
    @Resource
    private ProductService productService;

    @RequestMapping("index")
    public String index(){
        return "shoppingcar/shoppingcarlist";
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public String selectList(String page,String limit){
        PageInfo<ShoppingCar> pageInfo=shoppingCarService.selectList(Integer.parseInt(page),Integer.parseInt(limit));
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data", pageInfo.getList());
        return obj.toJSONString();
    }

    @RequestMapping("/add")
    public String add(Model mo,String str){
        List<Product> list = productService.select();
        mo.addAttribute("list",list);
        mo.addAttribute("str",str);
        return "shoppingcar/addshopping";
    }

    @RequestMapping("/addShopping")
    @ResponseBody
    public String addShopping(ShoppingCar shoppingCar,String str) {
        String st="";
        if("".equals(str)){
            shoppingCar.setCreateTime(new Date());
            int i=shoppingCarService.addShopping(shoppingCar);
            if(i>0){
                st="添加成功";
            }else{
                st="添加失败";
            }
        }else{
            shoppingCar.setUpdateTime(new Date());
            int i=shoppingCarService.updateShopping(shoppingCar);
            if(i>0){
                st="修改成功";
            }else{
                st="修改失败";
            }
        }
        return st;
    }

    @ResponseBody
    @RequestMapping("/deleteShopping")
    public String deleteShopping(Integer id){
        int i=shoppingCarService.deleteShopping(id);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;

    }


}
