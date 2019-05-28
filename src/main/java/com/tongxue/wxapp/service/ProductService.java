package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.Product_image;

import java.util.List;
import java.util.Map;

public interface ProductService {

    PageInfo<Product> selectList(String porduct_name,Integer currentPage, Integer pageSize);

    //假
    PageInfo<Product> selectList1(String porduct_name,Integer currentPage, Integer pageSize);

    int addProduct(Product product);

    int deleteProduct(Integer id);

    int updateProduct(Product product);

    List<Product> selectType(Integer ptId);

    List<Product> select();

    Product selectProduct(Integer id,String openId);

    Double selectPrice(Integer id);

    //根据时间排序
    List<Product> selectWxTimeList(Integer ptId);

    //根据价格排序
    List<Product> selectWxPriceList(Integer ptId);

    List<Product> selectAllProduct();

    //全部商品新品
    List<Product> selectAllTimeProduct();

    //全部商品价格
    List<Product> selectAllPriceProduct();

    //根据名称查找id
    Integer selectId(String product_name);


}
