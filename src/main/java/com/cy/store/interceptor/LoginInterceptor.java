package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PackgeName: com.cy.store.interceptor
 * @ClassName: LoginInterceptor
 * @Author: zyp
 * Date: 2022/1/1 12:43
 * project name: store
 * @Version:
 * @Description: 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果检查session中没有uid，说明当前用户没有登录，就进行拦截；否则放行
        Object uid = request.getSession().getAttribute("uid");
        if(uid == null){
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
