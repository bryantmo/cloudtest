package com.bryant.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bryant.controller.service.HelloService;

@RestController
public class TestRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HelloService helloService;

    /**
     * 此处是通过restTemplate 直接使用Ribbon负载均衡，进行RPC调用
     * 弊端：缺少熔断能力，容易导致系统故障扩散
     * @param name
     * @return
     */
    @GetMapping("/test_ribbon_consumer")
    public String testRibbonConsumer(@RequestParam("name") String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        String body = restTemplate.getForEntity("http://application1/hello/test?name={}", String.class, params).getBody();
        return String.format("testRibbonConsumer: body =  {}", body);
    }

    /**
     * 添加了熔断能力
     * @param name
     * @return
     */
    @GetMapping("/test_ribbon_consumer_with_hystrix")
    public String testRibbonConsumerWithHystrix(@RequestParam("name") String name) {
        return helloService.testRibbonConsumerWithHystrix(name);
    }

    @GetMapping("/testRibbonConsumerWithHystrixAndCached")
    public String testRibbonConsumerWithHystrixAndCache(@RequestParam("name") String name) {
        return helloService.testRibbonConsumerWithHystrixAndCached(name);
    }

    @GetMapping("/testRibbonConsumerWithHystrixAndUpdateCache")
    public String testRibbonConsumerWithHystrixAndUpdateCache(@RequestParam("name") String name) {
        return helloService.testRibbonConsumerWithHystrixAndCached(name);
    }


}
