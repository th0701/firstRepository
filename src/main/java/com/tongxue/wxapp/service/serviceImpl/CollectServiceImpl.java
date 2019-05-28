package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.CollectMapper;
import com.tongxue.wxapp.pojo.Collect;
import com.tongxue.wxapp.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;

    @Override
    public int deleteCollect(Integer id) {
        return collectMapper.deleteCollect(id);
    }

    @Override
    public List<Collect> selectWxList(String openId) {
        return collectMapper.selectWxList(openId);
    }

    @Override
    public int addCollect(Collect collect) {
        collect.setCollect_time(new Date());
        return collectMapper.addCollect(collect);
    }

    @Override
    public int selectIsCollection(Integer id ,String openId) {
        return collectMapper.selectIsCollection(id,openId);
    }

    @Override
    public int removeCollect(Integer id,String openId) {
        return collectMapper.removeCollect(id,openId);
    }

    @Override
    public List<Collect> selectList() {
        return collectMapper.selectList();
    }
}
