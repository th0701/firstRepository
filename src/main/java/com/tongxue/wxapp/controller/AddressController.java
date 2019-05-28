package com.tongxue.wxapp.controller;

import com.tongxue.wxapp.pojo.Address;
import com.tongxue.wxapp.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @RequestMapping("/selectWxAddr")
    @ResponseBody
    public Map selectWxAddr(String openId,Integer addr_id){
        Map map=new HashMap();
        Address address = addressService.selectWxAddr(openId, addr_id);
        if(address!=null){
            map.put("code",0);
            map.put("msg","");
            map.put("data",address);
        }else{
            map.put("code",1);
            map.put("msg","您还没有添加地址！");
        }
        return map;
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map selectList(String openId){
        Map map=new HashMap();
        List<Address> addresses = addressService.selectList(openId);
        if(addresses!=null && addresses.size()>0){
            map.put("code",0);
            map.put("msg","");
            map.put("data",addresses);
        }else{
            map.put("code",1);
            map.put("msg","您还没有添加地址！");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/addAddress")
    public Map addAddress(Address address){
        Map map=new HashMap();
        if(address.getTackName()!=null&& address.getOpenId()!=null && address.getTackNumber()!=null && address.getTackCity()!=null&&address.getTackProvince()!=null){
            address.setStatu(1);
            int i=addressService.addAddress(address);
            if(i>0){
                map.put("code",0);
                map.put("msg","添加成功");
            }else{
                map.put("code",1);
                map.put("msg","添加失败");
            }
        }else{
            map.put("code",1);
            map.put("msg","参数不能为空");
        }
        return map;
    }

    @RequestMapping("/updateAddr")
    @ResponseBody
    public Map updateAddr(Integer addr_id,String tackName,String tackNumber,String tackProvince,String tackCity){
        Map map=new HashMap();
        if(addr_id!=null&& tackName!=null && tackNumber!=null && tackProvince!=null&&tackCity!=null){
            Address address=new Address();
            address.setAddr_id(addr_id);
            address.setTackNumber(tackNumber);
            address.setTackCity(tackCity);
            address.setTackProvince(tackProvince);
            address.setTackName(tackName);
            int i=addressService.updateAddress(address);
            if(i>0){
                map.put("code",0);
                map.put("msg","修改成功");
            }else{
                map.put("code",1);
                map.put("msg","修改失败");
            }
        }else{
            map.put("code",1);
            map.put("msg","参数不能为空");
        }
        return map;
    }
}
