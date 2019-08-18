package com.common.zyx.dao;

import org.jooq.tools.StringUtils;
import org.jooq.util.DefaultGeneratorStrategy;
import org.jooq.util.Definition;

/**
 * @author: yx.zhou
 * @Date: 2019/7/30
 * @Time: 21:29
 */

public class CustomerJOOQGeneratorStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaSetterName(Definition definition, Mode mode) {
        return "set" + getJavaClassName(definition, Mode.DEFAULT);
    }

    @Override
    public String getJavaGetterName(Definition definition, Mode mode) {
        return "get" + getJavaClassName(definition, Mode.DEFAULT);
    }

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        StringBuilder result = new StringBuilder();

        // DEBUG this staff

        String underline = definition.getOutputName()
            .replace(' ', '_')
            .replace('-', '_')
            .replace('.', '_');
        if (underline.contains("_")) {
            underline = StringUtils.toCamelCase(underline);
        } else {
            underline  = underline.substring(0, 1).toUpperCase() + underline.substring(1);
        }
        result.append(underline);
        if ("BsvChannelPrice".equals(result.toString())) {
            // 数据库表 bsv_channel_price 与 bsv_channelprice 生成文件名大小写不同，windows系统不支持
            result = new StringBuilder("BsvChannelPrice" + "U");
        }
        if ("BsbChannelPrice".equals(result.toString())) {
            // 数据库表 bsb_channel_price 与 bsb_channelprice 生成文件名大小写不同，windows系统不支持
            result = new StringBuilder("BsbChannelPrice" + "U");
        }
        if (mode == Mode.RECORD) {
            result.append("Record");
        } else if (mode == Mode.DAO) {
            result.append("Dao");
        } else if (mode == Mode.INTERFACE) {
            result.insert(0, "I");
        } else if (mode == Mode.POJO) {
            result.append("Pojo");
        }

        return result.toString();
    }
}
