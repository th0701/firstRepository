package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.User;

public interface UserService {
    User login(String userName, String passWord);
}
