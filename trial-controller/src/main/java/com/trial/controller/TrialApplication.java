package com.trial.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @date: 2020/7/14 18:05
 * @author: luoziwen
 */
@SpringBootApplication(scanBasePackages={"com.trial.*"})
@MapperScan("com.trial.mapper")
public class TrialApplication {

    public static void main(String[] args) {
            SpringApplication.run(TrialApplication.class);
    }
}
