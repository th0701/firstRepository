package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.ShoppingCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {
    @Select("select a.shopid,a.wxuid,a.productid,a.num,a.sumprice,a.statu,a.createTime,a.updateTime from shoppingcar a")
    List<ShoppingCar> selectList();

    @Insert("insert into shoppingcar(shopid,wxuid,productid,num,sumprice,createTime,updateTime) values(#{shopId},#{wxUId},#{productId},#{num},#{sumPrice},#{createTime},#{updateTime})")
    int addShopping(ShoppingCar shoppingCar);

    @Update("update shoppingcar set wxuid=#{wxUId},productid=#{productId},num=#{num},sumprice=#{sumPrice},updateTime=#{updateTime} where shopid=#{shopId}")
    int updateShopping(ShoppingCar shoppingCar);

    @Delete("delete from shoppingcar where shopid=#{id}")
    int deleteShopping(Integer id);
}
