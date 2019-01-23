package com.test.myself;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 类名称：TestApplication<br>
 * 类描述：<br>
 * 创建时间：2018年10月15日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.test.myself.mapper"})
@ComponentScan(basePackages = {"com.test.myself.*"})
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
