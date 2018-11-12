之前使用了Ribbon做客户端负载均衡，使用Hystrix做容错保护，这两者被作为基础工具类框架被广泛地应用在各个微服务的实现中。SpringCloudFeign是将两者做了更高层次的封装以简化开发。它基于Netfix Feign实现，整合了SpringCloudRibbon和SpringCloudHystrix，除了提供这两者的强大功能外，还提供了一种声明是的Web服务客户端定义的方式。SpringCloudFeign在NetFixFeign的基础上扩展了对SpringMVC注解的支持，在其实现下，我们只需创建一个接口并用注解的方式来配置它，即可完成对服务提供方的接口绑定。简化了SpringCloudRibbon自行封装服务调用客户端的开发量。

更多的open-feign参考：
1. [SpringCloud声明式服务调用Feign](https://blog.csdn.net/wqh8522/article/details/79075907)
2. [Spring官方文档](https://cloud.spring.io/spring-cloud-static/spring-cloud-openfeign/2.0.2.RELEASE/single/spring-cloud-openfeign.html)
