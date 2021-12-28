package com.trial.mq.rocketmq;

/**
 * @方法说明: 事件驱动
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:27
 */
public interface RocketMqMessageEvent {
    /**
     * 功能描述:
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 18:08
     */
    public String rocketMqSendMessage(String topic, String message);


    /**
     * 功能描述: 顺序消费
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 18:08
     */
    public String rocketMqSendOrderlyMessage(String topic, String message);

    /**
     * 功能描述: 事务消息
     * @param topic
     * @param message
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2021/11/15 18:08
     */
    public String rocketMqSendTransactionMessage(String topic, Object message);

}
