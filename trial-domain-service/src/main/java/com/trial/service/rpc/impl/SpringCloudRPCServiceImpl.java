package com.trial.service.rpc.impl;

import com.trial.fegin.SpringCloudResilience4jClient;
import com.trial.fegin.SpringCloudServiceHystrixClient;
import com.trial.service.rpc.SpringCloudRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 远程调用相关事件调用
 * @author: Mr.Luo
 * @create: 2024-04-09 18:42
 **/
@Service
public class SpringCloudRPCServiceImpl implements SpringCloudRPCService {

    @Resource
    SpringCloudServiceHystrixClient springCloudServiceHystrixClient;

    @Resource
    SpringCloudResilience4jClient springCloudResilience4jClient;

    public String rpcTest1(){
        return springCloudServiceHystrixClient.test1("666666");
    }


    @Override
    public String rpcTest2() {
        return springCloudServiceHystrixClient.test2();
    }

    @Override
    public String rpcTest3() {
        return springCloudServiceHystrixClient.test3();
    }

    @Override
    public String rpcTest4() {
        return springCloudServiceHystrixClient.test4();
    }


    @Override
    public String rpcTest5() {
        return springCloudResilience4jClient.test();
    }

    @Override
    public String rpcTest6() {
        return springCloudResilience4jClient.test1("11111");
    }


    @Override
    public String rpcTest7() {
        return springCloudResilience4jClient.test2();
    }
}
