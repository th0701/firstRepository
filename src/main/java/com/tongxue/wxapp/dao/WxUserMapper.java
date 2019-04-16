package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.WxUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WxUserMapper {
    @Insert("insert into wxUser(openid, nickname, gender ,city, province, country, avatarUrl, unionId) values(#{openid},#{nickname},#{gender},#{city},#{province},#{country},#{avatarurl},#{unionid})")
    int addWxUser(WxUser wxUser);

    @Select("select count(wxuserId) from wxuser where openid=#{openid}")
    int selectCount(String openid);

    @Update("update wxuser set nickname=#{nickname}, avatarurl=#{avatarurl} where openid=#{openid}")
    int updateImageName(WxUser wxUser);

    @Select("select wxuserId,nickname,gender,city,province,avatarurl from wxuser")
    List<WxUser> selectList();
}
