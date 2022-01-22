package com.cy.store.service.ex;

/**
 * @PackgeName: com.cy.store.service.ex
 * @ClassName: AccessDeniedException
 * @Author: zyp
 * Date: 2022/1/22 18:09
 * project name: store
 * @Version:
 * @Description:
 */
public class AccessDeniedException extends ServiceException {
    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    public AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
