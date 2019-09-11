package com.common.mvc.exception;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

public enum Error implements ErrorInterface {

    UNKNOW_EXCEPTION(500, "系统异常"),
    UN_AUTHORIZATION(10001, "用户授权异常"),
    NO_AUTHORIZATION_PROVIDER_FIND(50001, "NO_TOKEN_PROVIDER_FIND NAME: %s");

    private int code;
    private String msg;

    Error(int code) {
        this.code = code;
        this.msg = this.name();
    }

    Error(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }
}
