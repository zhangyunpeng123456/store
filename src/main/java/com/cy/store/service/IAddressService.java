package com.cy.store.service;

import com.cy.store.entity.Address;

import java.util.List;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: IAddressService
 * @Author: zyp
 * Date: 2022/1/15 16:48
 * project name: store
 * @Version:
 * @Description: 收货地址业务层接口
 */
public interface IAddressService {

    void addNewAddress(Integer uid, String username, Address address);

    List<Address> getByUid(Integer uid);

    /**
     * 修改某个用户的某条收货地址数据为默认收货地址
     * @param aid 收货地址的
     * @param uid 用户的id
     * @param username 修改者用户名
     */
    void setDefault(Integer aid, Integer uid, String username);

    /**
     * 删除用户选中的收货地址数据
     * @param aid 收货地址
     * @param uid 用户id
     * @param username 用户名
     */
    void delete(Integer aid, Integer uid, String username);
}
