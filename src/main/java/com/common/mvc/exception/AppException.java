package com.common.mvc.exception;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 2404372373182554123L;
    private int code;
    private String msg;

    public AppException() {
        this(Error.UNKNOW_EXCEPTION);
    }

    public AppException(int code, String exMsg) {
        this.code = code;
        this.msg = exMsg;
    }

    public AppException(ErrorInterface code) {
        //没有自定义的异常统一抛500 系统异常
        code = code == null ? Error.UNKNOW_EXCEPTION : code;
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public AppException(ErrorInterface code, String exMsg) {
        this(code);
        this.msg = String.format(code.getMsg(), exMsg);
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public int getCode() {
        return code;
    }


}
