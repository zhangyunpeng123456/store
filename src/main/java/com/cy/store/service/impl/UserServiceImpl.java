package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @PackgeName: com.cy.store.service.impl
 * @ClassName: UserServiceImpl
 * @Author: zyp
 * Date: 2021/12/25 14:35
 * project name: store
 * @Version:
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        // 查看用户是否存在，如果存在，抛出UsernameDuplicatedException
        User u = userMapper.findByName(user.getUsername());
        if (null != u) {
            throw new UsernameDuplicatedException("用户名被占用");
        }


        // 补全用户数据
        Date date = new Date();
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setCreatedTime(date);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(date);


        // 密码加密 md5
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString();
        String newPassword = getMD5Password(oldPassword, salt);
        // 将加密后的密码及盐值重新补全到用户数据中
        user.setPassword(newPassword);
        user.setSalt(salt);


        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByName(username);
        if(null == user){
            throw new UserNotFoundException("用户名不存在");
        }

        String md5Password = getMD5Password(password, user.getSalt());
        if(!md5Password.equals(user.getPassword())){
            throw new PasswordNotMatchException("密码不正确");
        }


        // 判断删除标记是否是已删除状态
        if(user.getIsDelete() == 1){
            throw new UserNotFoundException("用户名不存在");
        }

        User user1 = new User();
        user1.setUid(user.getUid());
        user1.setUsername(user.getUsername());
        user1.setAvatar(user.getAvatar());

        return user1;
    }

    /**
     * 修改密码
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        // 检查用户是否存在
        User user = userMapper.findByUid(uid);
        if(user == null || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }

        // 检查输入原密码是否正确
        String oldMd5Password = getMD5Password(oldPassword, user.getSalt());
        if(!oldMd5Password.equals(user.getPassword())){
            throw new PasswordNotMatchException("密码错误");
        }

        // 更新密码
        String newMd5Password = getMD5Password(newPassword, user.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, new Date());
        if(rows != 1){
            throw new UpdateException("修改密码时发生了未知的异常");
        }
    }

    /**
     * 根据uid获取user对象
     * @param uid
     * @return
     */
    @Override
    public User getByUid(Integer uid) {
        User user = userMapper.findByUid(uid);
        if(null == user || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }

        User u = new User();
        u.setUid(uid);
        u.setUsername(user.getUsername());
        u.setPhone(user.getPhone());
        u.setEmail(user.getEmail());
        u.setGender(user.getGender());
        return u;
    }

    /**
     * 更新个人资料
     * @param uid
     * @param username
     * @param user
     */
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User user1 = userMapper.findByUid(uid);
        if(null == user1 || user1.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        //user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoByUid(user);
        if(rows != 1){
            throw new UpdateException("更新个人资料数据时产生了未知的异常");
        }
    }

    /**
     * 修改用户的头像
     * @param uid
     * @param avatar 用户头像的路径
     * @param username 修改人用户名
     */
    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User user = userMapper.findByUid(uid);
        if(null == user || user.getIsDelete().equals(1)){
            throw new UserNotFoundException("用户数据不存在");
        }

        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新用户头像时产生未知的异常");
        }
    }

    /**
     * MD5加密（3次加密）
     * @param password
     * @param salt
     * @return
     */
    private String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
