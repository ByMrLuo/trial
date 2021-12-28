package com.trial.controller.rocketmq;

import com.trial.service.sendtmq.MessageEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


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
        return messageEventService.rocketMqSendMessage("tail_test_topic:test-group", "rocketmq,我来了");
    }


    @GetMapping(value = "/kafka/sendMessage")
    public String kafkaSendMessage() throws Exception{

        return messageEventService.kafkaSendMessage("tail_test_topic", "kafka, 我来了");
    }

    @GetMapping("/rocketmq/sendOrderlyMessage")
    public String rocketMqSendOrderlyMessage(){
        return messageEventService.rocketMqSendOrderlyMessage("tail_orderly_topic:tail_orderly_topic_group", "rocketmq,有序消息测试中");
//        return messageEventService.rocketMqSendOrderlyMessage("tail_test_orderly_topic:test-group", "rocketmq,有序消息我来了");
    }

    @GetMapping("/rocketmq/sendOrderlyMessage")
    public String rocketMqSendTransactionMessage(){
        HashMap<String, String> message = new HashMap<>();
        message.put("status", "success");
        message.put("orderId", "23114131321432131421");
        return messageEventService.rocketMqSendTransactionMessage("tail_transaction_topic:tail_transaction_topic_group", message);
//        return messageEventService.rocketMqSendOrderlyMessage("tail_test_orderly_topic:test-group", "rocketmq,有序消息我来了");
    }

}
