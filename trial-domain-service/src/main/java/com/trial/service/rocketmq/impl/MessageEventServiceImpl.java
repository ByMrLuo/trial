package com.trial.service.rocketmq.impl;

import com.trial.service.rocketmq.MessageEventService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:29
 */
@Service
public class MessageEventServiceImpl implements MessageEventService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * @description:
     * @param topic
     * @param message
     * @return java.lang.String
     * @author Mr.Luo
     * @date 2021/11/15 3:06
     */
    @Override
    public String sendMessage(String topic , String message){
        rocketMQTemplate.convertAndSend("tail_test_topic", "我来了我来了");
        return "success";
    }
}
