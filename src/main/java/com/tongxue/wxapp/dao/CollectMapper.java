package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Collect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollectMapper {
    //添加收藏
    @Insert("insert into collect(openId,product_id,collect_time) values(#{openId},#{product_id},#{collect_time})")
    int addCollect(Collect collect);

    //查看收藏列表
    @Select("select a.collect_id,a.product_id,b.product_name,b.product_price,b.product_image from collect a left join product b on a.product_id=b.product_id where a.openId=#{openId}")
    List<Collect> selectWxList(String openId);

    //删除收藏的商品
    @Delete("delete from collect where collect_id=#{id}")
    int deleteCollect(Integer id);

    //判断是否已收藏
    @Select("select count(collect_id) from collect where product_id=#{id} and openid=#{openId}")
    int selectIsCollection(@Param("id") Integer id, @Param("openId") String openId);

    //取消收藏
    @Delete("delete from collect where product_id=#{id} and openid=#{openId}")
    int removeCollect(@Param("id") Integer id, @Param("openId") String openId);

    //后台展示收藏
    @Select("select a.collect_id,a.openId,b.nickName,a.product_id,c.product_name from collect a left join wxuser b on a.openId=b.openId left join product c on a.product_id=c.product_id")
    List<Collect> selectList();

}
