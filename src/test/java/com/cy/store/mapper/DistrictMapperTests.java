package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @PackgeName: com.cy.store.mapper
 * @ClassName: DistrictMapperTests
 * @Author: zyp
 * Date: 2022/1/16 13:25
 * project name: store
 * @Version:
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {

    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void testFindByParent(){
        List<District> list = districtMapper.findByParent("140800");
        for(District district : list){
            System.out.println(district);
        }
    }

    @Test
    public void testFindNameByCode(){
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }
}
