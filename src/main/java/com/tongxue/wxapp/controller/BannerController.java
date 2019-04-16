package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Banner;
import com.tongxue.wxapp.pojo.Product_Type;
import com.tongxue.wxapp.service.BannerService;
import com.tongxue.wxapp.service.Product_TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;
    @Resource
    private Product_TypeService product_typeService;

    @RequestMapping("/addBanner")
    @ResponseBody
    public String addBanner(Banner banner,String str) {
        String st="";
            if("".equals(str)){
                int i=bannerService.addBanner(banner);
                if(i>0){
                    st="添加成功";
                }else{
                    st="添加失败";
                }
            }else{
                int i=bannerService.updeteBanner(banner);
                if(i>0){
                    st="修改成功";
                }else{
                    st="修改失败";
                }
            }
        return st;
    }

    @RequestMapping("/add")
    public String add(String str,Model mo,String pt_parentId) {
        if(pt_parentId==null){
            pt_parentId="1";
        }
        List<Product_Type> list = product_typeService.selectidList(Integer.parseInt(pt_parentId));
        mo.addAttribute("list",list);
        mo.addAttribute("str",str);
        return "banner/addbanner";
    }

    @ResponseBody
    @RequestMapping("/selectList")
    public String selectList(String page, String limit){
        PageInfo<Banner> pageInfo=bannerService.selectList(Integer.parseInt(page),Integer.parseInt(limit));
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data", pageInfo.getList());
        return obj.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/deleteBanner")
    public String deleteBanner(Integer id){
        int i=bannerService.deleteBanner(id);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;

    }

    @RequestMapping("/index")
    public String index() {
        return "banner/bannerList";
    }

    @RequestMapping("/selectTypeId")
    @ResponseBody
    public Map selectTypeId(Integer bannerId){
        Map map=new HashMap();
        int id = bannerService.selectProductId(bannerId);
        if(id!=0){
            map.put("type",2);
            Map back=new HashMap();
            back.put("product_id",id);
            map.put("back",back);
        }else if(id==0){
            Integer i=bannerService.selectTypeId(bannerId);
            map.put("type",1);
            Map back=new HashMap();
            back.put("pt_id",i);
            map.put("back",back);
        }
        return  map;
    }
}
