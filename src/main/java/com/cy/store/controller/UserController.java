package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @PackgeName: com.cy.store.controller
 * @ClassName: UserController
 * @Author: zyp
 * Date: 2021/12/25 16:06
 * project name: store
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /*
       @RequestMapping("/reg")
       public JsonResult<Void> reg(User user) {
           JsonResult<Void> jsonResult = new JsonResult<>();
           try {
               userService.reg(user);
               jsonResult.setState(200);
               jsonResult.setMessage("用户注册成功");
           } catch (UsernameDuplicatedException e) {
               jsonResult.setState(4000);
               jsonResult.setMessage("用户名被占用");
           } catch (InsertException e){
               jsonResult.setState(5000);
               jsonResult.setMessage("注册时产生未知的异常");
           }

           return jsonResult;
       }
       */
    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<Void>(OK);
    }


    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());
        return new JsonResult<>(OK, user);
    }


    @PutMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }


    @GetMapping("/get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User user = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK, user);
    }

    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(OK);
    }

    // 设置文件上传的最大值
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    // 限制上传文件的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping("/change_avatar")
    public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {
        // 判断文件是否为null
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }

        // 判断文件大小
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }

        // 判断文件类型
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType.toLowerCase())) {
            throw new FileTypeException("文件类型不支持");
        }

        // 创建上传文件目录
        String uploadPath = session.getServletContext().getRealPath("upload");
        System.out.println("文件上传路径：" + uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 创建上传文件的空文件
        String originalFilename = file.getOriginalFilename();
        System.out.printf("原始文件名:%S\n", originalFilename);
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString().toUpperCase() + suffix;
        File uploadFile = new File(uploadDir, newFileName);


        // 进行文件上传
        try {
            file.transferTo(uploadFile);
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        String avatar = "/upload/" + newFileName;
        userService.changeAvatar(getUidFromSession(session), avatar, getUsernameFromSession(session));

        // 返回用户头像的路径给前端页面，将来用于头像展示使用
        return new JsonResult<>(OK, avatar);
    }
}
