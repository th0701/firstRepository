package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.OpenType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OpenTypeMapper {

    @Select("select otid,otname text,otimage ,otremark,otType from opentype where statu=0")
    List<OpenType> selectList();

    @Insert("insert into opentype(otName, otType, otImage, otRemark) values(#{text}, #{otType}, #{otImage}, #{otRemark})")
    int addopen(OpenType openType);

    @Delete("delete from opentype where otid=#{id}")
    int deleteOpenType(Integer id);

    @Update("update opentype set otname=#{text}, otType=#{otType},otimage=#{otImage},otremark=#{otRemark} where otid=#{otId}")
    int updateOpenType(OpenType openType);

    //假
    @Select("select otid,otname text,otimage ,otremark,otType from opentype where statu=1")
    List<OpenType> selectList1();
}
