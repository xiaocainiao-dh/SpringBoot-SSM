package com.xiaocainiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.xiaocainiao.*"})
@MapperScan(value = {"com.xiaocainiao.mapper.*"})
@SpringBootApplication
public class SpringBootApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationStart.class,args);
    }
}
