package com.trial.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 远程业务调用
 * @author: Mr.Luo
 * @create: 2024-04-09 19:00
 **/
@FeignClient(name = "trial" )
public interface SpringCloudServiceClient {

    @GetMapping("/springcloud/test1/{message}")
    String test1(@PathVariable("message") String message);
}
