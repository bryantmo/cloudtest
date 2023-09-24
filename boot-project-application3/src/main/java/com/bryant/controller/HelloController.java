package com.bryant.controller;

import com.bryant.service.Helloservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Helloservice helloservice;

    @RequestMapping(value = "/feign-consume", method = RequestMethod.GET)
    public String helloConsumer(@RequestParam("name") String name) {
        return helloservice.hello(name);
    }

}
