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
    /**
     * @description 连接测试
     * @author Mr.Luo
     * @date 2024/04/12 16:03
     */
    @GetMapping("/hystrixtest1")
    public String hystrixtest1(){
        return springCloudEventService.rpcTest1();
    }

    /**
     * @description 远程调用超时
     * @author Mr.Luo
     * @date 2024/04/12 16:02
     */
    @GetMapping("/hystrixtest2")
    public String hystrixtest2(){
        return springCloudEventService.rpcTest2();
    }

    /**
     * @description 远程调用失败
     * @author Mr.Luo
     * @date 2024/04/12 16:02
     */
    @GetMapping("/hystrixtest3")
    public String hystrixtest3(){
        return springCloudEventService.rpcTest3();
    }

    /**
     * @description 远程调用失败
     * @author Mr.Luo
     * @date 2024/04/12 16:02
     */
    @GetMapping("/hystrixtest4")
    public String hystrixtest4(){
        return springCloudEventService.rpcTest4();
    }


    /**
     * @description 远程调用成功
     * @author Mr.Luo
     * @date 2024/04/12 16:02
     */
    @GetMapping("/resilience4jtest1")
    public String resilience4jtest1(){
        return springCloudEventService.rpcTest5();
    }


    /**
     * @description 远程调用成功
     * @author Mr.Luo
     * @date 2024/04/12 16:02
     */
    @GetMapping("/resilience4jtest2")
    public String resilience4jtest2(){
        return springCloudEventService.rpcTest6();
    }

    /**
     * @description 远程调用失败
     * @author Mr.Luo
     * @date 2024/04/12 16:02
     */
    @GetMapping("/resilience4jtest3")
    public String resilience4jtest3(){
        return springCloudEventService.rpcTest7();
    }
}
