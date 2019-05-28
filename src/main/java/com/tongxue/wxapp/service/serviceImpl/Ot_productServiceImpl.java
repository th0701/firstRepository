package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.Ot_productMapper;
import com.tongxue.wxapp.pojo.Ot_product;
import com.tongxue.wxapp.service.Ot_productService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Ot_productServiceImpl implements Ot_productService {
    @Resource
    private Ot_productMapper ot_productMapper;

    @Override
    public List<Ot_product> selectList(Integer id) {
        return ot_productMapper.selectList(id);
    }

    @Override
    public int deleteOt_product(Integer id) {
        return ot_productMapper.deleteOt_product(id);
    }

    @Override
    public int addot_product(Ot_product ot_product) {
        return ot_productMapper.addot_product(ot_product);
    }

    @Override
    public int deletePdOt(Integer id) {
        return ot_productMapper.deletePdOt(id);
    }
}
