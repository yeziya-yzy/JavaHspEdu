package com.springsecurityedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//里面的内容就是开启的注解
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) //开启Security注解的扫描
@MapperScan("com.springsecurityedu.mapper") //扫描Mapper
@SpringBootApplication
public class SecurityDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemo1Application.class, args);
    }

}
