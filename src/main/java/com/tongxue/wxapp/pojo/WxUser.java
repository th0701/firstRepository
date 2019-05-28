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
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "wxUserId=" + wxUserId +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public WxUser(Integer wxUserId, String openid, String nickname, Integer gender, String city, String province, String country, String avatarurl, String unionid) {
        this.wxUserId = wxUserId;
        this.openid = openid;
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
