package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.ProductBrand;

import java.util.List;

public interface ProductBrandService {
    List<ProductBrand> selectList();


    int addProductBrand(ProductBrand productBrand);


    int updateProductBrand(ProductBrand productBrand);

    int deleteProductBrand(Integer id);
}
