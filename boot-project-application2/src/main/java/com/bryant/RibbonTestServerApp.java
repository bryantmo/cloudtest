package com.bryant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// EnableEurekaClient 注解启动一个服务注册中心的客户端
@EnableEurekaClient
@SpringBootApplication
public class RibbonTestServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonTestServerApp.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
