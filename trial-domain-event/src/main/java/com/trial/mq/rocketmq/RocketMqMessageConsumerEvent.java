package com.trial.mq.rocketmq;

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
@RocketMQMessageListener(consumerGroup = "test-group", topic = "tail_test_topic")
public class RocketMqMessageConsumerEvent implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("正常消费消息====" + s);
    }


}
