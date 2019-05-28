package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Diopter;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.Product_color;
import com.tongxue.wxapp.service.DiopterService;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.Product_colorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/diopter")
public class DiopterController {
    @Resource
    private DiopterService diopterService;
    @Resource
    private ProductService productService;
    @Resource
    private Product_colorService product_colorServicel;

    @RequestMapping("/index")
    public String index(){
        return "diopter/diopterList";
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectList(String page,String limit){
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        PageInfo<Diopter> pageInfo=new PageInfo<>(diopterService.selectList());
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/add")
    public String add(Model mo){
        List<Product> list=productService.select();
        mo.addAttribute("list",list);
        return "diopter/addDiopter";
    }

    @RequestMapping("/selectColor")
    @ResponseBody
    public List<Product_color> selectColor(Integer id){
        return product_colorServicel.selectList(id);
    }

    @RequestMapping("/addDiopter")
    @ResponseBody
    public String addDiopter(Diopter diopter){
        int i = diopterService.addDiopter(diopter);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }

    @RequestMapping("/deleteDiopter")
    @ResponseBody
    public String deleteDiopter(Integer id){
        String st="";
        int i=diopterService.deleteDiopter(id);
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }

    @ResponseBody
    @RequestMapping("/selectStock")
    public Map selectStock(Integer product_id, Integer pd_colorId, String diopterName){
        Integer stock=diopterService.selectStock(product_id,pd_colorId,diopterName);
        Map map=new HashMap();
        map.put("diopterStock",stock);
        return map;
    }

    //导入
    @RequestMapping(value = "/import")
    public String exImport(@RequestParam(value = "filename") MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = diopterService.batchImport(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:index";
    }

}
