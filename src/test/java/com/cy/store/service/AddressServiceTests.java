package com.cy.store.service;

import com.cy.store.config.MyConfig;
import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: AddressServiceTests
 * @Author: zyp
 * Date: 2022/1/15 17:47
 * project name: store
 * @Version:
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private MyConfig myConfig;

    @Autowired
    private IAddressService iAddressService;

    @Test
    public void testAddNewAddress(){
        Address address = new Address();
        address.setName("lili");
        address.setPhone("17898345678");
        address.setAddress("北京海淀");
        iAddressService.addNewAddress(3, "tom3", address);
    }

    @Test
    public void test(){
        System.out.println(myConfig);
    }

    @Test
    public void testSetDefault(){
        iAddressService.setDefault(4, 4, "tom4");
    }

    @Test
    public void testDelete(){
        iAddressService.delete(1, 4, "tomas");
    }
}
