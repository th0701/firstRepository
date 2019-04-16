package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Diopter;

import java.util.List;

public interface DiopterService {

    int addDiopter(Diopter diopter);

    List<Diopter> selectList();

    int deleteDiopter(Integer id);

    List<Diopter> selectAllDiopter(Integer id);

    int selectStock(Integer product_id, Integer pd_colorId, String diopterName);
}
