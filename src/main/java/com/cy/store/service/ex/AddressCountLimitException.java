package com.cy.store.service.ex;

/**
 * @PackgeName: com.cy.store.service.ex
 * @ClassName: AddressCountLimitException
 * @Author: zyp
 * Date: 2022/1/15 16:42
 * project name: store
 * @Version:
 * @Description: 每个用户的收货地址总数超出限制的异常(20条)
 */
public class AddressCountLimitException extends ServiceException {
    public AddressCountLimitException() {
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    public AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
