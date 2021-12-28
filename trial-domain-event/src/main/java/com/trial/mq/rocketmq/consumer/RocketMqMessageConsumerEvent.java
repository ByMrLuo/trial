package com.trial.mq.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:25
 */
@Component
@RocketMQMessageListener(topic = "tail_test_topic", consumerGroup = "test-group")
public class RocketMqMessageConsumerEvent implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("普通消费消息====" + s);
    }


}
