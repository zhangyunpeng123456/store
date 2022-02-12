package com.cy.store.mapper;

import com.cy.store.StoreApplication;
import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.List;

/**
 * @PackgeName: com.cy.store.mapper
 * @ClassName: AddressMapperTests
 * @Author: zyp
 * Date: 2022/1/15 16:15
 * project name: store
 * @Version:
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;


    @Test
    public void testInsert(){
        Address address = new Address();
        address.setUid(4);
        address.setName("tomas");
        address.setAddress("北京昌平");
        address.setPhone("15123678934");
        addressMapper.insert(address);
    }

    @Test
    public void testCountByUid(){
        Integer rows = addressMapper.countByUid(4);
        System.out.println(rows);
    }

    @Test
    public void testFindByUid(){
        List<Address> list = addressMapper.findByUid(3);
        System.out.println(list);
    }

    @Test
    public void testFindByAid(){
        Address address = addressMapper.findByAid(1);
        System.out.println(address);
    }

    @Test
    public void testUpdateNonDefault(){
        Integer rows = addressMapper.updateNonDefault(3);
        System.out.println(rows);
    }

    @Test
    public void testUpdateDefaultByAid(){
        Integer rows = addressMapper.updateDefaultByAid(1, "tomas", new Date());
        System.out.println(rows);
    }

    @Test
    public void testDeleteByAid(){
        Integer rows = addressMapper.deleteByAid(14);
        System.out.println(rows);
    }

    @Test
    public void testFindLastModified(){
        Address address = addressMapper.findLastModified(4);
        System.out.println(address);
    }
}
