package com.trial.controller.rocketmq;

import com.trial.service.rocketmq.MessageEventService;
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
    private MessageEventService messageEventService;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageEventService.sendMessage("tail_test_topic", "我来了我来了");
    }


}
