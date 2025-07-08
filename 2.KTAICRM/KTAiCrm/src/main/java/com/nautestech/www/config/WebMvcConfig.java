package com.nautestech.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nautestech.www.interceptor.AutoLoginInterceptor;;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
    private AutoLoginInterceptor autoLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(autoLoginInterceptor)
                .addPathPatterns("/**")  // 모든 경로에 적용
                .excludePathPatterns("/doLogin", "/assets/**", "/resource/**");  // 로그인 처리 및 정적 리소스는 제외
    }
}
