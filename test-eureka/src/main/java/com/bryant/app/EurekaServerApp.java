package com.bryant.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// EnableEurekaServer 注解启动一个服务注册中心，并提供给其他应用进行对话
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApp.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}
