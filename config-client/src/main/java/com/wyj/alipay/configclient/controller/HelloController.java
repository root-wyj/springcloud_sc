package com.wyj.alipay.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/2
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${wyj.secret}")
    private String secret;

    @GetMapping("/hello")
    public String hello() {
        return secret;
    }

}
