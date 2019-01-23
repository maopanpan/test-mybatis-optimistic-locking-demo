package com.myself.test.common.mybatis.config;

import com.myself.test.common.mybatis.interceptor.OptimisticLockingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类名称：SqlFliterConfig<br>
 * 类描述：<br>
 * 创建时间：2019年01月22日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@Configuration
public class SqlFliterConfig {

    @Bean
    public OptimisticLockingInterceptor build() {
        return new OptimisticLockingInterceptor();
    }
}
