package com.trial.service.sendtmq.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trial.mq.kafka.KafkaMessageEvent;
import com.trial.mq.rocketmq.RocketMqMessageEvent;
import com.trial.service.sendtmq.MessageEventService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:29
 */
@Service
public class MessageEventServiceImpl implements MessageEventService {

    @Autowired
    private RocketMqMessageEvent rocketMqMessageEvent;

    @Autowired
    private KafkaMessageEvent kafkaMessageEvent;



    /**
     * 功能描述:rocketmq消息生产者
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:50
     */
    @Override
    public String rocketMqSendMessage(String topic, String message) {
        return rocketMqMessageEvent.rocketMqSendMessage(topic, message);
    }

    /**
     * 功能描述: kafka消息生产者
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 18:10
     */
    @Override
    public String kafkaSendMessage(String topic, String message) {
        //业务组装
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap messageMap = new HashMap<>();
        messageMap.put("id", UUID.randomUUID().toString());
        messageMap.put("sendTime",new Date());
        messageMap.put("message",message);
        String messageJson = null;
        try {
            messageJson = objectMapper.writeValueAsString(messageMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kafkaMessageEvent.kafkaSendMessage(topic,  messageJson);
    }

    /**
     * 功能描述:顺序有序消费
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/12/28 10:39
     */
    @Override
    public String rocketMqSendOrderlyMessage(String topic, String message, Long id) {
        return rocketMqMessageEvent.rocketMqSendOrderlyMessage(topic, message ,id);
    }

    /**
     * 功能描述:顺序有序消费
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/12/28 10:39
     */
    @Override
    public String rocketMqSendTransactionMessage(String topic, Map message) {
        return rocketMqMessageEvent.rocketMqSendTransactionMessage(topic, message);
    }
}
