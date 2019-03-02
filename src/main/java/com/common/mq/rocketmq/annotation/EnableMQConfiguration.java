package com.common.mq.rocketmq.annotation;

import java.lang.annotation.*;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableMQConfiguration {
}
