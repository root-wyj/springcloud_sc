package com.wyj.alipay.openfeign.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/6
 */

/**
 * 除了使用yml配置之外，还可以使用class配置feign。
 * 区别在于，yml配置>class配置，并且 yml配置对全部的@FeignClient有效，class配置需要在指定@FeignClient的configuration属性
 *
 * 这里配置的feign会覆盖Netflix提供的默认的配置文件 {@link org.springframework.cloud.openfeign.FeignClientsConfiguration}
 */
@Configuration
public class FeignConfig {
}
