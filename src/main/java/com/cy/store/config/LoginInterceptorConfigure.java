package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: com.cy.store.config
 * @ClassName: LoginInterceptorConfigure
 * @Author: zyp
 * Date: 2022/1/1 12:47
 * project name: store
 * @Version:
 * @Description: 注册拦截器
 */
@Configuration
public class LoginInterceptorConfigure implements WebMvcConfigurer {

    private List<String> patterns = new ArrayList<>();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/product.html");
        patterns.add("/web/index.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        interceptorRegistration.addPathPatterns("/**").excludePathPatterns(patterns);
    }
}
