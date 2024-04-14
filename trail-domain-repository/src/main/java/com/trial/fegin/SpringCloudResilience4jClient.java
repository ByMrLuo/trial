package com.trial.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: Resilience4j熔断器远程调用
 * @author: Mr.Luo
 * @create: 2024-04-14 01:45
 **/
@FeignClient(contextId = "resilience4j",name = "trial" , path = "/springcloudresilience4j",url = "http://localhost:8080")
public interface SpringCloudResilience4jClient {

    @GetMapping("/test")
    String test();

    @GetMapping("/test1/{message}")
    String test1(@PathVariable("message") String s);

    @GetMapping("/test2")
    String test2();
}
