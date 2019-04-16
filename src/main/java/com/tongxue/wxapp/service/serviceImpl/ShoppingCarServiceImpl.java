package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.ShoppingCarMapper;
import com.tongxue.wxapp.pojo.ShoppingCar;
import com.tongxue.wxapp.service.ShoppingCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Resource
    private ShoppingCarMapper shoppingCarMapper;
    @Override
    @Transactional
    public PageInfo<ShoppingCar> selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(shoppingCarMapper.selectList());
    }

    @Override
    @Transactional
    public int addShopping(ShoppingCar shoppingCar) {
        return shoppingCarMapper.addShopping(shoppingCar);
    }

    @Override
    @Transactional
    public int updateShopping(ShoppingCar shoppingCar) {
        return shoppingCarMapper.updateShopping(shoppingCar);
    }

    @Override
    @Transactional
    public int deleteShopping(Integer id) {
        return shoppingCarMapper.deleteShopping(id);
    }
}
