package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.UserMapper;
import com.tongxue.wxapp.pojo.User;
import com.tongxue.wxapp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }
}
