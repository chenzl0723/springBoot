package com.chenzl.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 接收数据的实体
 * Created by chenzl on 2017/12/8.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String blog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "User [名字=" + name + ", blog=" + blog + "]";
    }

}
