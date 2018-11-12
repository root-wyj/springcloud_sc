package com.wyj.alipay.sc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/10/31
 */
@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @GetMapping(value="/hello")
    public String add() {
        return "success";
    }

}
