package com.tongxue.wxapp.service;


import com.tongxue.wxapp.pojo.OpenType;

import java.util.List;
import java.util.Map;

public interface OpenTypeService {

    List<OpenType> selectList();

    int addopen(OpenType openType);

    Map selectPageList(Integer page,Integer limit);

    int deleteOpenType(Integer id);

    int updateOpenType(OpenType openType);

    List<OpenType> selectList1();
}
