package com.wyj.alipay.openfeign.service.resource;

import com.wyj.alipay.openfeign.service.hystrix.ComputeSourceApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/6
 */
@FeignClient(name = "compute-service", fallback = ComputeSourceApiHystrix.class)
public interface ComputeSourceApi {
    @GetMapping("/services")
    String services();
}
