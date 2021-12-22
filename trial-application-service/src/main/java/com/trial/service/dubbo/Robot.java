package com.trial.service.dubbo;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @description: JAVA SPI测试
 * @date: 2020/10/19 11:17
 * @author: luoziwen
 */
@SPI("bumblebee")
public interface Robot {

    void sayHello();

    @Adaptive
    void sayHello(URL url);
}
