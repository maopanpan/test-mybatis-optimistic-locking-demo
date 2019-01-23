package com.test.myself.common.mybatis.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhanghl
 * @date: 2018/7/24 15:26
 */
@Configuration
public class SqlFliterConfig {

    @Bean
    public LoggerInterceptor userOrderInterceptor(){
        return new LoggerInterceptor();
    }
}
