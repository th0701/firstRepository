package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.Ot_product;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.service.Ot_productService;
import com.tongxue.wxapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ot_product")
public class Ot_productController {
    @Resource
    private Ot_productService ot_productService;
    @Resource
    private ProductService productService;

    @RequestMapping("/add")
    public String add(String id, Model mo,String str){
        List<Product> list =productService.selectType(Integer.parseInt(id));
        mo.addAttribute("str",str);
        mo.addAttribute("list",list);
        return "opentype/addOt_product";
    }

    @RequestMapping("/addOt_product")
    @ResponseBody
    public String addBanner(Ot_product ot_product, String str) {
        String st="";
        if("".equals(str) || str==null){
            int i=ot_productService.addot_product(ot_product);
            if(i>0){
                st="0";
            }else{
                st="1";
            }
        }else{
            int i=0;
            if(i>0){
                st="2";
            }else{
                st="3";
            }
        }
        return st;
    }

    @ResponseBody
    @RequestMapping("/selectList")
    public Map selectList(Integer id){
        Map map=new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data",ot_productService.selectList(id));
        return  map;
    }

    @ResponseBody
    @RequestMapping("/deleteOt_product")
    public String deleteOt_product(Integer id){
        int i=ot_productService.deleteOt_product(id);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;

    }
}
