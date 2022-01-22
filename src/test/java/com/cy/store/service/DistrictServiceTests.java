package com.cy.store.service;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: DistrictServiceTests
 * @Author: zyp
 * Date: 2022/1/16 13:59
 * project name: store
 * @Version:
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    @Autowired
    private IDistrictService districtService;


    @Test
    public void testGetByParent(){
        // 86表示中国，所有省的父代号都是86
        List<District> list = districtService.getByParent("86");
        for(District district : list){
            System.out.println(district);
        }
        System.out.println(list.size());
    }


    @Test
    public void testGetNameByCode(){
        String name = districtService.getNameByCode("610000");
        System.out.println(name);
    }
}
