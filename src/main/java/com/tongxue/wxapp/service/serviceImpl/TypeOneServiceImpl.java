package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.TypeOneMapper;
import com.tongxue.wxapp.pojo.TypeOne;
import com.tongxue.wxapp.service.TypeOneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TypeOneServiceImpl implements TypeOneService {
    @Resource
    private TypeOneMapper typeOneMapper;
    @Override
    @Transactional
    public PageInfo<TypeOne> selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(typeOneMapper.selectList());
    }

    @Override
    @Transactional
    public int addType(TypeOne typeOne) {
        return typeOneMapper.addType(typeOne);
    }

    @Override
    @Transactional
    public int updateType(TypeOne typeOne) {
        return typeOneMapper.updateType(typeOne);
    }

    @Override
    @Transactional
    public int deleteType(Integer id) {
        return typeOneMapper.deleteType(id);
    }
}
