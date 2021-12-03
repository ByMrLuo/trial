package com.trial.controller.index;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: 服务测试页
 * @date: 2020/7/14 18:59
 * @author: luoziwen
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String index(){
        return "hello world!";
    }
}
