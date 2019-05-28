package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.TypeTwo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeTwoMapper {
    @Select("select ttid, ttname, ptid, ttimage, a.statu, ttremark, b.pt_name from typetwo a left join product_type b on a.ptid=b.pt_id where a.statu=0")
    List<TypeTwo> selectList();

    @Insert("insert into typetwo(ttname,ptid,ttimage,ttremark) values(#{ttName},#{ptId},#{ttImage},#{ttRemark})")
    int addType(TypeTwo typeOne);

    @Update("update typetwo set ttname=#{ttName},ptid=#{ptId},ttimage=#{ttImage},ttremark=#{ttRemark} where ttid=#{ttId}")
    int updateType(TypeTwo typeOne);

    @Delete("delete from typetwo where ttid=#{id}")
    int deleteType(Integer id);

    //假
    @Select("select ttid, ttname, ptid, ttimage, a.statu, ttremark, b.pt_name from typetwo a left join product_type b on a.ptid=b.pt_id where a.statu=1")
    List<TypeTwo> selectList1();
}
