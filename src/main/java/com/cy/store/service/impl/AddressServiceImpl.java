package com.cy.store.service.impl;

import com.cy.store.config.MyConfig;
import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ex.*;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @PackgeName: com.cy.store.service.impl
 * @ClassName: AddressServiceImpl
 * @Author: zyp
 * Date: 2022/1/15 16:49
 * project name: store
 * @Version:
 * @Description: 新增收货地址
 */
@Service
public class AddressServiceImpl implements IAddressService {

//    @Value("${user.address.max-count}")
//    private Integer maxCount;

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if (count >= myConfig.getMaxCount()) {
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        String provinceName = districtMapper.findNameByCode(address.getProvinceCode());
        String cityName = districtMapper.findNameByCode(address.getCityCode());
        String areaName = districtMapper.findNameByCode(address.getAreaCode());

        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        // 补全数据
        address.setUid(uid);
        // 1: 默认收货地址 0: 不是默认收货地址
        address.setIsDefault(count == 0 ? 1 : 0);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        // 插入收货地址
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入用户收货地址时产生未知的异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address : list) {
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedUser(null);
            address.setModifiedTime(null);
        }
        return list;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        // 判断用户指定的默认收货地址是否存在
        Address address = addressMapper.findByAid(aid);
        if(null == address){
            throw new AddressNotFoundException("收货地址不存在");
        }

        // 检测当前获取到的收货地址数据的归属
        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }

        // 先将所有的收货地址设置为非默认
        Integer rows = addressMapper.updateNonDefault(uid);
        if(rows < 1){
            throw new UpdateException("更新数据产生未知异常");
        }

        // 将用户选中的某条收货地址为默认收货地址
        rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据产生未知异常");
        }
    }
}
