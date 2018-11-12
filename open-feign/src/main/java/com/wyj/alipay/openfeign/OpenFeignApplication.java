package com.wyj.alipay.openfeign;

import com.wyj.alipay.openfeign.service.resource.ComputeSourceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class OpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class, args);
    }


    @Autowired
    ComputeSourceApi computeSourceApi;

    @GetMapping("/feign/services")
    public String service() {
        return computeSourceApi.services();
    }
}
