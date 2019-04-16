package com.tongxue.wxapp.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product_image;
import com.tongxue.wxapp.service.Product_ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/productimage")
public class Product_ImageController {
    @Resource
    private Product_ImageService product_imageService;
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Map<String, Object> upload(HttpServletRequest servletRequest,
                                      @RequestParam("file") MultipartFile file
    ) throws IOException {

        //如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = "G:/images";


            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);


            //判断路径是否存在，没有就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文档中
            File file1 = new File(path + File.separator + filename);
            file.transferTo(file1);

            Map<String, Object> res = new HashMap<>();
            //返回的是一个url对象
            String url=file1.toString();

            url="http://localhost"+url.substring(2).replaceAll("\\\\","/");
            res.put("url", url);
            return res;

        } else {
            return new HashMap<>();
        }

    }

    @RequestMapping("/addimage")
    @ResponseBody
    public String addimage(Product_image productImage){
        String st="";
        int i = product_imageService.addProductImage(productImage);
        if(i>0){
            st="添加成功";
        }else{
            st="添加失败";
        }
        return st;
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectlist(String id){
        Map map=new HashMap();
        List<Product_image> product_images = product_imageService.selectList(Integer.parseInt(id));
        map.put("code",0);
        map.put("data",product_images);
        return map;
    }

    @RequestMapping("/deleteImage")
    @ResponseBody
    public String deleteImage(Integer id){
        String st="";
        int i=product_imageService.deleteImage(id);
        if(i>0){
            st="0";
        }else{
            st="1";
        }
        return st;
    }
}
