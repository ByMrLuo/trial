package com.trial.service.test.SPI;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.ProxyFactory;
import com.trial.service.dubbo.Robot;

/**
 * @description:
 * dobboSPI 此处是在看dubbo源码是使用ExtensionLoader加在扩展内容的时候对@SPI和@Adaptive
 * @date: 2020/10/19 13:52
 * @author: luoziwen
 */
public class DubboSPI {
    /**
     * @description:
     * 说实话开始我是不理解为什么dubbo要自定义spi的，因为感觉就像rokcetmq一样，不复用jms的定语
     * 后来发现一个问题，java 的spi 有一个猫饼，就是启动的时候会加载所有的MATE-INF下的远程接口，
     * 这项目要是启动一下就要了老命了，而且你无法保证你加载的这些会全部用到，总的来说dubbo实现的
     * 这种更能体现物尽其用，不做无用功的效果。
     * @auther: luoziwen
     * @date: 2021/12/22 14:54
     */
    public static void main(String[] args) {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");

        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();

        System.out.println("======================================");

        //ExtensionLoader 源码中的核心几步
        ProxyFactory proxyFactory = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();
        URL url = URL.valueOf("dubbo://127.0.0.1:5342/" + Robot.class.getName() + "?version=1.0.0");

    }

}
