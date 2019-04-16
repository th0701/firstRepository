package com.tongxue.wxapp.pojo;

public class User {
    //用户id
    private Integer userId;
    //账号
    private String userName;
    //密码
    private String passWord;
    //角色id
    private int roleID;

    public User(Integer userId, String userName, String passWord, int roleID) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.roleID = roleID;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
