package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.Product_ImageMapper;
import com.tongxue.wxapp.pojo.Product_image;
import com.tongxue.wxapp.service.Product_ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Product_ImageServiceImpl implements Product_ImageService {

    @Resource
    private Product_ImageMapper product_imageMapper;
    @Override
    @Transactional
    public int addProductImage(Product_image productImage) {
        return product_imageMapper.addProductImage(productImage);
    }

    @Override
    @Transactional
    public int deleteProductImage(Integer id) {
        return product_imageMapper.deleteProductImage(id);
    }

    @Override
    @Transactional
    public int deleteImage(Integer id) {
        return product_imageMapper.deleteImage(id);
    }

    @Override
    @Transactional
    public List<Product_image> selectList(Integer id) {
        return product_imageMapper.selectList(id);
    }
}
