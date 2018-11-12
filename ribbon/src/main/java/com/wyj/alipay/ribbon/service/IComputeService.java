package com.wyj.alipay.ribbon.service;

/**
 * Created
 * Author: wyj
 * Email: 18346668711@163.com
 * Date: 2018/11/1
 */
public interface IComputeService {
    String services();

    String add(int a, int b);

    String stop();

    String fallback();
}
