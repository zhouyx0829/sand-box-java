//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.common.zyx.dao;

import org.jooq.SelectField;
import org.jooq.TableLike;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Cascade {
    private Map<TableLike<?>, Set<SelectField<?>>> cascadeOptions = new HashMap<>();

    private Cascade() {
    }

    public boolean containsKey(TableLike<?> tableLike) {
        return this.cascadeOptions.containsKey(tableLike);
    }

    public static Cascade of(CascadeItem... cascadeItem) {
        Cascade cascade = new Cascade();
        Stream.of(cascadeItem).forEach((o) -> cascade.cascadeOptions.put(o.getTableLike(), o.getSelectFields()));
        return cascade;
    }

    public Set<SelectField<?>> get(TableLike<?> key) {
        return this.cascadeOptions.get(key);
    }
}
