package com.trial.mq.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
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

        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费，如果非第一次启动，那么按照上次消费的位置继续消费。
         * 消息积压之前使用过的两种方式：
         * 1.rocketmq是以group为消费单位，上线一个新的group，然后增加对应的consumerqueue数量，
         * setConsumeFromWhere设置为ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET
         * 这个是保证新来的消息能够及时消费，不会产生旧的消息无法消费，新的消息也被堆积
         *
         * 2.停掉其他的消费的consumer，上线一个中转topic，该topic没有任何逻辑操作，只是将消息积压的topic中的消息重新转发
         * 到新的topic，这样没有逻辑操作消费速度会更快，而新的topic新的consumer queue 的数量翻倍，消费者数量也翻倍，
         * 然后去处理中转的这些积压消息
         *
         */
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
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
