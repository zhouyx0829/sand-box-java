package com.common.mvc.exception;

/**
 * 授权的ex
 *
 * @author yx.zhou
 * @version 2019/2/15
 */

public class AuthorizationException extends Exception {

    private String message;

    public AuthorizationException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
