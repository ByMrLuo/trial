package com.trial.api.rpc.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.trial.api.rpc.TestService;

/**
 * @description:
 * @date: 2021/12/29 14:51
 * @author: luoziwen
 */

@Service(version = "1.0",registry = "2")
public class TestServiceImpl implements TestService {


    @Override
    public String testMethod(String message) {
        //查询业务~~~
        return "success";
    }
}
