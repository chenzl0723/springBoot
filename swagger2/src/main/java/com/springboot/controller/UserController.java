package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.entity.UserDto;
import com.springboot.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chenzl on 2017/12/6.
 */
@RestController
@RequestMapping(value = "/test")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /**
     * 新建用户
     * @param user
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "创建用户")
    public void createUser(@RequestBody UserDto user){
        String name=user.getName();
        Integer age=user.getAge();
        userService.createUser(name,age);
    }

    /**
     * 删除用户
     * @param name
     */
    @RequestMapping(value = "/deleteUserByName/{name}",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据用户名删除用户")
    public void deleteUserByName(@PathVariable String name){
        userService.deletebyName(name);
    }

    /**
     * 获得全部用户数据数量
     */
    @RequestMapping(value = "/getNumSum",method = RequestMethod.GET)
    @ApiOperation(value = "获得全部用用户数量")
    public Integer getUserCountSum(){
        return userService.getUserListAll();
    }

    /**
     * 删除所有用户
     */
    @RequestMapping(value = "/deleteAll",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除所有用户")
    public void deleteUserAll(){
        userService.deleteAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/findByName/{name}",method = RequestMethod.GET)
    public User findByName(@PathVariable String name){
        return userRepository.findByName(name);
    }

    /**
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/findByNameAndAge/{name}/{age}",method = RequestMethod.GET)
    public User findByNameAndAge(@PathVariable String name, Integer age){
        return userRepository.findByNameAndAge(name,age);
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public User findUser(@PathVariable String name){
        return userRepository.findUser(name);
    }
}
