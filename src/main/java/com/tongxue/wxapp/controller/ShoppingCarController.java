package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.xdevapi.JsonArray;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.ShoppingCar;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("wxAddShopping")
    @ResponseBody
    public Map wxAddShopping(String openId,Integer product_id,Integer pd_colorId,String diopterName,Integer num){
        Map map=new HashMap();
        if(openId!=null && product_id!=null &&pd_colorId!=null && diopterName!=null){
            System.out.println(diopterName);
            ShoppingCar shoppingCar1 = shoppingCarService.selectShopping(product_id, openId,pd_colorId,diopterName);
            if(num==null){
                num=1;
            }
            Double price=productService.selectPrice(product_id);
            if(shoppingCar1==null){
                ShoppingCar shoppingCar=new ShoppingCar(openId,product_id,pd_colorId,diopterName ,num);
                shoppingCar.setCreateTime(new Date());
                shoppingCar.setSumPrice(shoppingCar.getNum()*price);
                int i=shoppingCarService.addShopping(shoppingCar);
                if(i>0){
                    map.put("statu",0);
                    map.put("msg","添加成功");
                }else{
                    map.put("statu",1);
                    map.put("msg","添加失败");
                }
            }else{
                shoppingCar1.setUpdateTime(new Date());
                num=shoppingCar1.getNum()+num;
                shoppingCar1.setNum(num);
                shoppingCar1.setSumPrice(num*price);
                int k=shoppingCarService.updateShopOne(shoppingCar1);
                if(k>0){
                    map.put("statu",0);
                    map.put("msg","添加成功");
                }else{
                    map.put("statu",1);
                    map.put("msg","添加失败");
                }
            }
        }else{
            map.put("statu",1);
            map.put("msg","参数不能为null");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/selectWxList")
    public Map selectWxList(String openId){
        Map map=new HashMap();
        List<ShoppingCar> shoppingCars = shoppingCarService.selectWxList(openId);
        if(shoppingCars.size()>0){
            map.put("statu",0);
            map.put("msg","请求成功");
            map.put("data",shoppingCars);
        }else{
            map.put("statu",1);
            map.put("msg","暂无数据");
        }
        return map;
    }

    @RequestMapping("/updateNum")
    @ResponseBody
    public Map updateNum(Integer shopId,Integer product_id,Integer or){
        Map map=new HashMap();
        int i=shoppingCarService.update(shopId,product_id,or);
        if(i>0){
            map.put("statu",0);
            map.put("msg","修改成功");
            int j=shoppingCarService.selectNum(shopId);
            if(j==0){
                shoppingCarService.deleteShopping(shopId);
            }
        }else{
            map.put("statu",1);
            map.put("msg","修改失败");
        }
        return map;
    }

    //批量删除
    @ResponseBody
    @RequestMapping("/deleteArrayShopping")
    public Map deleteArrayShopping(@RequestBody JSONArray Array){
        Map map=new HashMap();
        List<ShoppingCar> list=(List)JSONObject.parseArray(Array.toJSONString(),ShoppingCar.class);
        int i=shoppingCarService.deleteArrayShopping(list);
        if(i>0){
            map.put("statu",0);
            map.put("msg","删除成功");
        }else{
            map.put("statu",1);
            map.put("msg","删除失败");
        }
        return map;
    }


}
