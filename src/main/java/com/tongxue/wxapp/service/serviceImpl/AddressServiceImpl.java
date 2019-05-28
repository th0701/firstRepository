package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.dao.AddressMapper;
import com.tongxue.wxapp.pojo.Address;
import com.tongxue.wxapp.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public int addAddress(Address address) {
        return addressMapper.addAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public Address selectWxAddr(String openId, Integer addr_id) {
        return addressMapper.selectWxAddr(openId,addr_id);
    }

    @Override
    public Address selectOrderAddr(Integer id) {
        return addressMapper.selectOrderAddr(id);
    }

    @Override
    public int deleteAddress(Integer id) {
        return addressMapper.deleteAddress(id);
    }

    @Override
    public List<Address> selectList(String id) {
        return addressMapper.selectList(id);
    }
}
