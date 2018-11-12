package com.wyj.alipay.ribbon.service.imp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/1
 */
@Service
public class LogServiceImp {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String log() {
        return restTemplate.getForObject("http://SLEUTH/printLog", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}
