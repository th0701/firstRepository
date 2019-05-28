package com.tongxue.wxapp.service;

import com.tongxue.wxapp.pojo.Address;

import java.util.List;

public interface AddressService {
    List<Address> selectList(String id);

    int addAddress(Address address);

    int updateAddress(Address address);

    int deleteAddress(Integer id);

    Address selectWxAddr(String openId,Integer addr_id);

    //找到订单绑定的地址
    Address selectOrderAddr(Integer id);
}
