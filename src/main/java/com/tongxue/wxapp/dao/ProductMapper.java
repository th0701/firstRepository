package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    //查询符合条件的对象
    @Select("<script>" +
            "select a.product_id, a.product_name, a.product_type,b.pt_name,a.product_stock,a.product_addr,a.product_image,a.product_remark,a.product_uptime,a.product_price from product a " +
            "left join product_type b on a.product_type=b.pt_id"+
            "<where>" +
            "<if test='product_name !=null ' >" +
            "and a.product_name like concat('%', #{product_name}, '%')"+
            "</if>"+
            "</where>" +
            "</script>")
    List<Product> selectList(@Param("product_name") String product_name);

    @Insert("insert into product(product_name,product_type,product_addr,product_image,product_remark,product_uptime,product_price) values(#{product_name},#{product_type},#{product_stock},#{product_addr},#{product_image},#{product_remark},#{product_uptime},#{product_price})")
    int addProduct(Product product);

    @Delete("delete from product where product_id=#{id}")
    int deleteProduct(Integer id);

    @Update("update product set product_name=#{product_name},product_type=#{product_type},product_addr=#{product_addr},product_image=#{product_image},product_remark=#{product_remark},product_uptime=#{product_uptime},product_price=#{product_price} where product_id=#{product_id}")
    int updateProduct(Product product);

    @Select("select product_id,product_name,product_image,product_price from product where product_type=#{ptId}")
    List<Product> selectType(Integer ptId);

    @Select("select product_id,product_name from product")
    List<Product> select();

    @Select("select product_id,product_name,product_addr,product_price from product where product_id=#{id}")
    Product selectProduct(Integer id);



}
