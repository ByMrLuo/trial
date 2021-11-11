package com.trial.service.test.SPI;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.trial.service.dubbo.Robot;

/**
 * @description: dobboSPI
 * @date: 2020/10/19 13:52
 * @author: luoziwen
 */
public class DubboSPI {

    public static void main(String[] args) {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }

}
