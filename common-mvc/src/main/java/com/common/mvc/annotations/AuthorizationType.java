package com.common.mvc.annotations;

import java.lang.annotation.*;

/**
 * 授权
 *
 * @author yx.zhou
 * @version 2019/2/15
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AuthorizationType {

    String[] value();
}
