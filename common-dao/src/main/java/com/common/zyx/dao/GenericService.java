package com.common.zyx.dao;

import org.jooq.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: yx.zhou
 * @Date: 2019/8/11
 * @Time: 14:40
 */

public class GenericService <E, ID extends Serializable> implements IGenericService<E, ID>{

    protected Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    protected CommonDao<E> dao;

    private GenericDao<E, Serializable> getDao() {
        return dao;
    }
    @Override
    public E get(ID id) {
        return null;
    }

    @Override
    public Optional<E> getOptional(ID id) {
        return null;
    }

    @Override
    public E save(E entity) {
        return null;
    }

    @Override
    public int insertOnDuplicateKeyIgnore(E entity) {
        return 0;
    }

    @Override
    public void save(Collection<E> entities) {

    }

    @Override
    public E update(E entity) {
        return null;
    }

    @Override
    public E update(E entity, boolean ignoreNull) {
        return null;
    }

    @Override
    public void update(Collection<E> entities) {

    }

    @Override
    public int update(Collection<E> entities, boolean ignoreNull) {
        return 0;
    }

    @Override
    public int update(E entity, Condition condition) {
        return 0;
    }

    @Override
    public PageResult<E> page(PageResult<E> page) {
        return null;
    }

    @Override
    public int delete(ID id) {
        return 0;
    }

    @Override
    public void deleteByIds(Collection<ID> ids) {

    }

    @Override
    public List<E> findAll() {
        return null;
    }

    @Override
    public Optional<E> fetchOne(Condition... var1) {
        return null;
    }

    @Override
    public Optional<E> fetchOne(Stream<Condition> var1) {
        return null;
    }

    @Override
    public Optional<E> fetchOneWithOptional(Stream<Optional<Condition>> var1) {
        return null;
    }

    @Override
    public List<E> cascadeFetch(List<E> var1, Cascade var2) {
        return null;
    }

    @Override
    public E cascadeFetch(E var1, Cascade var2) {
        return null;
    }
}
