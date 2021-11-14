package com.trial.service.dubbo.impl;


import com.trial.service.dubbo.Robot;

/**
 * @description:JAVA SPI实现类
 * @date: 2020/10/19 11:17
 * @author: luoziwen
 */
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}
