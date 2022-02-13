package com.cy.store.mapper;

import com.cy.store.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PackgeName: com.cy.store.mapper
 * @ClassName: ProductMappper
 * @Author: zyp
 * Date: 2022/2/13 13:30
 * project name: store
 * @Version:
 * @Description:
 */
@Repository
public interface ProductMappper {

    /**
     * 热销商品前4名
     * @return
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详细信息
     * @param id
     * @return
     */
    Product findById(Integer id);
}
