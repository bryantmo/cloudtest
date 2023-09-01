package com.bryant.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test_ribbon_consumer")
    public String testRibbonConsumer(String name) {
        HashMap<String, String> params = new HashMap<>();
        return restTemplate.getForEntity("http://hello-boot-project/hello/test", String.class, params).getBody();
    }

}
