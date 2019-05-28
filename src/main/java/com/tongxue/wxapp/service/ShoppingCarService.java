package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.ShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCarService {

    PageInfo<ShoppingCar> selectList(Integer pageNum,Integer pageSize);

    int addShopping(ShoppingCar shoppingCar);

    int updateShopping(ShoppingCar shoppingCar);

    int deleteShopping(Integer id);

    ShoppingCar selectShopping(Integer product_id, String openId,Integer pd_colorId,String diopterName);

    int updateShopOne(ShoppingCar shoppingCar);

    List<ShoppingCar> selectWxList(String openId);

    int update(Integer shopId,Integer product_id,Integer or);

    int selectNum(Integer shopId);

    //批量删除
    int deleteArrayShopping(List<ShoppingCar> list);
    //选中商品生成订单
    List<ShoppingCar> selectArrayShopping(@Param("list") List<ShoppingCar> list);

    //找到完成支付的商品
    Integer selectShopId( Integer product_id, Integer pd_colorId, String diopterName , Integer num, String openId);
}
