package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Diopter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DiopterService {

    int addDiopter(Diopter diopter);

    List<Diopter> selectList();

    int deleteDiopter(Integer id);

    List<Diopter> selectAllDiopter(Integer id);

    int selectStock(Integer product_id, Integer pd_colorId, String diopterName);

    int deletePdDiopter(Integer id);

    //批量插入
    int addDiopterList(List<Diopter> list);

    //导入功能
    boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
