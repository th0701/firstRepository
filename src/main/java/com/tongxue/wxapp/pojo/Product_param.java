package com.tongxue.wxapp.pojo;

public class Product_param {
    private Integer param_id;
    private Integer product_id;
    private String product_brand;
    private String product_sinck;
    private String product_diameter;
    private String product_cycle;
    private String product_stand;
    private String product_water;
    private String product_area;
    private String product_colorType;
    private String product_documentNumber;
    private String product_company;

    @Override
    public String toString() {
        return "Product_param{" +
                "param_id=" + param_id +
                ", product_id=" + product_id +
                ", product_brand='" + product_brand + '\'' +
                ", product_sinck='" + product_sinck + '\'' +
                ", product_diameter='" + product_diameter + '\'' +
                ", product_cycle='" + product_cycle + '\'' +
                ", product_stand='" + product_stand + '\'' +
                ", product_water='" + product_water + '\'' +
                ", product_area='" + product_area + '\'' +
                ", product_colorType='" + product_colorType + '\'' +
                ", product_documentNumber='" + product_documentNumber + '\'' +
                ", product_company='" + product_company + '\'' +
                '}';
    }

    public Integer getParam_id() {
        return param_id;
    }

    public void setParam_id(Integer param_id) {
        this.param_id = param_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public String getProduct_sinck() {
        return product_sinck;
    }

    public void setProduct_sinck(String product_sinck) {
        this.product_sinck = product_sinck;
    }

    public String getProduct_diameter() {
        return product_diameter;
    }

    public void setProduct_diameter(String product_diameter) {
        this.product_diameter = product_diameter;
    }

    public String getProduct_cycle() {
        return product_cycle;
    }

    public void setProduct_cycle(String product_cycle) {
        this.product_cycle = product_cycle;
    }

    public String getProduct_stand() {
        return product_stand;
    }

    public void setProduct_stand(String product_stand) {
        this.product_stand = product_stand;
    }

    public String getProduct_water() {
        return product_water;
    }

    public void setProduct_water(String product_water) {
        this.product_water = product_water;
    }

    public String getProduct_area() {
        return product_area;
    }

    public void setProduct_area(String product_area) {
        this.product_area = product_area;
    }

    public String getProduct_colorType() {
        return product_colorType;
    }

    public void setProduct_colorType(String product_colorType) {
        this.product_colorType = product_colorType;
    }

    public String getProduct_documentNumber() {
        return product_documentNumber;
    }

    public void setProduct_documentNumber(String product_documentNumber) {
        this.product_documentNumber = product_documentNumber;
    }

    public String getProduct_company() {
        return product_company;
    }

    public void setProduct_company(String product_company) {
        this.product_company = product_company;
    }

    public Product_param(Integer param_id, Integer product_id, String product_brand, String product_sinck, String product_diameter, String product_cycle, String product_stand, String product_water, String product_area, String product_colorType, String product_documentNumber, String product_company) {
        this.param_id = param_id;
        this.product_id = product_id;
        this.product_brand = product_brand;
        this.product_sinck = product_sinck;
        this.product_diameter = product_diameter;
        this.product_cycle = product_cycle;
        this.product_stand = product_stand;
        this.product_water = product_water;
        this.product_area = product_area;
        this.product_colorType = product_colorType;
        this.product_documentNumber = product_documentNumber;
        this.product_company = product_company;
    }

    public Product_param() {
    }
}
