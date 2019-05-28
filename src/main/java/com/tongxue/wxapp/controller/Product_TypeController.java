package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product_Type;
import com.tongxue.wxapp.service.Product_TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product_type")
public class Product_TypeController {
    @Resource
    private Product_TypeService product_typeService;



    @RequestMapping("/index")
    public String index() {
        return "producttype/productTypeList";
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public String selectList(String page, String limit) {
        PageInfo<Product_Type> pageInfo = product_typeService.selectList(Integer.parseInt(page), Integer.parseInt(limit));
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", pageInfo.getTotal());
        obj.put("data", pageInfo.getList());
        return obj.toJSONString();
    }

    @RequestMapping("/deleteproducttype")
    @ResponseBody
    public String deleteproducttype(Integer id) {
        int j = product_typeService.selectcount(id);
        String st = "";
        if (j == 0) {
            int i = product_typeService.deleteProduct_Type(id);
            if (i > 0) {
                st = "0";
            } else {
                st = "1";
            }
        } else {
            st = "2";
        }
        return st;
    }

    @RequestMapping("/add")
    public String add(Model mo, String pt_parentId) {
        if (pt_parentId == null) {
            List<Product_Type> list = product_typeService.selectidList(null);
            mo.addAttribute("list", list);
        }
        return "producttype/addproducttype";
    }

    @RequestMapping("/addproducttype")
    @ResponseBody
    public String addproducttype(Product_Type product_type) {
        String str = "";
        int i = product_typeService.addProduct_Type(product_type);
        if (i > 0) {
            str = "添加成功";
        } else {
            str = "添加失败";
        }
        return str;
    }

    @RequestMapping("/selectTree")
    @ResponseBody
    public List<Product_Type> selectTree(){
        return Product_Type.getList(product_typeService.selectParent());
    }

    @RequestMapping("/selectTree1")
    @ResponseBody
    public List<Product_Type> selectTree1(){
        return Product_Type.getList(product_typeService.selectParent1());
    }
}
