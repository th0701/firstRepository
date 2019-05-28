package com.tongxue.wxapp.config;
/*
微信支付工具类
 */
public class WechatConfig {

    //小程序appid
    public static final String appid = "wx4cb5ceab602401a5";
    //微信支付的商户id
    public static final String mch_id = "1534105021";
    //微信支付的商户密钥
    public static final String key = "tongxue91440300MA5F0YGJX79144030";
    //支付成功后的服务器回调url，这里填PayController里的回调函数地址
    public static final String notify_url = "https://kilala.co/wechat/wxNotify";
    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //退款调用
    public static final String REFUND_PATH = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    //本机存放商户证书路径
    public static final String CERT_PATH = "C:/cert/apiclient_cert.p12";
}
