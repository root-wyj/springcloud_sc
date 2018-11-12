package com.wyj.alipay.openfeign.service.hystrix;

import com.wyj.alipay.openfeign.service.resource.ComputeSourceApi;
import org.springframework.stereotype.Component;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/6
 */
@Component
public class ComputeSourceApiHystrix implements ComputeSourceApi {

    @Override
    public String services() {
        return "fall back";
    }
}
