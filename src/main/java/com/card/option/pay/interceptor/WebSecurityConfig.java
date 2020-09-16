package com.card.option.pay.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests() // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()  // 任何请求,登录后可以访问
                .authenticated();*/
        http.csrf().disable();
    }
}
