package com.wyj.alipay.ribbon.controller;

import com.wyj.alipay.ribbon.service.IComputeService;
import com.wyj.alipay.ribbon.service.imp.LogServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/1
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    IComputeService computeService;
    @Autowired
    LogServiceImp logService;

    @GetMapping("/services")
    public String services() {
        return computeService.services();
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "a", defaultValue = "0") int a,
                      @RequestParam(name = "b", defaultValue = "0") int b) {
        return computeService.add(a, b);
    }

    @GetMapping("/stop")
    public String stop() {
        return computeService.stop();
    }

    @GetMapping("/printLog")
    public String log() {
        LOGGER.info("--logger1--");
        return logService.log();
    }
}
