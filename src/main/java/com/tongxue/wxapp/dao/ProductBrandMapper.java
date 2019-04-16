package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.ProductBrand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductBrandMapper {
    @Select("select pb_id,pb_name,pb_remark,pb_image from productbrand")
    List<ProductBrand> selectList();

    @Insert("insert into productBrand(pb_name,pb_remark,pb_image) values(#{pb_name},#{pb_remark},#{pb_image})")
    int addProductBrand(ProductBrand productBrand);

    @Update("update productBrand set pb_name=#{pb_name}, pb_remark=#{pb_remark}, pb_image=#{pb_image} where pb_id=#{pb_id}")
    int updateProductBrand(ProductBrand productBrand);

    @Delete("delete from productBrand where pb_id=#{id}")
    int deleteProductBrand(Integer id);
}
