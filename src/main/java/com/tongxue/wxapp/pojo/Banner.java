package com.tongxue.wxapp.pojo;

public class Banner {
    private Integer bannerId;
    private String bannerName;
    private String image;
    private Integer ptId;
    private Integer pdId;
    private String pt_name;
    private String product_name;

    public String getPt_name() {
        return pt_name;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Banner() {
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public Integer getPdId() {
        return pdId;
    }

    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    public Banner(Integer bannerId, String bannerName, String image, Integer ptId, Integer pdId) {
        this.bannerId = bannerId;
        this.bannerName = bannerName;
        this.image = image;
        this.ptId = ptId;
        this.pdId = pdId;
    }
}
