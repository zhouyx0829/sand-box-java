package com.common.zyx.dao;

import org.jooq.*;
import org.jooq.impl.DSL;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author: yx.zhou
 * @Date: 2019/8/11
 * @Time: 14:45
 */

public class JOOQGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {
    private Table<? extends Record> table = null;
    private Class<T> entityClass;
    private Field<ID> primaryKey;

    private final DSLContext dslContext;

    public JOOQGenericDao(Class<T> entityClass, Catalog catalog, Configuration configuration) {
        this.entityClass = entityClass;
        initTable(catalog);
        primaryKey = pk();
        dslContext = DSL.using(configuration);
    }

    public DSLContext getDSLContext() {
        return dslContext;
    }

    @Override
    public T insert(T entity) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public int deleteById(ID id) {
        return 0;
    }

    @Override
    public T get(ID id) {
        return getOptional(id).orElseThrow(() -> new RuntimeException("没有找到主键对应数据!"));
    }

    @Override
    public Optional<T> getOptional(ID id) {
        return Optional.ofNullable(getDSLContext().select().from(table).where(primaryKey.eq(id)).fetchOne())
            .map(r -> r.into(entityClass));
    }

    @Override
    public List<T> fetch(Condition... conditions) {
        return null;
    }

    @Override
    public PageResult<T> fetch(PageResult<T> page, Condition... conditions) {
        return null;
    }

    @Override
    public <O> O execute(Executor<O> cb) {
        return null;
    }

    private void initTable(Catalog catalog) {
        Class<?> aClass = findInterface(entityClass)
            .orElseThrow(() -> new RuntimeException("实体类必须至少实现一个接口!"));
        for (int i = 0; i < catalog.getSchemas().size(); i++) {
            Schema schema = catalog.getSchemas().get(i);
            Optional<Table<?>> findTable = schema.getTables()
                .stream()
                .filter(t -> aClass.isAssignableFrom(t.getRecordType()))
                .findFirst();

            if (findTable.isPresent()) {
                table = findTable.get();
                break;
            }
        }
        if (table == null) {
            throw new RuntimeException("无法为该实体找到表!");
        }
    }

    /**
     * 查找实现的接口
     *
     * @param clazz
     * @return
     */
    private Optional<Class<?>> findInterface(Class<?> clazz) {
        if (Object.class == clazz) {
            return Optional.empty();
        }
        Class<?>[] is = clazz.getInterfaces();
        for (Class<?> c : is) {
            if (c.getSimpleName().startsWith("I")) {
                return Optional.of(c);
            }
        }
        return findInterface(clazz.getSuperclass());
    }

    /**
     * 查找主键
     *
     * @return
     */
    private Field<ID> pk() {
        UniqueKey<?> uk = table.getPrimaryKey();
        Field<?>[] fs = uk.getFieldsArray();
        return (Field<ID>) fs[0];
    }

}
