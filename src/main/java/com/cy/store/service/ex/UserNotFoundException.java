package com.cy.store.service.ex;

/**
 * @PackgeName: com.cy.store.service.ex
 * @ClassName: UserNotFoundException
 * @Author: zyp
 * Date: 2021/12/29 21:54
 * project name: store
 * @Version:
 * @Description:
 */
public class UserNotFoundException extends ServiceException {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
