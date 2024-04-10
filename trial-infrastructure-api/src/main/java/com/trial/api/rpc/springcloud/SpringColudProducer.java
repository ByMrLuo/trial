package com.trial.api.rpc.springcloud;

import org.springframework.web.bind.annotation.*;


/**
 * @description:SpringCloud远程调用相关提供者逻辑实现
 * @author: Mr.Luo
 * @create: 2024-04-09 18:51
 **/
@RestController
@RequestMapping("/springcloud")
public class SpringColudProducer{

    @GetMapping("/test1/{message}")
    public String test1(@PathVariable("message") String message){
        return message + "测试成功";
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
