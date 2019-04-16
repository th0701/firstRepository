package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.config.AesUtil;
import com.tongxue.wxapp.config.HttpClientUtil;
import com.tongxue.wxapp.pojo.WxUser;
import com.tongxue.wxapp.service.WxUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/wechat")
public class WeChatController {
    @Resource
    private WxUserService wxUserService;

    @PostMapping("/login")
    @ResponseBody
    public Map login(String encryptedData, String iv, String code) {
        //登录凭证不能为空
        Map map=new HashMap();
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        String appid = "wxd591c985daf4fc39";
        //小程序的 app secret (在微信小程序管理后台获取)
        String appSecret = "6420895e2d511cff6a8ee57cae432427";
        //授权（必填）
        String apiUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println(apiUrl);
        String responseBody = HttpClientUtil.doGet(apiUrl);
        System.out.println(responseBody);
        JSONObject json = JSON.parseObject(responseBody);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        try {
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                WxUser wxUser=new WxUser();
                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = JSONObject.parseObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                wxUser.setOpeniId((String)userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                wxUser.setNickname((String)userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                wxUser.setGender((Integer)userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                wxUser.setCity((String)userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                wxUser.setProvince((String)userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                wxUser.setCountry((String)userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                wxUser.setAvatarurl((String)userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                wxUser.setUnionid((String)userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                int i=wxUserService.selectCount((String)userInfoJSON.get("openid"));
                if(i==0){
                    int j=wxUserService.addWxUser(wxUser);
                    System.out.println(j);
                }else{
                    int j=wxUserService.updateImageName(wxUser);
                }
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectList(String page,String limit){
        Map map=new HashMap();
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        PageInfo<WxUser> pageInfo=new PageInfo<>(wxUserService.selectList());
        map.put("code",0);
        map.put("msg","");
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/index")
    public String index(){
        return "wxuser/wxUserList";
    }
}