package com.trial.mq.rocketmq.consumer;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @方法说明:顺序消费
 * 实际上这个注解的方式有点问题，他是自动提交的ack，如没有异常就代表消费成果，无法手动提交
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:25
 */
@Component
//@RocketMQMessageListener(topic = "tail_orderly_topic", consumerGroup = "tail_orderly_topic_group",
//                         messageModel = MessageModel.CLUSTERING,consumeMode = ConsumeMode.ORDERLY)
@RocketMQMessageListener(topic = "tail_test_orderly_topic", consumerGroup = "test-group",
                         messageModel = MessageModel.CLUSTERING,consumeMode = ConsumeMode.ORDERLY)
public class RocketMqOrderlyMessageConsumerEvent implements  RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        System.out.println(Thread.currentThread().getName() + " onMessage: " + new String(message.getBody()));
    }
}
