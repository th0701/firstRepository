package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select a.bannerId,a.bannerName,a.ptid,b.pt_name,a.pdid,c.product_name,a.image from banner a " +
            "left join product_type b on a.ptid=b.pt_id left join product c on a.pdid=c.product_id")
    List<Banner> selectList ();

    @Insert("insert into banner(bannerName,image,ptid,pdid) values(#{bannerName},#{image},#{ptId},#{pdId})")
    int addBanner(Banner banner);

    @Delete("delete from banner where bannerId=#{bannerId}")
    int deleteBanner(Integer bannerId);

    @Update("update banner set bannerName=#{bannerName},image=#{image},ptid=#{ptId},pdid=#{pdId} where bannerId=#{bannerId}")
    int updeteBanner(Banner banner);

    @Select("select pdId from banner where bannerId=#{id}")
    Integer selectProductId(Integer id);

    @Select("select ptId from banner where bannerId=#{id}")
    Integer selectTypeId(Integer id);


}
