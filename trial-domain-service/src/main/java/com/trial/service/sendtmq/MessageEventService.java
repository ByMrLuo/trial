package com.trial.service.sendtmq;

import java.util.Map;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:29
 */
public interface MessageEventService {

   
    /**
     * 功能描述:rocketmq
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:45
     */
    String rocketMqSendMessage(String topic, String message);

    /**
     * 功能描述:kafka消息
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 17:49
     */
    String kafkaSendMessage(String topic, String message);
    /**
     * 功能描述:顺序有序消费
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/12/28 10:38
     */
    String rocketMqSendOrderlyMessage(String topic, String message);

    /**
     * 功能描述:事务消息
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/12/28 10:38
     */
    String rocketMqSendTransactionMessage(String topic, Map message);
}
