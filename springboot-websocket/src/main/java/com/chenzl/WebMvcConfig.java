package com.chenzl;

/**
 * 该类的作用是可以为ws.html提供便捷的地址映射,
 * 只需要在地址栏里面输入localhost:8080/cl,就会找到cl.html
 * Created by chenzl on 2017/12/11.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/cl").setViewName("/cl");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/chat").setViewName("/chat");
    }
}