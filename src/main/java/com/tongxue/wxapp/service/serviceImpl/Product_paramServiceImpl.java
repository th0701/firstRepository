package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.Product_paramMapper;
import com.tongxue.wxapp.pojo.Product_param;
import com.tongxue.wxapp.service.Product_paramService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Product_paramServiceImpl implements Product_paramService {
    @Resource
    private Product_paramMapper productParamMapper;

    @Override
    public Product_param selectCount(Integer id) {
        return productParamMapper.selectCount(id);
    }

    @Override
    public int updateParam(Product_param productParam) {
        return productParamMapper.updateParam(productParam);
}

    @Override
    public int deletePdParam(Integer id) {
        return productParamMapper.deletePdParam(id);
    }

    @Override
    public int addParam(Product_param productParam) {
        return productParamMapper.addParam(productParam);
    }
}
