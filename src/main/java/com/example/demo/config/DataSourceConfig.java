package com.example.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


// 多数据源配置
@Configuration
public class DataSourceConfig {
    @Bean(name = "primaryDS")
    @ConfigurationProperties(prefix = "spring.datasource.primary") // application.properteis中对应属性的前缀
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "ds2")
//    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
//    public DataSource dataSource2() {
//        return DataSourceBuilder.create().build();
//    }
}
