package com.trial.fegin;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @description: FallbackFactory<xxxxClient>实现是类级别回调失败统一返回处理，
 * 方法级别直接实现XXXClient接口即可
 * fallback触发规则，属于
 * RuntimeException that is thrown when a HystrixCommand fails and does not have a fallback.
 * 所以不要测试这些属于RuntimeException接口的异常，不会触发fallback的
 *
 * @author: Mr.Luo
 * @create: 2024-04-12 17:10
 **/
@Component
public class SpringCloudFallbackConfiguration implements SpringCloudServiceClient {

        @Override
        public String test1(String message) {
            return "hahahahha";
        }

        @Override
        public String test2() {
            return "2222222";
        }

        @Override
        public String test3() {
            return "触发fallback了";
        }

    @Override
    public String test4() {
        return "test4触发fallback了";
    }
}
