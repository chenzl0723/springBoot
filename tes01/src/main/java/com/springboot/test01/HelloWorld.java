package com.springboot.test01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenzl on 2017/11/29.
 */
@RestController
public class HelloWorld {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }
}
