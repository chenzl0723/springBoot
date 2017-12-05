package com.springboot.service;

/**
 * Created by chenzl on 2017/11/30.
 */
public interface UserService {
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void createUser(String name,Integer age);

    /**
     * 根据用户名删除用户
     * @param name
     */
    void deletebyName(String name);

    /**
     * 获取用户总量
     * @return
     */
    Integer getUserListAll();

    /**
     * 删除所有的用户
     */
    void deleteAll();
}
