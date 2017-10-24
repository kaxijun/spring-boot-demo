package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})  // 自动配置 default true
@EnableCaching  // 允许启动缓存
//@EnableScheduling // 允许启动定时任务
@EnableAsync

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
