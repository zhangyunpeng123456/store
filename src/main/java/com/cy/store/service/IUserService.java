package com.cy.store.service;

import com.cy.store.entity.User;
import org.springframework.stereotype.Service;

/**
 * @PackgeName: com.cy.store.service
 * @ClassName: IUserService
 * @Author: zyp
 * Date: 2021/12/25 14:32
 * project name: store
 * @Version:
 * @Description:
 */
public interface IUserService {

    /**
     * 用户注册
     * @param user
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 修改密码
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 根据uid获取user对象
     * @param uid
     * @return
     */
    User getByUid(Integer uid);

    /**
     * 更新个人资料
     * @param uid
     * @param username
     * @param user
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 修改用户的头像
     * @param uid
     * @param avatar 用户头像的路径
     * @param username 修改者
     */
    void changeAvatar(Integer uid, String avatar, String username);
}
