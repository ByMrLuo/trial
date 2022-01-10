package com.trail.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.trail.api.rpc.TestService;

/**
 * @description:在使用者中调用远程服务
 * @date: 2022/1/2 11:35
 * @author: luoziwen
 */
public class CallRemoteServiceInTheConsumer {

    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    public static void main(String[] args) {
        ReferenceConfig<TestService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(TestService.class);
        TestService service = reference.get();
        String message = service.testMethod("dubbo");
        System.out.println(message);
    }
}
