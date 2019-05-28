package com.tongxue.wxapp.service;

import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.TypeOne;

public interface TypeOneService {
    PageInfo<TypeOne> selectList(Integer pageNum,Integer pageSize);

    int addType(TypeOne typeOne);

    int updateType(TypeOne typeOne);

    int deleteType(Integer id);

    //假
    PageInfo<TypeOne> selectList1(Integer pageNum,Integer pageSize);


}
