package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.WxUser;

import java.util.List;

public interface WxUserService {
    int addWxUser(WxUser wxUser);

    int selectCount(String openid);

    int updateImageName(WxUser wxUser);

    List<WxUser> selectList();
}
