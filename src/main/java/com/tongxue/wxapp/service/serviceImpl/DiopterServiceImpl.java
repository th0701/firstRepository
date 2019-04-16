package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.DiopterMapper;
import com.tongxue.wxapp.pojo.Diopter;
import com.tongxue.wxapp.service.DiopterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiopterServiceImpl implements DiopterService {
    @Resource
    private DiopterMapper diopterMapper;

    @Override
    public int addDiopter(Diopter diopter) {
        return diopterMapper.addDiopter(diopter);
    }

    @Override
    public List<Diopter> selectList() {
        return diopterMapper.selectList();
    }

    @Override
    public int selectStock(Integer product_id, Integer pd_colorId, String diopterName) {
        Integer i = diopterMapper.selectStock(product_id, pd_colorId, diopterName);
        if(i==null){
            i=0;
        }
        return i;
    }

    @Override
    public List<Diopter> selectAllDiopter(Integer id) {
        return diopterMapper.selectAllDiopter(id);
    }

    @Override
    public int deleteDiopter(Integer id) {
        return diopterMapper.deleteDiopter(id);
    }
}
