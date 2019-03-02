package com.common.mvc.utils;

import com.common.mvc.model.Subject;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

public class UserControllerUtils {

    private static final ThreadLocal<Subject<?>> CURRENT_USER = new ThreadLocal<>();

    public static void setCurrentUser(Subject<?> user) {
        CURRENT_USER.set(user);
    }

    public static Subject<?> currentUser(){
        return CURRENT_USER.get();
    }
}
