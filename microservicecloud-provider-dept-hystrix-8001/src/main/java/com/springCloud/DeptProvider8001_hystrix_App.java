package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient	//将本服务注册到eureka服务中
@EnableCircuitBreaker //对hystrix熔断器的支持
public class DeptProvider8001_hystrix_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_hystrix_App.class, args);
	}
}
