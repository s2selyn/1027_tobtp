package com.kh.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.HandlerInterceptor;
import com.kh.spring.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 1️⃣ LoginInterceptor Bean 등록
    @Bean
    public HandlerInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    // 2️⃣ 인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**") // 모든 요청에 적용
                .excludePathPatterns("/login", "/css/**", "/js/**"); // 예외 URL
    }
}
