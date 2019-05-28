package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Select("select addr_id,tackName,tackNumber,tackCity,tackProvince from address where openId=#{id}")
    List<Address> selectList(String id);

    @Insert("insert into address(openId,tackName,tackNumber,tackCity,tackProvince,statu) values(#{openId},#{tackName},#{tackNumber},#{tackCity},#{tackProvince},#{statu})")
    int addAddress(Address address);

    @Update("update address set tackName=#{tackName},tackNumber=#{tackNumber},tackCity=#{tackCity},tackProvince=#{tackProvince} where addr_id=#{addr_id}")
    int updateAddress(Address address);

    @Delete("delete from address where addr_id=#{id}")
    int deleteAddress(Integer id);

    @Select("<script>"+
            "select addr_id,tackName,tackNumber,tackCity,tackProvince from address "+
            "<where>"+
            "<if test='openId !=null'>"+
            "and openId=#{openId}"+
            "</if>"+
            "<if test='addr_id !=null'>"+
            "and addr_id=#{addr_id}"+
            "</if>"+
            "<if test='addr_id ==null'>"+
            "limit 0,1"+
            "</if>"+
            "</where>"+
            "</script>")
    Address selectWxAddr(@Param("openId") String openId,@Param("addr_id") Integer addr_id);

    @Select("select addr_id,tackName,tackNumber,tackCity,tackProvince from address where addr_id=#{id}")
    Address selectOrderAddr(Integer id);
}
