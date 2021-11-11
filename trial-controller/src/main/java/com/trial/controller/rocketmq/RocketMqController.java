package com.trial.controller.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @方法说明: rocketmq
 * @Description: 中文官方文档
 * https://github.com/apache/rocketmq/tree/master/docs/cn
 * @Auther: Mr.Luo
 * @Date: 2021/11/11 22:39
 */
@RestController
@RequestMapping("/rocketmq")
public class RocketMqController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendMessage")
    public String sendMessage(){

        rocketMQTemplate.convertAndSend("tail__test_topic", "ahahahhahh");
        return "Succsee";
    }


}
