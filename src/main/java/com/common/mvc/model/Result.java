package com.common.mvc.model;

import lombok.Data;

/**
 * @author yx.zhou
 * @version 2019/2/16
 */

@Data
public class Result {

    private boolean success;

    private String msg;

    private int code;

    private Object date;


    public Result() {

    }

    public Result(Object date) {
        this.success = true;
        this.date = date;
    }

    public Result(boolean success) {
        this.success = success;
    }
}
