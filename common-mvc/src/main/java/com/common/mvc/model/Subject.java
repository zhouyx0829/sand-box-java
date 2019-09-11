package com.common.mvc.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */
public interface Subject<T> {

    /**
     * 获取登陆信息
     *
     * @return
     */
    T getSubject();

    /**
     * 获取权限
     *
     * @return
     */
    default Set<String> findPermissionSign() {
        return new HashSet<>();
    }

    /**
     * 获取用户URL权限
     * @return
     */
    default Set<String> findPermissionUrl() {
        return new HashSet<>();
    }
}
