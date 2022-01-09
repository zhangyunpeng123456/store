package com.cy.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackgeName: com.cy.store.controller
 * @ClassName: HelloController
 * @Author: zyp
 * Date: 2021/12/24 22:35
 * project name: store
 * @Version:
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
