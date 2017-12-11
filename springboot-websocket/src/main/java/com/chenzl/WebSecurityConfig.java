package com.chenzl;

/**
 * Created by chenzl on 2017/12/11.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()//1根路径和/login路径不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //2登陆页面
                .defaultSuccessUrl("/chat") //3登陆成功转向该页面
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    //4
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("czl").password("czl").roles("USER")//这里两个是分别账号和密码（账号：czl密码：czl）
                .and()
                .withUser("ffk").password("ffk").roles("USER");//这里两个是分别账号和密码（账号：ffk密码：ffk）
    }
    //5忽略静态资源的拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}