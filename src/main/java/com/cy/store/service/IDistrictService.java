package com.cy.store.service;

import com.cy.store.entity.District;

import java.util.List;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: IDistrictService
 * @Author: zyp
 * Date: 2022/1/16 13:36
 * project name: store
 * @Version:
 * @Description:
 */
public interface IDistrictService {

    /**
     * 根据父代号查询区域信息（省市区）
     * @param parent 父代号
     * @return 多个区域信息
     */
    List<District> getByParent(String parent);

    /**
     * 根据省/市/区代号查询省/市/区的名称
     * @param code
     * @return
     */
    String getNameByCode(String code);
}
