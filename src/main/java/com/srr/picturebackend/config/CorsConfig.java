package com.srr.picturebackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//全局配置跨域资源共享
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {//自定义 CORS 规则
        // 覆盖所有请求
        registry.addMapping("/**") //匹配所有 URL 路径（Ant 风格通配符 /**），所有请求均应用此 CORS 配置。
                // 允许发送 Cookie
                .allowCredentials(true) //允许跨域请求携带 Cookie 和认证头（如 Authorization）
                // 放行哪些域名（必须用 patterns，否则 * 会和 allowCredentials 冲突）
                .allowedOriginPatterns("*") //允许所有来源（域名）访问
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //允许的 HTTP 方法
                .allowedHeaders("*") //允许所有请求头（如自定义头 X-Token）
                .exposedHeaders("*"); //允许客户端访问所有响应头（如自定义头 X-Info）
    }
}