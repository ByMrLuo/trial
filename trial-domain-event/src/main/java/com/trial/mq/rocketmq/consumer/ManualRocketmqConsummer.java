package com.trial.mq.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @description:手动消费rocketmq实现,例子自己看官网
 * @date: 2021/12/28 16:21
 * @author: luoziwen
 */
//@Component("rocketmqConsummer")
public class ManualRocketmqConsummer {

    @PostConstruct
    public void onOrderlyMessage(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("tail_orderly_topic_group");
        consumer.setNamesrvAddr("121.199.164.16:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //消费端控制 消费模式集群or广播
        consumer.setMessageModel(MessageModel.BROADCASTING);
        try {
            consumer.subscribe("tail_orderly_topic","*");
            //顺序消费
            consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
                for (MessageExt msg : msgs) {
                    // 可以看到每个queue有唯一的consume线程来消费, 订单对每个queue(分区)有序
                    System.out.println("consumeThread=" + Thread.currentThread().getName() + "queueId=" + msg.getQueueId() + ", content:" + new String(msg.getBody()));
                }

                try {
                    //模拟业务逻辑处理中...
                    Random random = new Random();
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            });
            //并发消费
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    return null;
                }
            });
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能描述:事务消息
     * @param
     * @return: void
     * @auther: luoziwen
     * @date: 2021/12/28 18:50
     */
    @PostConstruct
    public void transactionMessage(){

    }
}
