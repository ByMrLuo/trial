package com.trial.service.rpc.impl;

import com.trial.fegin.SpringCloudServiceClient;
import com.trial.service.rpc.SpringCloudRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 远程调用相关事件调用
 * @author: Mr.Luo
 * @create: 2024-04-09 18:42
 **/
@Service
public class SpringCloudRPCServiceImpl implements SpringCloudRPCService {

    @Autowired
    SpringCloudServiceClient springCloudServiceClient;

    public String rpcTest1(){
        return springCloudServiceClient.test1("666666");
    }


    @Override
    public String rpcTest2() {
        return springCloudServiceClient.test2();
    }

    @Override
    public String rpcTest3() {
        return springCloudServiceClient.test3();
    }

    @Override
    public String rpcTest4() {
        return springCloudServiceClient.test4();
    }
}
