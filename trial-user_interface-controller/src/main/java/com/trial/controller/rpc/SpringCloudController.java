package com.trial.controller.rpc;

import com.trial.service.rpc.SpringCloudRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:springcloud相关组件远程调用使用
 * @author: Mr.Luo
 * @create: 2024-04-09 15:54
 **/
@RestController
@RequestMapping("/springcloud")
public class SpringCloudController {

    @Autowired
    private SpringCloudRPCService springCloudEventService;

    @GetMapping("/hystrixtest1")
    public String hystrixtest1(){
        return springCloudEventService.rpcTest1();
    }
}
