package com.shoueb.itworld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.shoueb.itworld.*.dao")
@ServletComponentScan
public class ItworldApplication {

    public static void main(String[] args) {
        //Spring Boot + Mybatis +th模板 +Mymapper【tk】+分页插件
        SpringApplication.run(ItworldApplication.class, args);
    }

}

