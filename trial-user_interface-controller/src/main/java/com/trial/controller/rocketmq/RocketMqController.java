package com.trial.controller.rocketmq;

import com.trial.service.sendtmq.MessageEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @方法说明: sendtmq
 * @Description: 中文官方文档
 * https://github.com/apache/rocketmq/tree/master/docs/cn
 * @Auther: Mr.Luo
 * @Date: 2021/11/11 22:39
 */
@RestController
@RequestMapping("/sendMQ")
public class RocketMqController {

    @Autowired
    private MessageEventService messageEventService;

    @GetMapping("/rocketmq/sendMessage")
    public String rocketMqSendMessage(){
        return messageEventService.rocketMqSendMessage("tail_test_topic", "rocketmq,我来了");
    }


    @GetMapping(value = "/kafka/sendMessage")
    public String kafkaSendMessage() throws Exception{

        return messageEventService.kafkaSendMessage("tail_test_topic", "kafka, 我来了");
    }


}
