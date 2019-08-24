package com.newer.homework0812.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createInterceptor())
                .addPathPatterns("/homework0812/**")//所有路径
                .excludePathPatterns("/Login1","/check","/homework0812/**.html");//拦截器不会拦截的请求
    }
    @Bean
    public MyInterceptor createInterceptor(){
        return new MyInterceptor();
    }
}
