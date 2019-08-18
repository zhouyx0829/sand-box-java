package com.common.zyx.dao;

import org.jooq.Condition;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author: yx.zhou
 * @Date: 2019/8/11
 * @Time: 14:37
 */
public interface IGenericService<E, ID extends Serializable> {
    static String generateID() {
        return UUID.randomUUID().toString();
    }


    E get(ID id);

    Optional<E> getOptional(ID id);

    E save(E entity);

    int insertOnDuplicateKeyIgnore(E entity);

    void save(Collection<E> entities);

    E update(E entity);

    E update(E entity, boolean ignoreNull);

    void update(Collection<E> entities);

    int update(Collection<E> entities, boolean ignoreNull);

    int update(E entity, Condition condition);

    PageResult<E> page(PageResult<E> page);

    int delete(ID id);

    void deleteByIds(Collection<ID> ids);

    List<E> findAll();

    Optional<E> fetchOne(Condition... var1);

    Optional<E> fetchOne(Stream<Condition> var1);

    Optional<E> fetchOneWithOptional(Stream<Optional<Condition>> var1);

    List<E> cascadeFetch(List<E> var1, Cascade var2);

    E cascadeFetch(E var1, Cascade var2);
}
