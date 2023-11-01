package com.trial.service.start;

import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

/**
 * @description:
 * springboot项目启动后需要加在的信息放在这里，
 * 一些需要提前加在的配置，可在项目启动时放在此处
 * order按照value顺序启动，此处不使用改项内容
 * @date: 2021/12/22 14:25
 * @author: luoziwen
 */
@Component
//@Order
public class StartInit implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //加载预加载的内容
    }
}
