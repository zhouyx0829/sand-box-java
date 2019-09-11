package com.common.mvc.exception;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */
public interface ErrorInterface {
    /**
     * 异常msg
     *
     * @return
     */
    String getMsg();

    /**
     * 异常code
     *
     * @return
     */
    int getCode();
}
