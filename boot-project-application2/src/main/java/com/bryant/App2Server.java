package com.bryant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// EnableEurekaClient 注解启动一个服务注册中心的客户端
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
//@SpringCloudApplication // @SpringCloudApplication 注解包含了以上三个注解（拓展点）
public class App2Server {

    public static void main(String[] args) {
        new SpringApplicationBuilder(App2Server.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
