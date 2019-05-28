package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Product_showImage;

import java.util.List;

public interface Product_showImageService {
    //添加展示图片
    int addImageUrl(Product_showImage productShowImage);

    //后台展示
    List<Product_showImage> selectList(Integer id);

    //删除
    int deleteImageUrl(Integer id);

    int deletePdImage(Integer id);
}
