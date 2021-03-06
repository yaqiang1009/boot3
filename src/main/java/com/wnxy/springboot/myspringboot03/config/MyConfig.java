package com.wnxy.springboot.myspringboot03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wnxy.springboot.myspringboot03.interceptor.Interceptor;

@Configuration
public class MyConfig {
	@Bean
	public WebMvcConfigurer WebMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// 映射路径
				registry.addViewController("/").setViewName("/index.html");
				registry.addViewController("/index.html").setViewName("/index.html");
				registry.addViewController("/login.html").setViewName("/login.html");
			}

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				// 拦截器
				registry.addInterceptor(new Interceptor())
				.addPathPatterns("/**").excludePathPatterns("/login.html",
						"/login","/css/**","/js/**");
			}
			
			
		};
	}
	
	
}
