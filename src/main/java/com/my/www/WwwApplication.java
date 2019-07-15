package com.my.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.www.dao.mapper")
public class WwwApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwwApplication.class, args);
    }

}
