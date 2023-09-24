package com.bryant.service;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 这里注解使用的是service-id，由此绑定一个服务
@FeignClient("application2")
public interface Helloservice {

    @GetMapping(value = "test_ribbon_consumer")
    String hello(@RequestParam("name") String name);

}
