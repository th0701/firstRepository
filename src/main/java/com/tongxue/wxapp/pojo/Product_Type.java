package com.tongxue.wxapp.pojo;

import com.tongxue.wxapp.service.Product_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Component
public class Product_Type {
    private Integer pt_Id;
    private String pt_Name;
    private Integer pt_ParentId;
    private String pt_Remark;
    private Integer statu;
    private String paName;
    private List<Product_Type> children;
    @Autowired
    private Product_TypeService product_typeService;

    private static Product_Type dataUpload;

    //在方法上加上注解@PostConstruct,这样方法就会在bean初始化之后被spring容器执行
    @PostConstruct
    public void init(){
        //声明的静态类=this
        dataUpload=this;
        dataUpload.product_typeService=this.product_typeService;
    }


    public List<Product_Type> getChildren() {
        return children;
    }

    public void setChildren(List<Product_Type> children) {
        this.children = children;
    }

    public Product_Type(Integer pt_Id, String pt_Name, Integer pt_ParentId, String pt_Remark, Integer statu, String paName, List<Product_Type> children) {
        this.pt_Id = pt_Id;
        this.pt_Name = pt_Name;
        this.pt_ParentId = pt_ParentId;
        this.pt_Remark = pt_Remark;
        this.statu = statu;
        this.paName = paName;
        this.children = children;
    }

    public String getPaName() {
        return paName;
    }

    public void setPaName(String paName) {
        this.paName = paName;
    }

    public Integer getPt_Id() {
        return pt_Id;
    }

    public void setPt_Id(Integer pt_Id) {
        this.pt_Id = pt_Id;
    }

    public String getPt_Name() {
        return pt_Name;
    }

    public void setPt_Name(String pt_Name) {
        this.pt_Name = pt_Name;
    }

    public Integer getPt_ParentId() {
        return pt_ParentId;
    }

    public void setPt_ParentId(Integer pt_ParentId) {
        this.pt_ParentId = pt_ParentId;
    }

    public String getPt_Remark() {
        return pt_Remark;
    }

    public void setPt_Remark(String pt_Remark) {
        this.pt_Remark = pt_Remark;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Product_Type(Integer pt_Id, String pt_Name, Integer pt_ParentId, String pt_Remark, Integer statu) {
        this.pt_Id = pt_Id;
        this.pt_Name = pt_Name;
        this.pt_ParentId = pt_ParentId;
        this.pt_Remark = pt_Remark;
        this.statu = statu;
    }

    public Product_Type() {
    }

    public static List<Product_Type> getList(List<Product_Type> list){
        List<Product_Type> listTree=new ArrayList<>();
        for(Product_Type product_type : list){
            if(product_type.getPt_ParentId()==null || product_type.getPt_ParentId().equals("")){
                listTree.add(product_type);
            }

        }
        for(Product_Type pro : listTree){
            pro.setChildren(dataUpload.product_typeService.selectChildren(pro.getPt_Id()));
        }
        return listTree;
    }
}
