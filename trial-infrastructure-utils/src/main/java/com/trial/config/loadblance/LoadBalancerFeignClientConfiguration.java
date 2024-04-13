package com.trial.config.loadblance;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 开启springcloud loadblance相关配置，所以我在这里只提供一个使用的方式，这里并不使用该组件
 *  这里说明一下当前版本的loadblance还是没有ribbon的算法全面的，但是后续肯定是会被替换的
 *  算法的问题你可以自己实现然后引入，当然你可以的话，我在看官方文档的时候上面有人提到，如下：
 *  在 Spring-cloud 体系中，大部分范围还是老实使用 Ribbon，但基于 spring-cloud-k8s，
 *  可能需要使用基于spring-cloud-starter-kubernetes-loadbalancer。
 *  因为在前面实践过，基于 Ribbon 的 LB，无法跨命名空间来实现服务间的相互访问。
 * @author: Mr.Luo
 * @create: 2024-04-12 16:54
 **/
@Configuration
public class LoadBalancerFeignClientConfiguration {

    @Bean
    public Feign.Builder feignBuilder() {
        // 如果你不使用Hystrix，可以使用默认的Feign.Builder
         return Feign.builder();
    }
}
