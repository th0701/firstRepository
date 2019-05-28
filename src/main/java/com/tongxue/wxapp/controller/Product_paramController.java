package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.Product_param;
import com.tongxue.wxapp.service.Product_paramService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/param")
public class Product_paramController {
    @Resource
    private Product_paramService productParamService;

    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        Product_param productParam = productParamService.selectCount(id);
        model.addAttribute("pa", productParam);
        return "productparam/updateParam";
    }

    @RequestMapping("/updateParam")
    @ResponseBody
    public String updateParam(Product_param productParam) {
        Product_param productParam1 = productParamService.selectCount(productParam.getProduct_id());
        String st = "";
        if (null != productParam1) {
            int i = productParamService.updateParam(productParam);
            if (i > 0) {
                st = "2";
            } else {
                st = "3";
            }
        } else {
            int j = productParamService.addParam(productParam);
            if (j > 0) {
                st = "0";
            } else {
                st = "1";
            }
        }
        return st;
    }
}
