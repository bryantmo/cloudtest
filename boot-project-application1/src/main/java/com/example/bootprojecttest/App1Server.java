package com.example.bootprojecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启注册发现客户端
public class App1Server {

	public static void main(String[] args) {
		SpringApplication.run(App1Server.class, args);
	}

}
