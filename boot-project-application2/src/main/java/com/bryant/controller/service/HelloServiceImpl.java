package com.bryant.controller.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "testRibbonConsumerWithHystrixFallback",
            commandKey = "testRibbonConsumerWithHystrix",
            groupKey = "testGroup",
            threadPoolKey = "testThreadPoolKey")
    @Override
    public String testRibbonConsumerWithHystrix(String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        String body = restTemplate.getForEntity("http://application1/hello/test?name={}", String.class, params).getBody();
        return String.format("testRibbonConsumerWithHystrix: body =  {}", body);
    }

    public String testRibbonConsumerWithHystrixFallback(String name, Throwable a) {
        return "testRibbonConsumerWithHystrixFallback : " + name + ", ex : " + a.getMessage();
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "testRibbonConsumerWithHystrixAndCachedFallback")
    @Override
    public String testRibbonConsumerWithHystrixAndCached(String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        String body = restTemplate.getForEntity("http://application1/hello/test?name={}", String.class, params).getBody();
        return String.format("testRibbonConsumerWithHystrix: body =  {}", body);
    }

    public String testRibbonConsumerWithHystrixAndCachedFallback(String name, Throwable a) {
        return "testRibbonConsumerWithHystrixFallback : " + name + ", ex : " + a.getMessage();
    }

    @CacheRemove(commandKey = "testRibbonConsumerWithHystrixAndCached")
    @HystrixCommand(fallbackMethod = "testRibbonConsumerWithHystrixAndUpdateCacheFallback")
    @Override
    public String testRibbonConsumerWithHystrixAndUpdateCache(String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        String body = restTemplate.getForEntity("http://application1/hello/test?name={}", String.class, params).getBody();
        return String.format("testRibbonConsumerWithHystrix: body =  {}", body);
    }

    public String testRibbonConsumerWithHystrixAndUpdateCacheFallback(String name, Throwable a) {
        return "testRibbonConsumerWithHystrixFallback : " + name + ", ex : " + a.getMessage();
    }
}