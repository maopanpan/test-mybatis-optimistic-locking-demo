package com.myself.test.common.mybatis.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * 类名称：EntityField<br>
 * 类描述：<br>
 * 创建时间：2019年01月23日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
public class EntityField {
    private Field field;
    private boolean version;
    private String columnName;

    public EntityField(Field field, boolean version) {
        this.field = field;
        this.version = version;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isVersion() {
        return version;
    }

    public void setVersion(boolean version) {
        this.version = version;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
