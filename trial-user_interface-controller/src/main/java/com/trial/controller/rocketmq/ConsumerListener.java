package com.trial.controller.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @方法说明: mq消费者
 * @Description:
 * 他的消费并不是同一个group下相同的topic是轮训接受消息而是随机的，
 * 不可预测的，可以创建按两个监听类一试便知
 * @Auther: Mr.Luo
 * @Date: 2021/11/11 22:55
 */
@Component
@RocketMQMessageListener(consumerGroup = "test-group", topic = "tail_test_topic")
public class ConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("正常消费消息====" + s);
    }
}
