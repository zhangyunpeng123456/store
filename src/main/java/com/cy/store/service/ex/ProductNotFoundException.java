package com.cy.store.service.ex;

/**
 * @PackgeName: com.cy.store.service.ex
 * @ClassName: ProductNotFoundException
 * @Author: zyp
 * Date: 2022/2/13 15:06
 * project name: store
 * @Version:
 * @Description:
 */
public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
