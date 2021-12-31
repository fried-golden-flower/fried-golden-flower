package com.example.friedgoldenflower.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/demo").setViewName("index");
                registry.addViewController("/login").setViewName("login");
//                registry.addViewController("/user/sendEmailCode").setViewName("login");
                registry.addViewController("/register").setViewName("register");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/**");
                registry.addResourceHandler("/*.html").addResourceLocations("classpath:/templates/*.html");
            }
        };
        return webMvcConfigurer;
    }
}
