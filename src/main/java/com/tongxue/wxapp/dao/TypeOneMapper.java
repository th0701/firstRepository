package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.TypeOne;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeOneMapper {
    @Select("select a.toid,a.toname,a.ptid,a.toimage,a.statu,a.toremark,b.pt_name from typeone a left join product_type b on a.ptid=b.pt_id where a.statu=0")
    List<TypeOne> selectList();

    @Insert("insert into typeone(toname,ptid,toimage,toremark) values(#{toName},#{ptId},#{toImage},#{toRemark})")
    int addType(TypeOne typeOne);

    @Update("update typeone set toname=#{toName},ptid=#{ptId},toimage=#{toImage},toremark=#{toRemark} where toid=#{toId}")
    int updateType(TypeOne typeOne);

    @Delete("delete from typeone where toid=#{id}")
    int deleteType(Integer id);

    @Select("select a.toid,a.toname,a.ptid,a.toimage,a.statu,a.toremark,b.pt_name from typeone a left join product_type b on a.ptid=b.pt_id where a.statu=1")
    List<TypeOne> selectList1();
}
