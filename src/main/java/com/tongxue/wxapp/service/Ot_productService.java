package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Ot_product;

import java.util.List;

public interface Ot_productService {
    int addot_product(Ot_product ot_product);

    List<Ot_product> selectList(Integer id);

    int deleteOt_product(Integer id);
}
