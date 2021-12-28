package com.trial.mq.rocketmq.impl;

import com.trial.mq.rocketmq.RocketMqMessageEvent;
import com.trial.mq.rocketmq.consumer.ManualRocketmqConsummer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    @Autowired
    private ManualRocketmqConsummer rocketmqConsummer;

    /**
     * 功能描述:
     *
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:50
     */
    @Override
    public String rocketMqSendMessage(String topic, String message) {
        /**
         * 用此方法，交换机会马上把所有的信息都交给所有的消费者，
         * 消费者再自行处理，不会因为消费者处理慢而阻塞线程。
         * 输出时没有顺序
         * */
        rocketMQTemplate.convertAndSend(topic, message);
        /**
         * 用此方法，异步消息
         * */
        rocketMQTemplate.asyncSend(topic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("成功啦");
            }

            @Override
            public void onException(Throwable throwable) {
                //日志
                System.out.println("失败啦");
            }
        });
        return "success";
    }

    /**
     * 功能描述:发送顺序消息
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:50
     */
    @Override
    public String rocketMqSendOrderlyMessage(String topic, String message) {
        //返回选中的队列 可以直接用已经提供好的实现类
        rocketMQTemplate.setMessageQueueSelector((List<MessageQueue> mqs, Message msg, Object arg) ->{
            /**
             * mqs：要发送消息的topic下的所有消息队列集合
             * msg：发送的消息
             * arg：发送消息时传递的参数 通过该参数指定发送到哪个队列
             */
            int queueNum = Integer.valueOf(String.valueOf(arg)) % mqs.size();
            System.out.println("队列id："+ queueNum +" 消息:"+new String(msg.getBody()));
            return mqs.get(queueNum);

        });

        for(int i=1;i<=10;i++){
            String msg= message + "type:"+ i % 4 +" value:"+i;
            rocketMQTemplate.syncSendOrderly(topic,msg, String.valueOf(i));
        }
        /** 顺序消费通过hashKey来确定他们在哪个queue
         *  不使用上面的方式的话,默认rocketMQTemplate使用的是hash
         * Same to with send timeout specified in addition.
         * 支持超时时间设置。
         * @param destination formats: `topicName:tags` 就是topic
         * @param message {@link org.springframework.messaging.Message} 消息体
         * @param hashKey 顺序消费的关键，你选择queue保证消息有序的关键
         * @param sendCallback {@link SendCallback} 消息回调
         */
        rocketmqConsummer.onOrderlyMessage();
        return "success";
    }
    /**
     * 功能描述:事务消息
     * @param topic 实际上是topic:tag
     * @param message 发送的消息体
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/12/28 19:15
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public String rocketMqSendTransactionMessage(String topic, Object message) {

        org.springframework.messaging.Message<Object> messageObj = MessageBuilder.withPayload(message).build();
        String transactionId = UUID.randomUUID().toString();
        TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction(topic, messageObj,transactionId);
        System.out.println("半事务开启===" + transactionSendResult.getLocalTransactionState());
        //执行业务如：退款= 售后服务发起退款变更为退款中，rpc调用账户退款接口，开启事务消息，
        // 账户退款成功后提交完本地事务，通知退款修改状态退款成功，通知订单订单关闭
        try {
            //模拟本地业务提交
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


}
