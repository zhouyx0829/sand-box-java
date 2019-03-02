package com.common.mvc.model;

import com.google.common.collect.ImmutableSet;

import java.util.Optional;
import java.util.Set;

/**
 * @author yx.zhou
 * @version 2019/2/15
 */

public class DefaultSubject implements Subject<Object> {
    @Override
    public Object getSubject() {
        return Optional.empty();
    }

    @Override
    public Set<String> findPermissionSign() {
        return ImmutableSet.of();
    }

    @Override
    public Set<String> findPermissionUrl() {
        return  ImmutableSet.of();
    }
}
