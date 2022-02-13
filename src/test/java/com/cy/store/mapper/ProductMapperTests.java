package com.cy.store.mapper;

import com.cy.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @PackgeName: com.cy.store.mapper
 * @ClassName: ProductMapperTests
 * @Author: zyp
 * Date: 2022/2/13 14:07
 * project name: store
 * @Version:
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductMapperTests {

    @Autowired
    private ProductMappper productMappper;

    @Test
    public void testFindHotList(){
        List<Product> hotList = this.productMappper.findHotList();
        hotList.stream().forEach(System.out::println);
    }

}
