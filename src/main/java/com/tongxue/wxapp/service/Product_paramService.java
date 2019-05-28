package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Product_param;

public interface Product_paramService {
    //判断是否已编辑过参数
    Product_param selectCount(Integer id);

    int addParam(Product_param productParam);

    int updateParam(Product_param productParam);

    int deletePdParam(Integer id);
}
