package com.myself.test.common.mybatis.interceptor;


import com.myself.test.utils.PluginUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.*;

/**
 * 类名称：OptimisticLockingInterceptor<br>
 * 类描述：<br>
 * 创建时间：2019年01月22日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
@Slf4j
public class OptimisticLockingInterceptor implements Interceptor {

    private Properties props = null;

    @Override
    public Object intercept(Invocation invocation) throws Exception {
        String interceptMethod = invocation.getMethod().getName();
        if (!"prepare".equals(interceptMethod)) {
            return invocation.proceed();
        }
        StatementHandler handler = (StatementHandler) PluginUtil.processTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(handler);
        MappedStatement ms = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        SqlCommandType sqlCmdType = ms.getSqlCommandType();
        if (!sqlCmdType.equals(SqlCommandType.UPDATE)) {
            return invocation.proceed();
        }
        Object paramObject = metaObject.getValue("delegate.boundSql.parameterObject");
        Class<?> entityClass = ClassUtils.getUserClass(paramObject.getClass());
        EntityField field = this.getVersionFieldRegular(entityClass);
        if (Objects.isNull(field)) {
            return invocation.proceed();
        }
        String versionColumn = field.getField().getName();
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        Object originalVersion = metaObject.getValue("delegate.boundSql.parameterObject." + versionColumn);
        if (Objects.isNull(originalVersion) || Long.parseLong(originalVersion.toString()) <= 0) {
            throw new BindingException("value of version field[" + versionColumn + "]can not be empty");
        }
        String originalSql = boundSql.getSql();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("==> originalSql: " + originalSql);
        }
        originalSql = addVersionToSql(originalSql, versionColumn, originalVersion);
        metaObject.setValue("delegate.boundSql.sql", originalSql);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("==> originalSql after add version: " + originalSql);
        }
        return invocation.proceed();
    }

    private String addVersionToSql(String originalSql, String versionColumnName, Object originalVersion) {
        try {
            Statement stmt = CCJSqlParserUtil.parse(originalSql);
            if (!(stmt instanceof Update)) {
                return originalSql;
            }
            Update update = (Update) stmt;
            if (!contains(update, versionColumnName)) {
                buildVersionExpression(update, versionColumnName);
            }
            Expression where = update.getWhere();
            if (where != null) {
                AndExpression and = new AndExpression(where, buildVersionEquals(versionColumnName, originalVersion));
                update.setWhere(and);
            } else {
                update.setWhere(buildVersionEquals(versionColumnName, originalVersion));
            }
            return stmt.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return originalSql;
        }
    }

    private boolean contains(Update update, String versionColumnName) {
        List<Column> columns = update.getColumns();
        for (Column column : columns) {
            if (column.getColumnName().equalsIgnoreCase(versionColumnName)) {
                return true;
            }
        }
        return false;
    }

    private void buildVersionExpression(Update update, String versionColumnName) {
        List<Column> columns = update.getColumns();
        Column versionColumn = new Column();
        versionColumn.setColumnName(versionColumnName);
        columns.add(versionColumn);

        List<Expression> expressions = update.getExpressions();
        Addition add = new Addition();
        add.setLeftExpression(versionColumn);
        add.setRightExpression(new LongValue(1));
        expressions.add(add);
    }

    private Expression buildVersionEquals(String versionColumnName, Object originalVersion) {
        EqualsTo equal = new EqualsTo();
        Column column = new Column();
        column.setColumnName(versionColumnName);
        equal.setLeftExpression(column);
        LongValue val = new LongValue(originalVersion.toString());
        equal.setRightExpression(val);
        return equal;
    }

    private EntityField getVersionFieldRegular(Class<?> parameterClass) {
        if (parameterClass != Object.class) {
            Field[] arr$ = parameterClass.getDeclaredFields();
            int len$ = arr$.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                Field field = arr$[i$];
                if (field.isAnnotationPresent(Version.class)) {
                    field.setAccessible(true);
                    return new EntityField(field, true);
                }
            }

            return this.getVersionFieldRegular(parameterClass.getSuperclass());
        } else {
            return null;
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof ParameterHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        if (Objects.nonNull(properties) && !properties.isEmpty()) {
            props = properties;
        }
    }

}
