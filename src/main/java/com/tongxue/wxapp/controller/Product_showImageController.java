package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.Product_showImage;
import com.tongxue.wxapp.service.Product_showImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/imageUrl")
public class Product_showImageController {
    @Resource
    private Product_showImageService productShowImageService;

    @RequestMapping("/addImageUrl")
    @ResponseBody
    public Map addImageUrl(Product_showImage productShowImage){
        Map map=new HashMap();
        int i=productShowImageService.addImageUrl(productShowImage);
        if(i>0){
            map.put("code",0);
            map.put("msg","添加成功");
        }else{
            map.put("code",1);
            map.put("msg","添加失败");
        }
        return map;
    }

    @RequestMapping("/add")
    public String add(){
        return "productimage/addImageUrl";
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectList(Integer id){
        Map map=new HashMap();
        List<Product_showImage> product_showImages = productShowImageService.selectList(id);
        map.put("code",0);
        map.put("msg","");
        map.put("data",product_showImages);
        return map;
    }

    @RequestMapping("/deleteImageUrl")
    @ResponseBody
    public String deleteImageUrl(Integer id){
        String st="";
        int i=productShowImageService.deleteImageUrl(id);
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }
}
