package com.trial.mq.rocketmq.impl;

import com.trial.mq.rocketmq.RocketMqMessageEvent;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @方法说明:rocket
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:11
 */
@Component
public class RocketMqMessageEventImpl implements RocketMqMessageEvent {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 功能描述:
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:50
     */
    @Override
    public String rocketMqSendMessage(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
        return "success";
    }
}
