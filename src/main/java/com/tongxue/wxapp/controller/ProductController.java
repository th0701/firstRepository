package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.Product_Type;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.Product_ImageService;
import com.tongxue.wxapp.service.Product_TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private Product_TypeService product_typeService;
    @Resource
    private Product_ImageService product_imageService;

    @RequestMapping("/selectList")
    @ResponseBody
    public String selectList(String product_name,HttpSession session,String page,String limit){
        if(page==null || limit==null){
            page="1";
            limit="100";
        }
        PageInfo<Product> productPageInfo = productService.selectList(product_name, Integer.parseInt(page),Integer.parseInt(limit));
        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",productPageInfo.getTotal());
        obj.put("data", productPageInfo.getList());
        return obj.toJSONString();
    }

    @RequestMapping("/index")
    public String index(String currentPage, String product_name,  Model mo,HttpSession session){
        if(currentPage==null){
            currentPage="1";
        }
        PageInfo<Product> productPageInfo = productService.selectList(product_name, Integer.parseInt(currentPage) ,3);
        mo.addAttribute("page",productPageInfo);
        session.setAttribute("currentPage",Integer.parseInt(currentPage));
        return "product/productList";
    }

    @RequestMapping("/add")
    public String add(Model mo,String pt_parentId,String str){
        if(pt_parentId==null){
            pt_parentId="1";
        }
        List<Product_Type> list = product_typeService.selectidList(Integer.parseInt(pt_parentId));
        mo.addAttribute("list",list);
        mo.addAttribute("str",str);
        return "product/addproduct";
    }

    @RequestMapping("/addProduct")
    @ResponseBody
    public String addProduct(Product product,String str){
            JSONObject obj=new JSONObject();
            String st="";
            product.setProduct_uptime(new Date());
            if("".equals(str)){
                int i=productService.addProduct(product);
                if(i>0){
                    st="添加成功";
                }else{
                    st="添加失败";
                }
            }else{
                int i=productService.updateProduct(product);
                if(i>0){
                    st="修改成功";
                }else{
                    st="修改失败";
                }
            }
            return st;
    }

    @RequestMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(Integer id){
        int i=productService.deleteProduct(id);
        int j=product_imageService.deleteProductImage(id);
        String st="";
        if(i>0){
            st="0";
            if(j>0){
                st="3";
            }
        }else{
            st="1";
        }
        return st;
    }

    @RequestMapping("/addimage")
    public String addimage(Integer id, Model model){
        model.addAttribute("productId",id);
        return "productimage/addproductimage";
    }

    @RequestMapping("/selectType")
    @ResponseBody
    public List<Product> selectType(String ptId){
        return productService.selectType(Integer.parseInt(ptId));
    }

    @ResponseBody
    @RequestMapping("/selectDetail")
    public Product selectDetail(Integer product_id){
        return productService.selectProduct(product_id);
    }

    @ResponseBody
    @RequestMapping("/selectManyProduct")
    public List<Product> selectManyProduct(Integer pt_id){
        Integer i=product_typeService.selectParentId(pt_id);
        List<Product> list=new ArrayList<>();
        if(i!=0){
            List<Product> list1=productService.selectType(pt_id);
            for(Product product : list1){
                list.add(product);
            }
        }else{
            List<Product_Type> list2=product_typeService.selectChildren(pt_id);
            for(Product_Type product_type : list2){
                List<Product> list3=productService.selectType(product_type.getPt_Id());
                for(Product product : list3){
                    list.add(product);
                }
            }
        }
        return list;
    }
}
