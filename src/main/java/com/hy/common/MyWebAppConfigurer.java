package com.hy.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 资源映射路径 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/home/housecd/img/**")
        .addResourceLocations("file:D:/home/housecd/img/");
  }
}
