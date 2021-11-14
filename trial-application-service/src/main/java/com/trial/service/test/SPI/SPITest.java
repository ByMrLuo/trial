package com.trial.service.test.SPI;

import com.trial.service.dubbo.Robot;

import java.util.ServiceLoader;

/**
 * @description:SPI运行测试
 * @date: 2020/10/19 11:37
 * @author: luoziwen
 */
public class SPITest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
