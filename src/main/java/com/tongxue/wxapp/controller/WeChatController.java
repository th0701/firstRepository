package com.tongxue.wxapp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.config.AesUtil;
import com.tongxue.wxapp.config.HttpClientUtil;
import com.tongxue.wxapp.config.PayUtil;
import com.tongxue.wxapp.config.WechatConfig;
import com.tongxue.wxapp.pojo.Order;
import com.tongxue.wxapp.pojo.Order_item;
import com.tongxue.wxapp.pojo.ShoppingCar;
import com.tongxue.wxapp.pojo.WxUser;
import com.tongxue.wxapp.service.OrderService;
import com.tongxue.wxapp.service.Order_itemService;
import com.tongxue.wxapp.service.ShoppingCarService;
import com.tongxue.wxapp.service.WxUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.KeyStore;
import java.util.*;

@Controller
@RequestMapping("/wechat")
public class WeChatController {
    @Resource
    private WxUserService wxUserService;
    @Resource
    private OrderService orderService;
    @Resource
    private Order_itemService orderItemService;
    @Resource
    private ShoppingCarService shoppingCarService;

    @RequestMapping("/login")
    @ResponseBody
    public Map login(String encryptedData, String iv, String code) {
        //登录凭证不能为空
        Map map = new HashMap();
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        String appid = "wx4cb5ceab602401a5";
        //小程序的 app secret (在微信小程序管理后台获取)
        String appSecret = "77b0494161ce67d7a0bc70069ac2aee8";
        //        //授权（必填）
        String apiUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        String responseBody = HttpClientUtil.doGet(apiUrl);
        JSONObject json = JSON.parseObject(responseBody);
        //获取会话密钥（session_key）
        String session_key = null;
        if (json != null) {
            Object session_key1 = json.get("session_key");
            if (session_key1 != null) {
                session_key = session_key1.toString();
            }
            //用户的唯一标识（openid）
            String openid = (String) json.get("openid");
        }
        try {
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                WxUser wxUser = new WxUser();
                map.put("status", 1);
                map.put("msg", "解密成功");
                JSONObject userInfoJSON = JSONObject.parseObject(result);
                wxUser.setOpenid((String) userInfoJSON.get("openId"));
                wxUser.setNickname((String) userInfoJSON.get("nickName"));
                wxUser.setGender((Integer) userInfoJSON.get("gender"));
                wxUser.setCity((String) userInfoJSON.get("city"));
                wxUser.setProvince((String) userInfoJSON.get("province"));
                wxUser.setCountry((String) userInfoJSON.get("country"));
                wxUser.setAvatarurl((String) userInfoJSON.get("avatarUrl"));
                wxUser.setUnionid((String) userInfoJSON.get("unionId"));
                wxUser.setVersion(0);
                int i = wxUserService.selectCount(wxUser.getOpenid());
                if (i == 0) {
                    int j = wxUserService.addWxUser(wxUser);
                    WxUser userInfo = wxUserService.selectWxUser(wxUser.getOpenid());
                    map.put("userInfo", userInfo);
                } else if (i > 0) {
                    int j = wxUserService.updateImageName(wxUser);
                    WxUser userInfo = wxUserService.selectWxUser(wxUser.getOpenid());
                    map.put("userInfo", userInfo);
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
    public Map selectList(String page, String limit) {
        Map map = new HashMap();
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        PageInfo<WxUser> pageInfo = new PageInfo<>(wxUserService.selectList());
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", pageInfo.getList());
        map.put("count", pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/index")
    public String index() {
        return "wxuser/wxUserList";
    }

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String, Object> wxPay(HttpServletRequest request) {
        try {
            //生成的随机字符串
            String nonce_str = getRandomStringByLength(32);
            //商品名称
            String body = "test";
            //获取客户端的ip地址
            String spbill_create_ip = getIpAddr(request);
            Integer addr_id = Integer.parseInt(request.getParameter("addr_id"));
            String order_remark = request.getParameter("order_remark");
            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<>();
            packageParams.put("appid", WechatConfig.appid);
            packageParams.put("mch_id", WechatConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            String payOrderId = "" + request.getParameter("order_no");
            packageParams.put("out_trade_no", payOrderId);//商户订单号,自己的订单ID
            packageParams.put("total_fee", 1 + "");//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", WechatConfig.notify_url);//支付成功后的回调地址
            packageParams.put("trade_type", WechatConfig.TRADETYPE);//支付方式
            String openid = request.getParameter("openId");
            packageParams.put("openid", openid);//用户的openID，自己获取

            String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口

            String mysign = PayUtil.sign(prestr, WechatConfig.key, "utf-8").toUpperCase();

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid><![CDATA[" + WechatConfig.appid + "]]></appid>"
                    + "<body><![CDATA[" + body + "]]></body>"
                    + "<mch_id><![CDATA[" + WechatConfig.mch_id + "]]></mch_id>"
                    + "<nonce_str><![CDATA[" + nonce_str + "]]></nonce_str>"
                    + "<notify_url><![CDATA[" + WechatConfig.notify_url + "]]></notify_url>"
                    + "<openid><![CDATA[" + openid + "]]></openid>"
                    + "<out_trade_no><![CDATA[" + payOrderId + "]]></out_trade_no>"
                    + "<spbill_create_ip><![CDATA[" + spbill_create_ip + "]]></spbill_create_ip>"
                    + "<total_fee>" + 1 + "</total_fee>"//支付的金额，单位：分
                    + "<trade_type><![CDATA[" + WechatConfig.TRADETYPE + "]]></trade_type>"
                    + "<sign><![CDATA[" + mysign + "]]></sign>"
                    + "</xml>";
            //调用统一下单接口，并接受返回的结果

            String result = PayUtil.httpRequest(WechatConfig.pay_url, "POST", xml);

            // 将解析结果存储在HashMap中
            Map map = PayUtil.doXMLParse(result);

            String return_code = (String) map.get("return_code");//返回状态码
            String result_code = (String) map.get("result_code");//返回状态码
            Map<String, Object> response = new HashMap<String, Object>();//返回给小程序端需要的参数
            if (return_code.equals("SUCCESS")) {
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                response.put("nonceStr", nonce_str);
                response.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + WechatConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id + "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtil.sign(stringSignTemp, WechatConfig.key, "utf-8").toUpperCase();

                response.put("paySign", paySign);
                //修改订单信息
                Order order = new Order();
                order.setOrder_no(payOrderId);
                order.setAddr_id(addr_id);
                order.setOrder_remark(order_remark);
                int i = orderService.updateOrderstatu(order);

            }

            response.put("appid", WechatConfig.appid);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //这里是支付回调接口，微信支付成功后会自动调用
    @RequestMapping("/wxNotify")
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";

        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equals(returnCode)) {
            //修改状态添加支付时间
            String payOrderId = (String) map.get("out_trade_no");
            String openid = (String) map.get("openid");
            Order order = new Order();
            order.setOrder_payTime(new Date());
            order.setOrder_no(payOrderId);
            int i = orderService.updatePayTime(order);
            if (i > 0) {
                //删除购物车
                List<Order_item> order_items = orderItemService.selectOrderItems(payOrderId);
                List<ShoppingCar> list = new ArrayList<>();
                for (Order_item orderItem : order_items) {
                    Integer shopId = shoppingCarService.selectShopId(orderItem.getProduct_id(), orderItem.getPd_colorId(), orderItem.getDiopterName(), orderItem.getNum(), openid);
                    ShoppingCar shoppingCar = new ShoppingCar();
                    shoppingCar.setShopId(shopId);
                    list.add(shoppingCar);
                }
                if (!list.isEmpty()) {
                    int i1 = shoppingCarService.deleteArrayShopping(list);
                }

            }
            //验证签名是否正确
            Map<String, String> validParams = PayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
            String prestr = PayUtil.createLinkString(validParams);
            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            String mySign = PayUtil.sign(prestr, WechatConfig.key, "utf-8").toUpperCase();
            System.out.println(mySign + "---" + (String) map.get("sign"));
            if (mySign.equals((String) map.get("sign"))) {
                /**此处添加自己的业务逻辑代码start**/


                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    //获取随机字符串
    private String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //获取IP
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

    @RequestMapping("/updateVersion")
    @ResponseBody
    public String updateVersion(String id) {
        int i = wxUserService.updateVersion(id);
        String st = "";
        if (i > 0) {
            st = "0";
        } else {
            st = "1";
        }
        return st;
    }

    //退款接口
    @RequestMapping("/refund")
    @ResponseBody
    public Map refund(HttpServletRequest request) {

        //创建hashmap(用户获得签名)
        SortedMap<String, String> paraMap = new TreeMap<String, String>();

        //设置请求参数(小程序ID)
        paraMap.put("appid", WechatConfig.appid);
        //设置请求参数(商户号)
        paraMap.put("mch_id", WechatConfig.mch_id);
        //设置请求参数(随机字符串)
        String nonceStr=getRandomStringByLength(32);
        paraMap.put("nonce_str", nonceStr);
        //设置请求参数(商户订单号)
        String order_no=request.getParameter("order_no");
        String statu1=request.getParameter("statu");
        Integer statu=Integer.parseInt(statu1);
        Double order_payment=Double.parseDouble(request.getParameter("order_payment"));
        System.out.println("参数值"+statu+order_payment);
        paraMap.put("out_trade_no", order_no);
        //设置请求参数(商户退款单号)
        paraMap.put("out_refund_no", order_no);
        //设置请求参数(订单金额)
        paraMap.put("total_fee", 1+"");
        //设置请求参数(退款金额)
        paraMap.put("refund_fee", 1+"");

        String prestr = PayUtil.createLinkString(paraMap);
        //第二步，在stringA最后拼接上key得到stringSignTemp字符串，并对stringSignTemp进行MD5运算，再将得到的字符串所有字符转换为大写，得到sign值signValue。(签名)
        String mysign = PayUtil.sign(prestr, WechatConfig.key, "utf-8").toUpperCase();
        //将参数 编写XML格式
        StringBuffer paramBuffer = new StringBuffer();
        paramBuffer.append("<xml>");
        paramBuffer.append("<appid>"+WechatConfig.appid+"</appid>");
        paramBuffer.append("<mch_id>"+WechatConfig.mch_id+"</mch_id>");
        paramBuffer.append("<nonce_str>"+nonceStr+"</nonce_str>");
        paramBuffer.append("<sign>"+mysign+"</sign>");
        paramBuffer.append("<out_refund_no>"+paraMap.get("out_refund_no")+"</out_refund_no>");
        paramBuffer.append("<out_trade_no>"+paraMap.get("out_trade_no")+"</out_trade_no>");
        paramBuffer.append("<refund_fee>"+paraMap.get("refund_fee")+"</refund_fee>");
        paramBuffer.append("<total_fee>"+paraMap.get("total_fee")+"</total_fee>");
        paramBuffer.append("</xml>");
        try {
            Map<String,String> map = PayUtil.doXMLParse(doRefund(WechatConfig.REFUND_PATH, new String(paramBuffer.toString().getBytes(), "utf-8")));
            String return_code = (String) map.get("return_code");//返回状态码
            String return_msg = (String) map.get("return_msg");
             Map m=new HashMap();
            System.out.println(return_code+"__"+return_msg);
            if(return_code.equals("SUCCESS")){
                int i=orderService.updateStatu(order_no);
                m.put("code",0);
                m.put("msg",return_msg);
            }else{
                m.put("code",1);
                m.put("msg",return_msg);
            }
            return m;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    /**
     * 加载证书
     */
    private String doRefund(String url,String data) throws Exception{
        /**
         * 注意PKCS12证书 是从微信商户平台-》账户设置-》 API安全 中下载的
         */

        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(WechatConfig.CERT_PATH);//P12文件目录 证书路径
        try {
            /**
             * 此处要改
             * */
            keyStore.load(instream, WechatConfig.mch_id.toCharArray());//这里写密码..默认是你的MCHID
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        /**
         * 此处要改
         * */
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, WechatConfig.mch_id.toCharArray())//这里也是写密码的
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        try {
            HttpPost httpost = new HttpPost(url); // 设置响应头信息
            httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(data, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();

                String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                EntityUtils.consume(entity);
                return jsonStr;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }

}