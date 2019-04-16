package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.ProductBrandMapper;
import com.tongxue.wxapp.pojo.ProductBrand;
import com.tongxue.wxapp.service.ProductBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductBrandServiceImpl implements ProductBrandService {
    @Resource
    private ProductBrandMapper productBrandMapper;
    @Override
    public List<ProductBrand> selectList() {
        return productBrandMapper.selectList();
    }

    @Override
    public int addProductBrand(ProductBrand productBrand) {
        return productBrandMapper.addProductBrand(productBrand);
    }

    @Override
    public int updateProductBrand(ProductBrand productBrand) {
        return productBrandMapper.updateProductBrand(productBrand);
    }

    @Override
    public int deleteProductBrand(Integer id) {
        return productBrandMapper.deleteProductBrand(id);
    }
}
