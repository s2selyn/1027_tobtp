package com.kh.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kh.spring.product.model.mapper") // ProductMapper 위치
public class MybatisConfig {
}
