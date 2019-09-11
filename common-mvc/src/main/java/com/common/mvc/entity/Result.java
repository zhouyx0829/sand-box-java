package com.common.mvc.entity;

import lombok.Data;

/**
 * @author: yx.zhou
 * @Date: 2019/7/28
 * @Time: 21:49
 */

@Data
public class Result {
    private boolean success;
    private String msg;
    private int code;
    private Object data;

    public Result() {

    }
    public Result(String string) {
        this.data = string;
        this.success = true;
    }
    public Result(boolean success) {
        this.success = success;
    }
    public Result(Object data) {
        this.success = true;
        this.data = data;
    }
}
