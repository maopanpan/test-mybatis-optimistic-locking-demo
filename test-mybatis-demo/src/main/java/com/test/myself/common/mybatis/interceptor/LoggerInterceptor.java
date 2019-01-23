package com.test.myself.common.mybatis.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * 类名称：LoggerInterceptor<br>
 * 类描述：<br>
 * 创建时间：2018年10月15日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
@Slf4j
public class LoggerInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        LOGGER.info("LoggerInterceptor : intercept");
        StatementHandler handler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(handler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        //先拦截到RoutingStatementHandler，
        // 里面有个StatementHandler类型的delegate变量，
        // 其实现类是BaseStatementHandler，然后就到BaseStatementHandler的成员变量mappedStatement
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        // 配置文件中SQL语句的ID
        String id = mappedStatement.getId();
        BoundSql boundSql = handler.getBoundSql();
        String sql = boundSql.getSql();
        LOGGER.info("SQL: " + sql);
        metaObject.setValue("delegate.boundSql.sql", sql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        LOGGER.info("LoggerInterceptor : setProperties");
    }
}
