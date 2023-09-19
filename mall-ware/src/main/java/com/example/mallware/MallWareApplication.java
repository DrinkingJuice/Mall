package com.example.mallware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // 1.开启服务注册发现功能
@SpringBootApplication
public class MallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallWareApplication.class, args);
	}

}
