package com.trial.api.rpc.springcloud;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

/**
 * @description: Resilience4j 熔断器操作类
 * Resilience4官方提供springboot2demo:
 * https://github.com/resilience4j/resilience4j-spring-boot2-demo
 * @author: Mr.Luo
 * @create: 2024-04-14 01:42
 **/
@RestController
@RequestMapping("/springcloudresilience4j")
public class SpringCloudResilience4jProducter {

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    @GetMapping("/test1/{message}")
    @CircuitBreaker(name = "delay", fallbackMethod = "fluxFallback")
    public String test1(@PathVariable("message") String message){
        return message + "测试成功";
    }


    /**
     * @description  触发熔断
     * @author Mr.Luo
     * @date 2024/04/14 01:44
     */
    @GetMapping("/test2")
    @TimeLimiter(name = "delay",fallbackMethod = "test2fallback")
    public CompletableFuture<String> test2() throws Exception{

        CompletableFuture<String> timeout = CompletableFuture.supplyAsync((Supplier<String>)()->{
            try{
                /**
                 * 必须在线程内沉睡，如果是超时的测试是通过阻塞请求住现成的话是不会触发这些失败回调的，切记!!!!
                 * */
                Thread.sleep(10000);
            }catch (Exception e){

            }
            return "success";
        });
        return timeout;
    }

    public CompletableFuture<String> test2fallback(TimeoutException ex){
        System.out.println("调用降级了");
        return CompletableFuture.completedFuture("降级了");
    }

}
