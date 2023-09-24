package com.bryant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //开启api网关
public class ZuulServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulServer.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
