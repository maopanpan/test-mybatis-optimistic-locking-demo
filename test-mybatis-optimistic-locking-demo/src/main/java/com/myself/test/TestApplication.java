package com.myself.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 类名称：TestApplication<br>
 * 类描述：<br>
 * 创建时间：2019年01月22日<br>
 *
 * @author maopanpan
 * @version 1.0.0
 */

@MapperScan(basePackages = {"com.myself.test.mapper"})
@ComponentScan(basePackages = {"com.myself.test.*"})
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
