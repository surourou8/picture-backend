package com.srr.picturebackend;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.srr.picturebackend.mapper") //告诉 Spring 扫描 com.srr.picturebackend.mapper 包下的所有接口，并将这些接口注册为 Spring Bean，无需手动在每个接口上添加 @Mapper 注解
@EnableAspectJAutoProxy(exposeProxy = true) //启用AspectJ自动代理并暴露代理对象
public class PictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureBackendApplication.class, args);
    }

}
