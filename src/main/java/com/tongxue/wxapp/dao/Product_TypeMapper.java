package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Product_Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Product_TypeMapper {

    @Select("select a.pt_id,a.pt_name,a.pt_parentId,b.pt_name paname ,a.pt_remark,a.statu from product_type a left join product_type b on a.pt_parentId=b.pt_id where a.statu=0")
    List<Product_Type> selectList();

    @Insert("insert into product_type(pt_name,pt_parentId,pt_remark) values(#{pt_Name},#{pt_ParentId},#{pt_Remark})")
    int addProduct_Type(Product_Type product_type);

    @Delete("delete from product_type where pt_id=#{pt_id}")
    int deleteProduct_Type(Integer pt_id);

    @Update("update product_type set pt_name=#{pt_name} ,pt_parentId=#{pt_parentId},pt_remark=#{pt_remarkl} where pt_id=#{pt_id}")
    int updeteProduct_Type(Integer pt_id);

    @Select("select pt_id,pt_name,pt_parentId,pt_remark,statu from product_type where pt_id=#{pt_id}")
    Product_Type selectOne(Integer pt_id);

    @Select("<script>"+
            "select pt_id,pt_name from product_type "+
            "<where>"+
            "<if test='pt_parentId==null'>"+
            "and pt_parentId is null"+
            "</if>"+
            "<if test='pt_parentId!=null'>"+
            "and pt_parentId  is not null"+
            "</if>"+
            "</where>"+
            "</script>"
    )
    List<Product_Type> selectidList(@Param("pt_parentId") Integer pt_parentId);

    @Select("select count(pt_id) from product_type where pt_parentId=#{id}")
    int selectcount(Integer id);

    @Select("select pt_id,pt_name,pt_parentId from product_type where statu=0")
    List<Product_Type> selectParent();

    @Select("select pt_id,pt_name,pt_parentId from product_type where statu=1")
    List<Product_Type> selectParent1();

    @Select("select pt_id,pt_name,pt_parentId from product_type where pt_parentId=#{id}")
    List<Product_Type> selectChildren(Integer id);

    @Select("select pt_parentId from product_type where pt_id=#{id}")
    Integer selectParentId(Integer id);



}
