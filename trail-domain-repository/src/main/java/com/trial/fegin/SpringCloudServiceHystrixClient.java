package com.trial.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 远程业务调用
 *  查了所有的资料和github的提问都没有人回答为什么openfegin在和hystrix集成的时候无法使用fallback属性，
 *  网上的比较常见掉分添加feign.hystrix.enabled: true 或者feign.xxxxx.enabled: true都是无效的，
 *  官网对应版本的的资料也是无效的
 *  较新的版本只能使用@EnableCircuitBreaker + @HystrixCommand(fallbackMethod = "errorfallback"）
 *  来实现fallback
 * @author: Mr.Luo
 * @create: 2024-04-09 19:00
 **/
//如果使用springcloud-loadblance请开始下面这行注释配置
//@FeignClient(name = "trial" ,configuration = LoadBalancerFeignClientConfiguration.class)
@FeignClient(contextId = "hystrix",name = "trial" ,fallback = SpringCloudFallbackHystrixConfiguration.class,
        path = "/springcloudhystrix",url = "http://localhost:8080",configuration = FooConfiguration.class)
public interface SpringCloudServiceHystrixClient {


    @GetMapping("/test1/{message}")
    String test1(@PathVariable("message") String message);

    /**
     * @description  超时测试
     * @author Mr.Luo
     * @date 2024/04/12 16:04
     */
    @GetMapping("/test2")
    String test2();

    /**
     * @description  失败回调返回测试
     * @author Mr.Luo
     * @date 2024/04/12 16:04
     */
    @GetMapping("/test3")
    String test3();

    /**
     * @description  失败回调返回测试
     * @author Mr.Luo
     * @date 2024/04/12 16:04
     */
    @GetMapping("/test4")
    String test4();
}
