package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Product_color;

import java.util.List;

public interface Product_colorService {
    int addProductColor(Product_color product_color);

    List<Product_color> selectList(Integer id);

    int deleteColor(Integer id);
}
