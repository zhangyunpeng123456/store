package com.cy.store.service.ex;

/**
 * @PackgeName: com.cy.store.service.ex
 * @ClassName: UsernameDuplicatedException
 * @Author: zyp
 * Date: 2021/12/25 0:47
 * project name: store
 * @Version:
 * @Description:
 */
public class UsernameDuplicatedException extends ServiceException {

    public UsernameDuplicatedException() {
    }

    public UsernameDuplicatedException(String message) {
        super(message);
    }

    public UsernameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicatedException(Throwable cause) {
        super(cause);
    }

    public UsernameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
