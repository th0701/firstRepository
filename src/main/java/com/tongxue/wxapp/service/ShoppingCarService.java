package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.ShoppingCar;

import java.util.List;

public interface ShoppingCarService {

    PageInfo<ShoppingCar> selectList(Integer pageNum,Integer pageSize);

    int addShopping(ShoppingCar shoppingCar);

    int updateShopping(ShoppingCar shoppingCar);

    int deleteShopping(Integer id);
}
