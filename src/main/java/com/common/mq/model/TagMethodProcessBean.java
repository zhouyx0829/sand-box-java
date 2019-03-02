package com.common.mq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * 用于储存需要执行的方法和执行该方法的bean
 *
 * @author yx.zhou
 * @version 2019/2/15
 */
@Data
@AllArgsConstructor
@Order
public class TagMethodProcessBean {

    Method method;

    Object bean;

    Integer order;

    boolean always;

    long delay;

    int delayMethod;

}
