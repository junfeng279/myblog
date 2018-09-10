package com.junfeng.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author junfeng
 * @Date 2018/9/7 15:21
 * Created by adminstor on 2018/9/7.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private String fileUploadPath;
    /**
     * 资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("img/**").addResourceLocations("file:///" + fileUploadPath);
    }
}
