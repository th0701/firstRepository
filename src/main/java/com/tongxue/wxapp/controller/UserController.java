package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.User;
import com.tongxue.wxapp.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(String userName,String passWord){
        return "login";
    }

    @RequestMapping("/index")
    public String index(String userName, String passWord, HttpSession session){
        User user = userService.login(userName, passWord);
            if(null!=user){
                session.setAttribute("user",user);
                return "product/productList";
            }else{
                user=(User) session.getAttribute("user");
                if(user!=null){
                    return "product/productList";
                }else{
                    return "user/login";
                }
            }

    }
}
