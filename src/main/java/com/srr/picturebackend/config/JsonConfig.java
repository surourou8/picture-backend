package com.srr.picturebackend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Spring MVC Json 配置
 */
@JsonComponent//将该类标记为Jackson的序列化/反序列化组件，Spring Boot会自动扫描并注册其中的配置。
public class JsonConfig {

    /**
     * 添加 Long 转 json 精度丢失的配置
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();//禁用XML映射功能，仅处理JSON
        SimpleModule module = new SimpleModule();//Jackson模块，用于添加自定义序列化/反序列化器
        module.addSerializer(Long.class, ToStringSerializer.instance);//处理包装类 Long
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);//处理基本类型 long
        //ToStringSerializer：将数值类型转换为字符串的序列化器
        objectMapper.registerModule(module);
        return objectMapper;
    }
}