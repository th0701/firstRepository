package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Product_Type;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Product_TypeService {

    public PageInfo<Product_Type> selectList(Integer currentPage, Integer pageSize);

    int addProduct_Type(Product_Type product_type);

    int deleteProduct_Type(Integer pt_id);

    int updeteProduct_Type(Integer pt_id);

    Product_Type selectOne(Integer pt_id);

    List<Product_Type> selectidList(Integer pt_parentId);

    int selectcount(Integer id);

    List<Product_Type> selectParent();

    List<Product_Type> selectParent1();

    List<Product_Type> selectChildren(Integer id);

    int selectParentId(Integer id);
}
