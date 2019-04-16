package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.TypeTwo;

public interface TypeTowService {
    PageInfo<TypeTwo> selectList(Integer pageNum, Integer pageSize);

    int addType(TypeTwo typeOne);

    int updateType(TypeTwo typeOne);

    int deleteType(Integer id);
}
