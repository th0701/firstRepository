package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product_image;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Product_ImageMapper {
    @Insert("insert into product_image(pi_name, pi_productId, pi_image, url) values(#{pi_name}, #{pi_productId}, #{pi_image}, #{url})")
    int addProductImage(Product_image productImage);

    @Delete("delete from product_image where pi_productId=#{id}")
    int deleteProductImage(Integer id);

    @Select("select pi_id,pi_name,url from product_image where pi_productId=#{id}")
    List<Product_image> selectList(Integer id);

    @Delete("delete from product_image where pi_id=#{id}")
    int deleteImage(Integer id);
}
