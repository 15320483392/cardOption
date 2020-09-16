package com.card.option.pay.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wangtao
 * @date 2019/12/29 21:24
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private UserAuthRestInterceptor userAuthRestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthRestInterceptor)
                .addPathPatterns(getIncludePathPatterns());
                //.excludePathPatterns("/sign/**","/code/**");
    }

    private ArrayList<String> getIncludePathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/role/**",
                "/user/**"
        };
        Collections.addAll(list, urls);
        return list;
    }
}
