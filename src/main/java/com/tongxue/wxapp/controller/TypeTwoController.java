package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product_Type;
import com.tongxue.wxapp.pojo.TypeTwo;
import com.tongxue.wxapp.service.Product_TypeService;
import com.tongxue.wxapp.service.TypeTowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/typeTwo")
public class TypeTwoController {
    @Resource
    private TypeTowService typeTowService;
    @Resource
    private Product_TypeService product_typeService;

    @RequestMapping("/index")
    public String index(){
        return "typetwo/typetwolist";
    }

    @ResponseBody
    @RequestMapping("/selectList")
    public String selectList(String page, String limit){
        PageInfo<TypeTwo> pageInfo=typeTowService.selectList(Integer.parseInt(page),Integer.parseInt(limit));
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data", pageInfo.getList());
        return obj.toJSONString();
    }

    //假
    @ResponseBody
    @RequestMapping("/selectList1")
    public String selectList1(String page, String limit){
        PageInfo<TypeTwo> pageInfo=typeTowService.selectList1(Integer.parseInt(page),Integer.parseInt(limit));
        JSONObject obj=new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data", pageInfo.getList());
        return obj.toJSONString();
    }

    @RequestMapping("/add")
    public String add(Model mo, String pt_parentId, String str){
        if(pt_parentId==null){
            pt_parentId="1";
        }
        List<Product_Type> list = product_typeService.selectidList(Integer.parseInt(pt_parentId));
        mo.addAttribute("list",list);
        mo.addAttribute("str",str);
        return "typetwo/addtypetwo";
    }

    @ResponseBody
    @RequestMapping("/deleteTypeTwo")
    public String deleteBanner(Integer id){
        int i=typeTowService.deleteType(id);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }

    @RequestMapping("/addTypeTwo")
    @ResponseBody
    public String addTypeOne(String str,TypeTwo typeOne){
        String st="";
        if("".equals(str)){
            int i=typeTowService.addType(typeOne);
            if(i>0){
                st="添加成功";
            }else{
                st="添加失败";
            }
        }else{
            int i=typeTowService.updateType(typeOne);
            if(i>0){
                st="修改成功";
            }else{
                st="修改失败";
            }
        }
        return st;
    }
}
