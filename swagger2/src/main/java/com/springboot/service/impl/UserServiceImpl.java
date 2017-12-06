package com.springboot.service.impl;

import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by chenzl on 2017/11/30.
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 通过JdbcTemplate实现UserService中定义的数据访问操作
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    public void createUser(String name,Integer age){
        jdbcTemplate.update("INSERT into USER (name,age) VALUE (?,?)",name,age);
    }

    /**
     * 根据用户名删除用户
     * @param name
     */
   public void deletebyName(String name){
       jdbcTemplate.update("DELETE FROM USER WHERE NAME =?",name);
   }

    /**
     * 获取用户总量
     * @return
     */
    public Integer getUserListAll(){
        return jdbcTemplate.queryForObject("select count(1) from user",Integer.class);
    }

    /**
     * 删除所有的用户
     */
    public void deleteAll(){
        jdbcTemplate.update("DELETE from USER ");
    }
}
