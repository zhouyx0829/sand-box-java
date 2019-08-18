package com.common.zyx.dao;

import org.jooq.Condition;
import org.jooq.DSLContext;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 基础dao接口
 *
 * @author: yx.zhou
 * @Date: 2019/8/11
 * @Time: 14:41
 */

public interface GenericDao<T, ID extends Serializable> {
    /**
     * 插入
     *
     * @param entity
     * @return
     */
    T insert(T entity);

    /**
     * 更新，忽略空值
     *
     * @param entity
     * @return
     */
    T update(T entity);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteById(ID id);

    /**
     * 根据id 查找
     * @param id
     * @return
     */
    T get(ID id);

    Optional<T> getOptional(ID id);

    /**
     * 单表，根据条件返回集合
     * 表为泛型所指定的表
     *
     * @param conditions
     * @return
     */
    List<T> fetch(Condition... conditions);

    /**
     * 基础单表分页
     *
     * @param page
     * @param conditions
     * @return
     */
    PageResult<T> fetch(PageResult<T> page, Condition... conditions);

    /**
     * 自定义执行SQL语句
     *
     * @param cb
     * @param <O>
     * @return
     */
    <O> O execute(Executor<O> cb);

    @FunctionalInterface
    interface Executor<E> {
        E execute(DSLContext context);
    }
}
