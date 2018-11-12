package com.wyj.alipay.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/1
 */
@RestController
public class ComputerController {

    private static final Logger logger = LoggerFactory.getLogger(ComputerController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/add")
    public String add(@RequestParam(name = "a", defaultValue = "0")int a,
                      @RequestParam(name = "b", defaultValue = "0")int b) {
        logger.info("computer a:" + a + ", b:" + b);
        return "success:" + (a + b);
    }

    @GetMapping("/services")
    public String sv() {
        String services = "Service: " + discoveryClient.getServices();
        logger.info(services);
        return services;
    }

    @GetMapping("/stop")
    public String stop() {
        try {
            logger.info("start stop");
            Thread.sleep(5000);
            logger.info("end stop");
        } catch (InterruptedException e) {
            logger.info("thread be interrupted");
            e.printStackTrace();
        }
        return "stop";
    }
}

