package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.Product_TypeMapper;
import com.tongxue.wxapp.pojo.Product_Type;
import com.tongxue.wxapp.service.Product_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Product_TypeServiceImpl  implements Product_TypeService {
    @Resource
    private Product_TypeMapper product_typeMapper;
    @Override
    @Transactional
    public PageInfo<Product_Type> selectList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product_Type> docs = product_typeMapper.selectList();
        PageInfo<Product_Type> pageInfo = new PageInfo<>(docs);
        return pageInfo;
    }

    @Override
    @Transactional
    public int selectcount(Integer id) {
        return product_typeMapper.selectcount(id);
    }

    @Override
    @Transactional
    public List<Product_Type> selectParent() {
        return product_typeMapper.selectParent();
    }

    @Override
    @Transactional
    public List<Product_Type> selectParent1() {
        return product_typeMapper.selectParent1();
    }

    @Override
    @Transactional
    public List<Product_Type> selectChildren(Integer id) {
        return product_typeMapper.selectChildren(id);
    }

    @Override
    public int selectParentId(Integer id) {
        Integer integer = product_typeMapper.selectParentId(id);
        System.out.println(integer);
        Integer i=0;
        if(integer!=null){
            i=integer;
        }
        return i;
    }

    @Override
    @Transactional
    public int addProduct_Type(Product_Type product_type) {
        return product_typeMapper.addProduct_Type(product_type);
    }

    @Override
    @Transactional
    public int deleteProduct_Type(Integer pt_id) {
        return product_typeMapper.deleteProduct_Type(pt_id);
    }

    @Override
    @Transactional
    public int updeteProduct_Type(Integer pt_id) {
        return product_typeMapper.updeteProduct_Type(pt_id);
    }

    @Override
    @Transactional
    public List<Product_Type> selectidList(Integer pt_parentId) {
        return product_typeMapper.selectidList(pt_parentId);
    }

    @Override
    @Transactional
    public Product_Type selectOne(Integer pt_id) {
        return product_typeMapper.selectOne(pt_id);
    }
}
