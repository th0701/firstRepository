package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.Product_image;

import java.util.List;
import java.util.Map;

public interface ProductService {

    PageInfo<Product> selectList(String porduct_name,Integer currentPage, Integer pageSize);

    int addProduct(Product product);

    int deleteProduct(Integer id);

    int updateProduct(Product product);

    List<Product> selectType(Integer ptId);

    List<Product> select();

    Product selectProduct(Integer id);


}
