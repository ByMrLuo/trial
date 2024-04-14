package com.trial.fegin;

import org.springframework.stereotype.Component;

/**
 * @description: Resilience4j 的fallback回调
 * @author: Mr.Luo
 * @create: 2024-04-14 02:07
 **/
@Component
public class SpringCloudFallbackResilience4jConfiguration implements SpringCloudResilience4jClient{

    @Override
    public String test() {
        return "11111";
    }

    @Override
    public String test1(String s) {
        return "222222";
    }

    @Override
    public String test2() {
        return "Resilience4j 熔断了";
    }
}
