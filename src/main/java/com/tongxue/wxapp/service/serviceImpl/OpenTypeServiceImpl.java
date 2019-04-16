package com.tongxue.wxapp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.dao.OpenTypeMapper;
import com.tongxue.wxapp.pojo.OpenType;
import com.tongxue.wxapp.service.OpenTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenTypeServiceImpl implements OpenTypeService {
    @Resource
    private OpenTypeMapper openTypeMapper;

    @Override
    @Transactional
    public int updateOpenType(OpenType openType) {
        return openTypeMapper.updateOpenType(openType);
    }

    @Override
    @Transactional
    public int deleteOpenType(Integer id) {
        return openTypeMapper.deleteOpenType(id);
    }

    @Override
    @Transactional
    public Map selectPageList(Integer page, Integer limit) {
        Map map=new HashMap();
        PageHelper.startPage(page,limit);
        PageInfo<OpenType> pageInfo=new PageInfo<>(openTypeMapper.selectList());
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @Override
    @Transactional
    public int addopen(OpenType openType) {
        return openTypeMapper.addopen(openType);
    }

    @Override
    @Transactional
    public List<OpenType> selectList() {
        return openTypeMapper.selectList();
    }
}
