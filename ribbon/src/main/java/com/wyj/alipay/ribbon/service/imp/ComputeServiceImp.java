package com.wyj.alipay.ribbon.service.imp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyj.alipay.ribbon.service.IComputeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ComputeServiceImp implements IComputeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComputeServiceImp.class);

    @Autowired
    RestTemplate restTemplate;


    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public String services() {
        return restTemplate.getForObject("http://COMPUTE-SERVICE/services", String.class);
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public String add(int a, int b) {
        return restTemplate.getForObject("http://COMPUTE-SERVICE/add?a="+a+"&b="+b, String.class);
    }

    /*
     * 这种熔断的方式 会 直接中断调用该方法的执行线程，而去调用fallback方法
     *
     * 疑问：
     * 调用了n多遍 stop方法，但是 还是会走stop的实体方法，而不会立刻走熔断的fallback
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @Override
    public String stop() {
        return restTemplate.getForObject("http://COMPUTE-SERVICE/stop", String.class);
    }

    @Override
    public String fallback() {
        LOGGER.info("go to fallback");
        return "fallback";
    }

    public String fallback(int a, int b) {
        LOGGER.info("go to fallback, a:" + a +", b:"+b);
        return "fallback";
    }
}
