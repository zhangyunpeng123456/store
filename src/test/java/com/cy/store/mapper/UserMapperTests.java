//package com.cy.store.mapper;
//
//import com.cy.store.entity.User;
//import com.cy.store.service.IUserService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
///**
// * @PackgeName: com.cy.store.mapper
// * @ClassName: UserMapperTests
// * @Author: zyp
// * Date: 2021/12/25 0:13
// * project name: store
// * @Version:
// * @Description:
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class UserMapperTests {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private IUserService iUserService;
//
//    @Test
//    void insert(){
//        User user = new User();
//        user.setUsername("tom");
//        user.setPassword("123456");
//        Integer i = userMapper.insert(user);
//        System.out.println(i);
//    }
//
//
//    @Test
//    void findByName(){
//        User user = userMapper.findByName("tom1");
//        System.out.println(user);
//    }
//
//    @Test
//    public void updatePasswordByUid(){
//        Integer i = userMapper.updatePasswordByUid(7, "123", "tom66", new Date());
//        System.out.println(i);
//    }
//
//    @Test
//    public void findByUid(){
//        User user = userMapper.findByUid(7);
//        System.out.println(user);
//    }
//
//    @Test
//    public void updateInfoByUid(){
//        User user = new User();
//        user.setUid(3);
//        user.setPhone("13456789012");
//        user.setGender(0);
//        Integer rows = userMapper.updateInfoByUid(user);
//        System.out.println(rows);
//    }
//
//
//    @Test
//    public void updateAvatarByUid(){
//        Integer rows = userMapper.updateAvatarByUid(5,"aaaa", "tom11221", new Date());
//        System.out.println(rows);
//    }
//
//
//}
