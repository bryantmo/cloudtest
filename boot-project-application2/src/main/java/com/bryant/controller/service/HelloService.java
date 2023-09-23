package com.bryant.controller.service;

public interface HelloService {
    String testRibbonConsumerWithHystrix(String name);

    String testRibbonConsumerWithHystrixAndCached(String name);

    String testRibbonConsumerWithHystrixAndUpdateCache(String name);
}
