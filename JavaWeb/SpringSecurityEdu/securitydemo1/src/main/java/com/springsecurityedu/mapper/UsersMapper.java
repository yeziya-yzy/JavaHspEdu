package com.springsecurityedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springsecurityedu.bean.Users;
import org.springframework.stereotype.Repository;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/1/15
 * 针对数据库的方法
 */
//不让自动注入的那个报错(看上去更好看一点罢了QAQ)
@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
