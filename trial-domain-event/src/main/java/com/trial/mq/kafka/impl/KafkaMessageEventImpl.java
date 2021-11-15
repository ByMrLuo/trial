package com.trial.mq.kafka.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trial.mq.kafka.KafkaMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @description:
 * @date: 2021/11/15 18:03
 * @author: luoziwen
 */
@Component
public class KafkaMessageEventImpl implements KafkaMessageEvent {


    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;


    /**
     * 功能描述:
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:50
     */
    @Override
    public String kafkaSendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        return "success";
    }
}
