package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.ProductBrand;
import com.tongxue.wxapp.service.ProductBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/productBrand")
public class ProductBrandController {
    @Resource
    private ProductBrandService productBrandService;

    @RequestMapping("index")
    public String index(){
        return "productbrand/productBrandList";
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectList(){
        Map map=new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", productBrandService.selectList());
        return map;
    }

    @RequestMapping("/add")
    public String add(String str, Model mo){
        mo.addAttribute("str",str);
        return "productbrand/addProductBrand";
    }

    @RequestMapping("/addProductBrand")
    @ResponseBody
    public String addTypeOne(String str, ProductBrand productBrand){
        String st="";
        if("".equals(str)){
            int i=productBrandService.addProductBrand(productBrand);
            if(i>0){
                st="0";
            }else{
                st="1";
            }
        }else{
            int i=productBrandService.updateProductBrand(productBrand);
            if(i>0){
                st="2";
            }else{
                st="3";
            }
        }
        return st;
    }

    @ResponseBody
    @RequestMapping("/deleteProductBrand")
    public String deleteBanner(Integer id){
        int i=productBrandService.deleteProductBrand(id);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }

}
