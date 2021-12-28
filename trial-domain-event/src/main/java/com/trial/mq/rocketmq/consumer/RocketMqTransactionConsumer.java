package com.trial.mq.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @description: 事务消息接收
 * @author: Mr.Luo
 * @create: 2021-12-29 01:21
 **/
@Component
@RocketMQMessageListener(topic = "tail_transaction_topic", consumerGroup = "tail_transaction_topic_group",
        messageModel = MessageModel.CLUSTERING,consumeMode = ConsumeMode.ORDERLY)
public class RocketMqTransactionConsumer  implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("=======事务消息接收完毕===" + message);
    }
}
