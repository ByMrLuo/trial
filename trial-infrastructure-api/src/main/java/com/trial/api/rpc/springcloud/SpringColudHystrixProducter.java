package com.trial.api.rpc.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;


/**
 * @description:SpringCloud远程调用相关提供者逻辑实现
 * @author: Mr.Luo
 * @create: 2024-04-09 18:51
 **/
@RestController
@RequestMapping("/springcloudhystrix")
public class SpringColudHystrixProducter {



    @GetMapping("/test1/{message}")
    public String test1(@PathVariable("message") String message){
        return message + "测试成功";
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    /**
     * @description :使用 @HystrixCommand进行熔断增强
     * @author Mr.Luo
     * @date 2024/04/10 22:45
     */
    @GetMapping("/test2")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String test2() throws Exception{
        Thread.sleep(1000);
        return "测试成功";
    }


    /**
     * @description :使用 @HystrixCommand进行熔断增强
     * @author Mr.Luo
     * @date 2024/04/10 22:45
     */
    @GetMapping("/test3")
    @HystrixCommand(fallbackMethod = "test3Error")
    public String test3() throws Exception{
        Thread.sleep(10000);
        return "success";
    }

    /**
     * @description  线程池满异常熔断
     * @author Mr.Luo
     * @date 2024/04/13 20:28
     */
    @GetMapping("/test4")
    @HystrixCommand(threadPoolKey = "findResumeOpenStateTimeoutFallback",threadPoolProperties = {
            @HystrixProperty(name="coreSize",value = "2"),
            @HystrixProperty(name="maxQueueSize",value="2")
    },fallbackMethod = "test4Error")
    public String test4() throws Exception{
        Thread.sleep(1000);
        return "success";
    }

    public String test4Error(Throwable throwable) throws Exception{
        System.out.println("触发了");
        return "别掉用了线程池满了";
    }

    public String test3Error(Throwable throwable){
        return "降级处理";
    }

}
