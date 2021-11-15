package com.trial.mq.kafka;

/**
 * @description:
 * @date: 2021/11/15 18:03
 * @author: luoziwen
 */
public interface KafkaMessageEvent {

    public String kafkaSendMessage(String topic, String message);
}
