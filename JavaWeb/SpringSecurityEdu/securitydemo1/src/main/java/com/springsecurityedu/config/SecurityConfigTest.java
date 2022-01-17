package com.springsecurityedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/1/15
 * 配置类 设置用户名和密码(过时,一般不用)
 */
@Deprecated
//@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //加密
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        String password = pe.encode("wyw");
        //设置用户名和密码
        auth.inMemoryAuthentication().withUser("wyw").password(password).roles("root");
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }
}
