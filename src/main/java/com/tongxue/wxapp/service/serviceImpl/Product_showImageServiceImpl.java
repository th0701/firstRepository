package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.Product_showImageMapper;
import com.tongxue.wxapp.pojo.Product_showImage;
import com.tongxue.wxapp.service.Product_showImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Product_showImageServiceImpl implements Product_showImageService {
    @Resource
    private Product_showImageMapper productShowImageMapper;


    @Override
    public int deleteImageUrl(Integer id) {
        return productShowImageMapper.deleteImageUrl(id);
    }

    @Override
    public List<Product_showImage> selectList(Integer id) {
        return productShowImageMapper.selectList(id);
    }

    @Override
    public int addImageUrl(Product_showImage productShowImage) {
        return productShowImageMapper.addImageUrl(productShowImage);
    }

    @Override
    public int deletePdImage(Integer id) {
        return productShowImageMapper.deletePdImage(id);
    }
}
