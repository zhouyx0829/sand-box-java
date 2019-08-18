//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.common.zyx.dao;

import lombok.Data;
import org.jooq.SelectField;
import org.jooq.TableLike;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class CascadeItem {
    private TableLike<?> tableLike;
    private Set<SelectField<?>> selectFields;

    public CascadeItem(TableLike<?> tableLike, SelectField<?>... selectFields) {
        this.tableLike = tableLike;
        this.selectFields = Arrays.stream(selectFields).collect(Collectors.toSet());
    }
}
