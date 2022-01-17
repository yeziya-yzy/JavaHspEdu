package com.springsecurityedu.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/1/15
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping("/index")
    public String index(){
        return "hello index";
    }

    @GetMapping("/manage")
    @Secured({"ROLE_root","ROLE_admin"}) //设置访问角色
    public String manage(){
        return "hello manage";
    }

    @GetMapping("/manage2")
    @PreAuthorize("hasAnyAuthority('root')") //设置访问权限(也可以设置访问角色)
    public String manage2(){
        return "hello manage2";
    }

    //针对返回值进行权限控制,没有权限就不会提供返回值,但是会执行return前面的代码
    //@PostAuthorize("hasAnyAuthority('root')")

    //@PostFilter()对返回的数据进行拦截,返回特定的数据
}
