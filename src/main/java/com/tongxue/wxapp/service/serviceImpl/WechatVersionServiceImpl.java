package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.WechatVersionMapper;
import com.tongxue.wxapp.service.WechatVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WechatVersionServiceImpl implements WechatVersionService {
    @Resource
    private WechatVersionMapper wechatVersionMapper;

    @Override
    public int updateIsOne() {
        return wechatVersionMapper.updateIsOne();
    }

    @Override
    public int updateIs0() {
        return wechatVersionMapper.updateIs0();
    }

    @Override
    public Integer version() {
        return wechatVersionMapper.version();
    }
}
