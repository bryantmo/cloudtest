package com.example.bootprojecttest.controller;

import com.example.bootprojecttest.config.BookConfig;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    private final Logger logger = Logger.getLogger("HelloController") ;

    @Autowired
    private BookConfig bookConfig;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/test")
    public String index() {

        discoveryClient.getServices().forEach(id -> {
            discoveryClient.getInstances(id).forEach(instance -> {
                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        System.out.println(bookConfig.getName());
        System.out.println(bookConfig.getAuthor());
        System.out.println(bookConfig.getPrice());
        System.out.println(bookConfig.getDesc());
        return bookConfig.toString();
    }
}
