package com.my.www.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname WebAppConfigurer
 * @Description TODO
 * @Date 2019/6/27 9:31
 * @Created by Eaven
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        interceptorRegistration.excludePathPatterns("/", "/static/**", "/assets/**", "/static/**/**", "/login/checkLogin", "/index.html", "index", "/info");
        interceptorRegistration.addPathPatterns("/**");
    }
}