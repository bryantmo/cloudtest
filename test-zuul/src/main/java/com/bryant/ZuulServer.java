package com.bryant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulServer.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
