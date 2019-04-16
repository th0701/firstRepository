package com.tongxue.wxapp.pojo;

import com.tongxue.wxapp.service.Ot_productService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class OpenType {
    private Integer otId;
    private String text;
    private Integer otType;
    private String otImage;
    private String otRemark;
    private Integer statu;
    private List<Ot_product> data;
    private static OpenType didi;
    @Resource
    protected Ot_productService ot_productService;

    @PostConstruct
    public void init(){
        //声明的静态类=this
        didi=this;
        didi.ot_productService=this.ot_productService;
    }


    public List<Ot_product> getData() {
        return data;
    }

    public void setData(List<Ot_product> data) {
        this.data = data;
    }

    public Integer getOtId() {
        return otId;
    }

    public void setOtId(Integer otId) {
        this.otId = otId;
    }

    public String getText() {
        return text;
    }

    public void setText(String otName) {
        this.text = otName;
    }

    public Integer getOtType() {
        return otType;
    }

    public void setOtType(Integer otType) {
        this.otType = otType;
    }

    public String getOtImage() {
        return otImage;
    }

    public void setOtImage(String otImage) {
        this.otImage = otImage;
    }

    public String getOtRemark() {
        return otRemark;
    }

    public void setOtRemark(String otRemark) {
        this.otRemark = otRemark;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public OpenType(Integer otId, String otName, Integer otType, String otImage, String otRemark, Integer statu) {
        this.otId = otId;
        this.text = otName;
        this.otType = otType;
        this.otImage = otImage;
        this.otRemark = otRemark;
        this.statu = statu;
    }

    public OpenType() {
    }

    public static List<OpenType> selectTree(List<OpenType> list){
        for(OpenType openType : list){
            openType.setData(didi.ot_productService.selectList(openType.getOtId()));
        }
        return list;
    }

}
