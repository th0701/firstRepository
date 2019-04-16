package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product_color;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Product_colorMapper {
    @Insert("insert into product_color(pd_colorName,product_id,pd_colorImage) values(#{pd_colorName},#{product_id},#{pd_colorImage})")
    int addProductColor(Product_color product_color);

    @Select("select pd_colorId,pd_colorName,pd_colorImage from product_color where product_id=#{id}")
    List<Product_color> selectList(Integer id);

    @Delete("delete from product_color where pd_colorId=#{id}")
    int deleteColor(Integer id);
}
