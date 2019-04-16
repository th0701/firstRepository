package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.ProductMapper;
import com.tongxue.wxapp.dao.Product_ImageMapper;
import com.tongxue.wxapp.pojo.Diopter;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.Product_image;
import com.tongxue.wxapp.service.DiopterService;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.Product_ImageService;
import com.tongxue.wxapp.service.Product_colorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private Product_ImageService product_imageService;
    @Resource
    private Product_colorService product_colorService;
    @Resource
    private DiopterService diopterService;


    @Override
    @Transactional
    public List<Product> select() {
        return productMapper.select();
    }

    @Override
    public Product selectProduct(Integer id) {
        Product product = productMapper.selectProduct(id);
        product.setAllImage(product_imageService.selectList(product.getProduct_id()));
        product.setAllColor(product_colorService.selectList(product.getProduct_id()));
        List<Diopter> diopters = diopterService.selectAllDiopter(product.getProduct_id());
        List<Diopter> list=new ArrayList<>();
        int j=diopters.get(0).getPd_colorId();
        for(Diopter diopter : diopters){
            if(diopter.getPd_colorId()==j){
                list.add(diopter);
            }
        }
        product.setAllDiopter(list);
        return product;
    }

    @Override
    @Transactional
    public List<Product> selectType(Integer ptId) {
        return productMapper.selectType(ptId);
    }

    @Override
    @Transactional
    public PageInfo<Product> selectList(String porduct_name, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Product> products = productMapper.selectList(porduct_name);
        PageInfo pageInfo=new PageInfo(products);
        return pageInfo;
    }

    @Override
    @Transactional
    public int deleteProduct(Integer id) {
        return productMapper.deleteProduct(id);
    }

    @Override
    @Transactional
    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    @Override
    @Transactional
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }
}
