package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.Product_colorMapper;
import com.tongxue.wxapp.pojo.Product_color;
import com.tongxue.wxapp.service.Product_colorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Product_colorServiceImpl implements Product_colorService {
    @Resource
    private Product_colorMapper product_colorMapper;

    @Override
    public int deleteColor(Integer id) {
        return product_colorMapper.deleteColor(id);
    }

    @Override
    public List<Product_color> selectList(Integer id) {
        return product_colorMapper.selectList(id);
    }

    @Override
    public int addProductColor(Product_color product_color) {
        return product_colorMapper.addProductColor(product_color);
    }
}
