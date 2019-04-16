package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product_image;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Product_ImageService {

    int addProductImage(Product_image productImage);
    //删除商品时一起删除该商品下的图片
    int deleteProductImage(Integer id);

    List<Product_image> selectList(Integer id);

    int deleteImage(Integer id);
}
