package com.common.mvc.annotations;

import java.lang.annotation.*;

/**
 * 忽略token
 * @author yx.zhou
 * @version 2019/2/15
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface IgnoreToken {
}
