package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.springCloud"})
@Component("com.springCloud")
public class DeptConsumerFeign_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeign_App.class, args);
	}

}
