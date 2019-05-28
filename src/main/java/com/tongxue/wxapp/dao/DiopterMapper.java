package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Diopter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiopterMapper {
    @Insert("insert into diopter(product_id,pd_colorId,product_no,diopterName,diopterStock) values(#{product_id},#{pd_colorId},#{diopterName},#{diopterStock})")
    int addDiopter(Diopter diopter);

    @Select("select a.diopterId,a.product_id,b.product_name,a.product_no,a.pd_colorId,c.pd_colorName,a.diopterName,a.diopterStock from diopter a left join product b on a.product_id=b.product_id left join product_color c on a.pd_colorId=c.pd_colorId")
    List<Diopter> selectList();

    @Delete("delete from diopter where diopterId=#{id}")
    int deleteDiopter(Integer id);

    @Select("select diopterId,diopterName,diopterStock,pd_colorId from diopter where product_id=#{id}")
    List<Diopter> selectAllDiopter(Integer id);

    @Select("select diopterStock from diopter where product_id=#{product_id} and pd_colorId=#{pd_colorId} and diopterName=#{diopterName}")
    Integer selectStock(@Param("product_id") Integer product_id, @Param("pd_colorId") Integer pd_colorId, @Param("diopterName") String diopterName);

    @Delete("delete from diopter where product_id=#{id}")
    int deletePdDiopter(Integer id);

    @Insert("<script>" +
            "insert into diopter(product_id,pd_colorId,product_no,diopterStock,diopterName) values"+
            "<foreach item='Diopter' collection='list' separator=',' index='index'> "+
            "(#{Diopter.product_id},#{Diopter.pd_colorId},#{Diopter.product_no},#{Diopter.diopterStock},#{Diopter.diopterName})"+
            "</foreach> "+
            "</script>")
    int addDiopterList(List<Diopter> list);


}
