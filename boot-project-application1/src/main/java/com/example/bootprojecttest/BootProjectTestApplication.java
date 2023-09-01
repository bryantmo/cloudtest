package com.example.bootprojecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.eureka.ConditionalOnRibbonAndEurekaEnabled;

@SpringBootApplication
@EnableEurekaClient
public class BootProjectTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootProjectTestApplication.class, args);
	}

}
