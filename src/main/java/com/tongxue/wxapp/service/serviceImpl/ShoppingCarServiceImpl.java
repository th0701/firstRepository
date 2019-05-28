package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.ShoppingCarMapper;
import com.tongxue.wxapp.pojo.ShoppingCar;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.ShoppingCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Resource
    private ShoppingCarMapper shoppingCarMapper;
    @Resource
    private ProductService productService;

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

    @Override
    public int updateShopOne(ShoppingCar shoppingCar) {
        return shoppingCarMapper.updateShopOne(shoppingCar);
    }

    @Override
    public List<ShoppingCar> selectWxList(String openId) {
        return shoppingCarMapper.selectWxList(openId);
    }

    @Override
    public ShoppingCar selectShopping(Integer product_id, String openId,Integer pd_colorId,String diopterName) {
        return shoppingCarMapper.selectShopping(product_id,openId,pd_colorId,diopterName);
    }

    @Override
    @Transactional
    public int update(Integer shopId,Integer product_id,Integer or) {
        int num=0;
        if(or==0){
            num=1;
        }else if(or==1){
            num=-1;
        }
        Double price=productService.selectPrice(product_id);
        int i=shoppingCarMapper.update(num,price,shopId);
        return i;
    }

    @Override
    public int selectNum(Integer shopId) {
        return shoppingCarMapper.selectNum(shopId);
    }

    @Override
    public int deleteArrayShopping(List<ShoppingCar> list) {
        return shoppingCarMapper.deleteArrayShopping(list);
    }

    @Override
    public List<ShoppingCar> selectArrayShopping(List<ShoppingCar> list) {
        return shoppingCarMapper.selectArrayShopping(list);
    }

    @Override
    public Integer selectShopId(Integer product_id, Integer pd_colorId, String diopterName, Integer num, String openId) {
        return shoppingCarMapper.selectShopId(product_id,pd_colorId,diopterName,num,openId);
    }
}
