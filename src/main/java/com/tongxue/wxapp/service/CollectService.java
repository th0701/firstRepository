package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Collect;

import java.util.List;

public interface CollectService {
    //添加收藏
    int addCollect(Collect collect);

    //查看收藏列表
    List<Collect> selectWxList(String openId);

    //删除
    int deleteCollect(Integer id);

    //判断是否已收藏
    int selectIsCollection(Integer id,String openId);

    //取消收藏
    int removeCollect(Integer id ,String openId);

    //后台展示
    List<Collect> selectList();
}
