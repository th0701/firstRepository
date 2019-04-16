package com.tongxue.wxapp.pojo;

public class WxUser {
    private Integer wxUserId;
    private String openid;
    private String nickname;
    private Integer gender;
    private String city;
    private String province;
    private String country;
    private String avatarurl;
    private String unionid;

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }

    public String getOpeniId() {
        return openid;
    }

    public void setOpeniId(String openiId) {
        this.openid = openiId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public WxUser(Integer wxUserId, String openiId, String nickname, Integer gender, String city, String province, String country, String avatarurl, String unionid) {
        this.wxUserId = wxUserId;
        this.openid = openiId;
        this.nickname = nickname;
        this.gender = gender;
        this.city = city;
        this.province = province;
        this.country = country;
        this.avatarurl = avatarurl;
        this.unionid = unionid;
    }

    public WxUser() {
    }
}
