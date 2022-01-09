package com.cy.store.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: UserServiceTests
 * @Author: zyp
 * Date: 2021/12/25 15:02
 * project name: store
 * @Version:
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService iUserService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("tom3");
            user.setPassword("12345678");
            iUserService.reg(user);
            System.out.println("ok");
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = iUserService.login("tom9", "123456");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        iUserService.changePassword(555, "tom5", "123456", "12345678");
    }

    @Test
    public void getByUid(){
        User user = iUserService.getByUid(3);
        System.out.println(user);
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("18799990000");
        user.setEmail("bbbb@163.com");
        user.setGender(1);
        iUserService.changeInfo(3, "tom3", user);
    }

    @Test
    public void changeAvatar(){
        iUserService.changeAvatar(3, "/aa/bb.png", "tom3434");
    }
}
