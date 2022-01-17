package com.springsecurityedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springsecurityedu.bean.Users;
import com.springsecurityedu.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/1/15
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用usersMapper里面的方法查询数据库(根据用户名)
        //String username这个参数就是传过来的用户名
        Users users = usersMapper.selectOne(new QueryWrapper<Users>().eq("username", username));
        //判断
        if (users == null) {  //没有对象,认证失败
            throw new UsernameNotFoundException("用户名不存在");
        }
        //给用户加上root权限     给用户上ROLE_root用户的权限"ROLE_root"
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("root,ROLE_sale,ROLE_admin");

        //得到用户名和密码
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()), auths);
    }
}
