package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMappper;
import com.cy.store.service.IProductService;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @PackgeName: com.cy.store.service.impl
 * @ClassName: ProductServiceImpl
 * @Author: zyp
 * Date: 2022/2/13 13:57
 * project name: store
 * @Version:
 * @Description:
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMappper productMappper;

    @Override
    public List<Product> findHotList() {
        List<Product> hotList = this.productMappper.findHotList();
        for(Product product : hotList){
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return hotList;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMappper.findById(id);
        Optional.ofNullable(product).orElseThrow(() -> new ProductNotFoundException("尝试访问的商品数据不存在!"));

        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);

        return product;
    }
}
