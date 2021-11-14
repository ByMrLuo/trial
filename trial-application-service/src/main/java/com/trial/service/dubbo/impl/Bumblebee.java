package com.trial.service.dubbo.impl;

import com.trial.service.dubbo.Robot;

/**
 * @description:
 * @date: 2020/10/19 11:19
 * @author: luoziwen
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
