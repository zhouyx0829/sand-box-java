package com.common.mvc.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yx.zhou
 * @version 2019/2/27
 */
@Data
public class FieldError implements Serializable {


    private String name;

    private String message;


    @Override
    public String toString() {
        return String.format("`%s`,%s", name, message);
    }
}
