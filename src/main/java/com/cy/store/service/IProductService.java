package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: IProductService
 * @Author: zyp
 * Date: 2022/2/13 13:55
 * project name: store
 * @Version:
 * @Description:
 */
public interface IProductService {

    /**
     * 热销商品前4名
     * @return
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    Product findById(Integer id);
}
