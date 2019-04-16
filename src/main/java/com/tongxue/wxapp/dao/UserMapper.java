package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select userId,userName,password,roleId from user where userName=#{userName} and passWord=#{passWord}")
    User login(@Param("userName") String userName, @Param("passWord") String passWord);
}
