package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product_param;
import org.apache.ibatis.annotations.*;

@Mapper
public interface Product_paramMapper {
    //判断是否已编辑过参数
    @Select("select param_id,product_id,product_brand,product_sinck,product_diameter,product_cycle,product_stand,product_water,product_area,product_colorType,product_documentNumber,product_company from product_param where product_id=#{id}")
    Product_param selectCount(Integer id);

    //给商品录入参数
    @Insert("insert into product_param(product_id,product_brand,product_sinck,product_diameter,product_cycle,product_stand,product_water,product_area,product_colorType,product_documentNumber,product_company)" +
            " values(#{product_id},#{product_brand},#{product_sinck},#{product_diameter},#{product_cycle},#{product_stand},#{product_water},#{product_area},#{product_colorType},#{product_documentNumber},#{product_company})")
    int addParam(Product_param productParam);

    @Update("update product_param set product_brand=#{product_brand},product_sinck=#{product_sinck},product_diameter=#{product_diameter},product_cycle=#{product_cycle},product_stand=#{product_stand}," +
            "product_water=#{product_water},product_area=#{product_area},product_colorType=#{product_colorType},product_documentNumber=#{product_documentNumber},product_company=#{product_company} " +
            "where product_id=#{product_id}")
    int updateParam(Product_param productParam);

    //删除商品并删除该商品的参数
    @Delete("delete from product_param where product_id=#{id}")
    int deletePdParam(Integer id);
}
