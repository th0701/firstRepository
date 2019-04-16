package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Ot_product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Ot_productMapper {
    @Insert("insert into ot_product(product_id,parent_id) values(#{product_id},#{parent_id})")
    int addot_product(Ot_product ot_product);

    @Select("select a.ot_productId, b.product_id, b.product_name, b.product_image, b.product_price, c.otName from ot_product a left join product b on a.product_id=b.product_id left join opentype c on a.parent_id=c.otid where parent_id=#{id}")
    List<Ot_product> selectList(Integer id);

    @Delete("delete from ot_product where ot_productId=#{id}")
    int deleteOt_product(Integer id);
}
