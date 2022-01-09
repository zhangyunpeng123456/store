package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

/**
 * @PackgeName: com.cy.store.mapper
 * @ClassName: UserMapper
 * @Author: zyp
 * Date: 2021/12/24 23:14
 * project name: store
 * @Version:
 * @Description:
 */
public interface UserMapper {

    /**
     * 插入用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return
     */
    User findByName(String username);


    /**
     * 修改密码
     * @param uid
     * @param password
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updatePasswordByUid(@Param("uid") Integer uid,
                                @Param("password") String password,
                                @Param("modified_user") String modifiedUser,
                                @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据uid查询用户
     */
    User findByUid(Integer uid);


    /**
     * 修改个人资料
     * @param user
     * @return
     */
    Integer updateInfoByUid(User user);

    /**
     * 上传头像
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar,
                              @Param("modifiedUser") String modifiedUser,
                              @Param("modifiedTime") Date modifiedTime);
}
