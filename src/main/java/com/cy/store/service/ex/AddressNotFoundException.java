package com.cy.store.service.ex;

/**
 * @PackgeName: com.cy.store.service.ex
 * @ClassName: AddressNotFoundException
 * @Author: zyp
 * Date: 2022/1/22 18:10
 * project name: store
 * @Version:
 * @Description:
 */
public class AddressNotFoundException extends ServiceException {
    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
