package com.trail.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.trail.api.rpc.TestService;
import com.trail.api.rpc.impl.TestServiceImpl;

import java.util.concurrent.CountDownLatch;

/**
 * @description:dubbo接口暴露流程
 * @date: 2021/11/12 10:39
 * @author: luoziwen
 */
public class Test {

    private static String zookeeperHost = System.getProperty("zookeeper.address", "121.199.164.16");

    public static void main(String[] args) throws Exception {
        ServiceConfig<TestService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        service.setInterface(TestService.class);
        service.setRef(new TestServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }


}
