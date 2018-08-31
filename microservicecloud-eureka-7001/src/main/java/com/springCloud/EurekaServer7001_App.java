package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	//EurekaServer服务端的启动类，接收其他客户端注册。
public class EurekaServer7001_App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7001_App.class, args);
	}

}
