package com.springsecurityedu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/1/15
 * 权限配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    //注入数据源
    @Autowired
    private DataSource dataSource;

    //配置对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //自己创建表
        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //退出
        //logoutUrl("/logout")退出地址(访问就退出)
        //退出成功跳转logoutSuccessUrl("/test/hello")
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();

        //配置没有权限跳转的页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");

        http.formLogin() //自定义自己编写的登陆页面
                .loginPage("/login.html") //登录页设置
                .loginProcessingUrl("/user/login")  //登陆访问路径(提交数据到的地方)
                .defaultSuccessUrl("/success.html").permitAll()//登陆成功的页面
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll()//设置不需要认证的路径

                //当前登陆的用户有root权限才能访问/test/index这个路径
                //.antMatchers("/test/index").hasAuthority("root")

                //当前登陆的用户有root权限或者admin权限就能访问/test/index这个路径
                //.antMatchers("/test/index").hasAnyAuthority("admin", "root")

                //hasRole("sale")当前登陆的用户有ROLE_sale才可以访问,这里会加上ROLE_,所以要给用户加上ROLE_sale权限
                .antMatchers("/test/index").hasRole("sale")
                //hasAnyRole()对多个角色和hasAnyAuthority()一样

                .anyRequest().authenticated()

                //自动登录  时长为3600秒
                .and().rememberMe().tokenRepository(persistentTokenRepository()).
                tokenValiditySeconds(3600).userDetailsService(userDetailsService)

                .and().csrf().disable();//关闭csrf的防护
    }
}
