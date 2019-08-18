package com.common.zyx.dao;

import org.jooq.Catalog;
import org.jooq.Configuration;

import java.io.Serializable;

public class CommonDao<E> extends JOOQGenericDao<E, Serializable>{
    public CommonDao(Class<E> entityClass, Catalog catalog, Configuration configuration) {
        super(entityClass, catalog, configuration);
    }

}
