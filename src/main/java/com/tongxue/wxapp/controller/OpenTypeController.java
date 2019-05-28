package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.OpenType;
import com.tongxue.wxapp.pojo.Product_Type;
import com.tongxue.wxapp.service.OpenTypeService;
import com.tongxue.wxapp.service.Product_TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/openType")
public class OpenTypeController {
    @Resource
    private OpenTypeService openTypeService;
    @Resource
    private Product_TypeService product_typeService;

    @RequestMapping("/index")
    public String index(){
        return "opentype/openTypeList";
    }

    @RequestMapping("/add")
    public String add(Model mo, String pt_parentId,String str) {
        if (pt_parentId == null) {
            pt_parentId="1";
        }
        List<Product_Type> list = product_typeService.selectidList(Integer.parseInt(pt_parentId));
        mo.addAttribute("list", list);
        mo.addAttribute("str",str);
        return "opentype/addOpen";
    }

    @RequestMapping("/addOpen")
    @ResponseBody
    public String addTypeOne(String str,OpenType openType){
        String st="";
        if("".equals(str)){
            int i=openTypeService.addopen(openType);
            if(i>0){
                st="0";
            }else{
                st="1";
            }
        }else{
            int i=openTypeService.updateOpenType(openType);
            if(i>0){
                st="2";
            }else{
                st="3";
            }
        }
        return st;
    }

    @ResponseBody
    @RequestMapping("/selectPageList")
    public Map selectList(String page, String limit){
        return openTypeService.selectPageList(Integer.parseInt(page),Integer.parseInt(limit));
    }

    @ResponseBody
    @RequestMapping("/deleteOpenType")
    public String deleteBanner(Integer id){
        int i=openTypeService.deleteOpenType(id);
        String st="";
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;

    }

    @ResponseBody
    @RequestMapping("selectTree")
    public List<OpenType> selectTree(){
        return OpenType.selectTree(openTypeService.selectList());
    }

    //假
    @ResponseBody
    @RequestMapping("selectTree1")
    public List<OpenType> selectTree1(){
        return OpenType.selectTree(openTypeService.selectList1());
    }
}
