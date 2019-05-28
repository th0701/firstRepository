package com.tongxue.wxapp.pojo;

public class Diopter {
    private Integer diopterId;
    private Integer diopterStock;
    private Integer product_id;
    private Integer pd_colorId;
    private String diopterName;
    private String product_name;
    private String pd_colorName;
    private String product_no;

    @Override
    public String toString() {
        return "Diopter{" +
                "diopterId=" + diopterId +
                ", diopterStock=" + diopterStock +
                ", product_id=" + product_id +
                ", pd_colorId=" + pd_colorId +
                ", diopterName='" + diopterName + '\'' +
                ", product_name='" + product_name + '\'' +
                ", pd_colorName='" + pd_colorName + '\'' +
                '}';
    }

    public Integer getDiopterStock() {
        return diopterStock;
    }

    public void setDiopterStock(Integer diopterStock) {
        this.diopterStock = diopterStock;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public Diopter(Integer diopterId, Integer diopterStock, Integer product_id, Integer pd_colorId, String diopterName, String product_name, String pd_colorName, String product_no) {
        this.diopterId = diopterId;
        this.diopterStock = diopterStock;
        this.product_id = product_id;
        this.pd_colorId = pd_colorId;
        this.diopterName = diopterName;
        this.product_name = product_name;
        this.pd_colorName = pd_colorName;
        this.product_no = product_no;
    }

    public Integer getDiopterId() {
        return diopterId;
    }

    public void setDiopterId(Integer diopterId) {
        this.diopterId = diopterId;
    }



    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getPd_colorName() {
        return pd_colorName;
    }
    public void setPd_colorName(String pd_colorName) {
        this.pd_colorName = pd_colorName;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getPd_colorId() {
        return pd_colorId;
    }

    public void setPd_colorId(Integer pd_colorId) {
        this.pd_colorId = pd_colorId;
    }

    public String getDiopterName() {
        return diopterName;
    }

    public void setDiopterName(String diopterName) {
        this.diopterName = diopterName;
    }


    public Diopter() {
    }
}
