package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Banner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BannerService {

    PageInfo<Banner> selectList (Integer pageNum, Integer pageSize);

    int addBanner(Banner banner);

    int deleteBanner(Integer bannerId);

    int updeteBanner(Banner banner);

    Integer selectProductId(Integer id);

    Integer selectTypeId(Integer id);

}
