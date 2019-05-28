package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.ProductMapper;
import com.tongxue.wxapp.dao.Product_ImageMapper;
import com.tongxue.wxapp.pojo.Diopter;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.pojo.Product_image;
import com.tongxue.wxapp.pojo.Product_showImage;
import com.tongxue.wxapp.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Resource
    private CollectService collectService;
    @Resource
    private Product_showImageService productShowImageService;
    @Resource
    private Product_paramService productParamService;
    @Resource
    private Ot_productService otProductService;


    @Override
    @Transactional
    public List<Product> select() {
        return productMapper.select();
    }

    @Override
    public Double selectPrice(Integer id) {
        return productMapper.selectPrice(id);
    }

    @Override
    public Integer selectId(String product_name) {
        return productMapper.selectId(product_name);
    }

    @Override
    @Transactional
    public Product selectProduct(Integer id,String openId) {
        Product product = productMapper.selectProduct(id);
        if(product!=null){
            int k=collectService.selectIsCollection(id,openId);
            if(k>0){
                product.setIsCollection(0);
            }else{
                product.setIsCollection(1);
            }
            List<Product_image> product_images = product_imageService.selectList(product.getProduct_id());
            List<Map<String ,String>> li=new ArrayList<>();
            for(Product_image product_image:product_images){
                Map<String,String> map=new HashMap();
                map.put("url",product_image.getUrl());
                li.add(map);
            }
            product.setAllImage(li);
            product.setAllColor(product_colorService.selectList(product.getProduct_id()));
            List<Product_showImage> product_showImages = productShowImageService.selectList(product.getProduct_id());
            List<Map<String ,String>> li1=new ArrayList<>();
            for(Product_showImage product_showImage:product_showImages){
                Map<String,String> map=new HashMap();
                map.put("imageUrl",product_showImage.getImageUrl());
                li1.add(map);
            }
            product.setShowImages(li1);
            product.setProductParam(productParamService.selectCount(product.getProduct_id()));
            List<Diopter> diopters = diopterService.selectAllDiopter(product.getProduct_id());
            List<Diopter> list=new ArrayList<>();
            if(diopters.size()>0){
                int j=diopters.get(0).getPd_colorId();
                for(Diopter diopter : diopters){
                    if(diopter.getPd_colorId()==j){
                        list.add(diopter);
                    }
                }
                product.setAllDiopter(list);
            }
        }
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
    public PageInfo<Product> selectList1(String porduct_name, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Product> products = productMapper.selectList1(porduct_name);
        PageInfo pageInfo=new PageInfo(products);
        return pageInfo;
    }

    @Override
    @Transactional
    public int deleteProduct(Integer id) {
        int i=productMapper.deleteProduct(id);
        int j=diopterService.deletePdDiopter(id);
        int k=product_colorService.deletePdColor(id);
        int l=productParamService.deletePdParam(id);
        int f=productShowImageService.deletePdImage(id);
        int u=otProductService.deletePdOt(id);
        return i;
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

    @Override
    public List<Product> selectWxTimeList(Integer ptId) {
        return productMapper.selectWxTimeList(ptId);
    }

    @Override
    public List<Product> selectWxPriceList(Integer ptId) {
        return productMapper.selectWxPriceList(ptId);
    }

    @Override
    public List<Product> selectAllProduct() {
        return productMapper.selectAllProduct();
    }

    @Override
    public List<Product> selectAllTimeProduct() {
        return productMapper.selectAllTimeProduct();
    }

    @Override
    public List<Product> selectAllPriceProduct() {
        return productMapper.selectAllPriceProduct();
    }
}
