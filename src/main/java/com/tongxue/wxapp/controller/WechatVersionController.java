package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.service.WechatVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/wechatVersion")
public class WechatVersionController {
    @Resource
    private WechatVersionService wechatVersionService;

    @RequestMapping("/getVersion")
    @ResponseBody
    public Map getVersion() {
        Map map = new HashMap();
        int version = wechatVersionService.version();
        map.put("version", version);
        return map;
    }

    @RequestMapping("/updateOne")
    @ResponseBody
    public String updateOne() {
        int i = wechatVersionService.updateIsOne();
        String st="";
        if (i>0) {
           st="成功修改版本为1";
        }else{
            st="修改失败";
        }
        return st;
    }
    @RequestMapping("/updateZero")
    @ResponseBody
    public String updateZero() {
        int i = wechatVersionService.updateIs0();
        String st="";
        if (i>0) {
            st="成功修改版本为0";
        }else{
            st="修改失败";
        }
        return st;
    }

}
