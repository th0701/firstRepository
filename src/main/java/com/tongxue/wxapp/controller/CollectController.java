package com.tongxue.wxapp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tongxue.wxapp.pojo.Collect;
import com.tongxue.wxapp.service.CollectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private CollectService collectService;

    @RequestMapping("/addCollection")
    @ResponseBody
    public Map addCollection(Collect collect) {
        Map map = new HashMap();
        if (collect.getOpenId() != null &&   collect.getProduct_id() != null) {
            int i = collectService.addCollect(collect);
            if (i > 0) {
                map.put("code", 0);
                map.put("msg", "添加成功");
            } else {
                map.put("code", 1);
                map.put("msg", "添加失败");
            }
        } else {
            map.put("code", 1);
            map.put("msg", "参数不能为空");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectWxList")
    public Map selectWxList(String openId) {
        Map map = new HashMap();
        if (openId != null && !"undefined".equals(openId)) {
            List<Collect> collects = collectService.selectWxList(openId);
            if (collects != null && !collects.isEmpty()) {
                map.put("code", 0);
                map.put("msg", "请求成功");
                map.put("data", collects);
            } else {
                map.put("code", 1);
                map.put("msg", "暂无商品");
            }
        } else {
            map.put("code", 1);
            map.put("msg", "参数不能为空或者为undefined");
        }
        return map;
    }

    @RequestMapping("/deleteCollection")
    @ResponseBody
    public Map deleteCollection(Integer collect_id) {
        Map map = new HashMap();
        if (collect_id != null) {
            int i = collectService.deleteCollect(collect_id);
            if (i > 0) {
                map.put("code", 0);
                map.put("msg", "删除成功");
            } else {
                map.put("code", 1);
                map.put("msg", "删除失败");
            }
        } else {
            map.put("code", 1);
            map.put("msg", "参数不能为空");
        }
        return map;
    }

    @RequestMapping("/removeCollection")
    @ResponseBody
    public Map removeCollection(Integer product_id, String openId) {
        Map map = new HashMap();
        if (product_id != null && openId != null) {
            int i = collectService.removeCollect(product_id, openId);
            if (i > 0) {
                map.put("code", 0);
                map.put("msg", "已取消收藏!");
            } else {
                map.put("code", 1);
                map.put("msg", "取消失败");
            }
        } else {
            map.put("code", 1);
            map.put("msg", "参数不能为空");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/selectList")
    public Map selectList(Integer page, Integer limit) {
        Map map = new HashMap();
        PageHelper.startPage(page, limit);
        PageInfo<Collect> pageInfo=new PageInfo<>(collectService.selectList());
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/index")
    public String index(){
        return "collect/collectList";
    }
}
