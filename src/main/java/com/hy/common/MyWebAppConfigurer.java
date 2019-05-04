package com.hy.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 资源映射路径 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
  @Value("${img.pathfile}")
  private String imgPath;

  @Value("${img.pathpatterns}")
  private String pathpatterns;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler(pathpatterns) // "/home/housecd/img/**"
        .addResourceLocations(imgPath); // "file:D:/home/housecd/img/"
  }
}
