package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.TypeTwoMapper;
import com.tongxue.wxapp.pojo.TypeTwo;
import com.tongxue.wxapp.service.TypeTowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TypeTwoServiceImpl implements TypeTowService {
    @Resource
    private TypeTwoMapper typeTwoMapper;

    @Override
    @Transactional
    public PageInfo<TypeTwo> selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(typeTwoMapper.selectList());
    }

    //假
    @Override
    @Transactional
    public PageInfo<TypeTwo> selectList1(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(typeTwoMapper.selectList1());
    }

    @Override
    @Transactional
    public int addType(TypeTwo typeOne) {
        return typeTwoMapper.addType(typeOne);
    }

    @Override
    @Transactional
    public int updateType(TypeTwo typeOne) {
        return typeTwoMapper.updateType(typeOne);
    }

    @Override
    @Transactional
    public int deleteType(Integer id) {
        return typeTwoMapper.deleteType(id);
    }
}
