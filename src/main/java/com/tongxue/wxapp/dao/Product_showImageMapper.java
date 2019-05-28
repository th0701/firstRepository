package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product_showImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Product_showImageMapper {
    //添加商品下方展示图片
    @Insert("insert into product_showimage(product_id,imageUrl) values(#{product_id},#{imageUrl})")
    int addImageUrl(Product_showImage productShowImage);

    //后台展示
    @Select("select image_id,imageUrl from product_showimage where product_id=#{id}")
    List<Product_showImage> selectList(Integer id);

    //删除展示图片
    @Delete("delete from product_showimage where image_id=#{id}")
    int deleteImageUrl(Integer id);

    //删除商品并删除该商品的展示的图片
    @Delete("delete from product_showimage where product_id=#{id}")
    int deletePdImage(Integer id);
}
