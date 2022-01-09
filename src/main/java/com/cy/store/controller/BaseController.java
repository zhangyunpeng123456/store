package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @PackgeName: com.cy.store.controller
 * @ClassName: BaseController
 * @Author: zyp
 * Date: 2021/12/25 16:55
 * project name: store
 * @Version:
 * @Description:
 */
public class BaseController {

    public static final Integer OK = 200;
    public static final String MESSAGE = "用户注册成功";

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> jsonResult = new JsonResult<>();
        if(e instanceof UsernameDuplicatedException){
            jsonResult.setState(4000);
            jsonResult.setMessage("用户名已经被占用");
        }else if(e instanceof UserNotFoundException){
            jsonResult.setState(5001);
            jsonResult.setMessage("用户数据不存在异常");
        }else if(e instanceof PasswordNotMatchException){
            jsonResult.setState(5002);
            jsonResult.setMessage("密码错误的异常");
        } else if(e instanceof InsertException){
            jsonResult.setState(5000);
            jsonResult.setMessage("插入数据时产生未知的异常");
        } else if(e instanceof  UpdateException){
            jsonResult.setState(5003);
            jsonResult.setMessage("更新数据时产生未知的异常");
        }else if (e instanceof FileEmptyException) {
            jsonResult.setState(6000);
        } else if (e instanceof FileSizeException) {
            jsonResult.setState(6001);
        } else if (e instanceof FileTypeException) {
            jsonResult.setState(6002);
        } else if (e instanceof FileStateException) {
            jsonResult.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            jsonResult.setState(6004);
        }
        return jsonResult;
    }

    /**
     * 获取session对象中的uid
     * @param session
     * @return 当前登录用户uid的值
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取当前登录用户的username
     * @param session
     * @return
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

}


