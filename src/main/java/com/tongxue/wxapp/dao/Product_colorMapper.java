package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product_color;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Product_colorMapper {
    @Insert("insert into product_color(pd_colorName,product_id,pd_colorImage) values(#{pd_colorName},#{product_id},#{pd_colorImage})")
    int addProductColor(Product_color product_color);

    @Select("select pd_colorId,pd_colorName,pd_colorImage from product_color where product_id=#{id}")
    List<Product_color> selectList(Integer id);

    @Delete("delete from product_color where pd_colorId=#{id}")
    int deleteColor(Integer id);

    //删除商品并删除颜色
    @Delete("delete from product_color where product_id=#{id}")
    int deletePdColor(Integer id);

    //根据商品id和颜色名称查找id
    @Select("select pd_colorId from product_color where product_id=#{id} and pd_colorName=#{pd_colorName}")
    Integer selectId(@Param("id") Integer id,@Param("pd_colorName") String pd_colorName);
}
