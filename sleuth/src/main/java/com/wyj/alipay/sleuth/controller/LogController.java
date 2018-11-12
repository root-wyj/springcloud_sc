package com.wyj.alipay.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/1
 */
@RestController
public class LogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/printLog")
    public String log() {
        LOGGER.info("--logger2--");
        return "print log success";
    }
}
