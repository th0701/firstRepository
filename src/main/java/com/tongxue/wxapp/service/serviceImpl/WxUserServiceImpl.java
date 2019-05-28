package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.WxUserMapper;
import com.tongxue.wxapp.pojo.WxUser;
import com.tongxue.wxapp.service.WxUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WxUserServiceImpl implements WxUserService {
    @Resource
    private WxUserMapper wxUserMapper;

    @Override
    public List<WxUser> selectList() {
        return wxUserMapper.selectList();
    }

    @Override
    public int updateImageName(WxUser wxUser) {
        return wxUserMapper.updateImageName(wxUser);
    }

    @Override
    public int selectCount(String openid) {
        return wxUserMapper.selectCount(openid);
    }

    @Override
    public int addWxUser(WxUser wxUser) {
        return wxUserMapper.addWxUser(wxUser);
    }

    @Override
    public WxUser selectWxUser(String openId) {
        return wxUserMapper.selectWxUser(openId);
    }

    @Override
    public int updateVersion(String openId) {
        return wxUserMapper.updateVersion(openId);
    }
}
