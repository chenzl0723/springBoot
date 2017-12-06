package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Created by chenzl on 2017/12/6.
 */
@RestController
public class ResDocsController {
    @GetMapping("/")
    public Map<String,Object> greeting(){
        return Collections.singletonMap("message","Hello ResDocs API");
    }
}
