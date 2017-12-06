package com.springboot.controller;

import com.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenzl on 2017/11/30.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);


    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
