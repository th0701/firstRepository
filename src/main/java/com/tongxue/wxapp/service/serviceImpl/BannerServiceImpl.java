package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.BannerMapper;
import com.tongxue.wxapp.pojo.Banner;
import com.tongxue.wxapp.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    @Transactional
    public PageInfo<Banner> selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<Banner>(bannerMapper.selectList());
    }

    @Override
    @Transactional
    public int addBanner(Banner banner) {
        return bannerMapper.addBanner(banner);
    }

    @Override
    @Transactional
    public int deleteBanner(Integer bannerId) {
        return bannerMapper.deleteBanner(bannerId);
    }

    @Override
    @Transactional
    public int updeteBanner(Banner banner) {
        return bannerMapper.updeteBanner(banner);
    }

    @Override
    public Integer selectProductId(Integer id) {
        Integer i = bannerMapper.selectProductId(id);
        if(i==null){
            i=0
;        }
        return i;
    }

    @Override
    public Integer selectTypeId(Integer id) {
        return bannerMapper.selectTypeId(id);
    }


}
