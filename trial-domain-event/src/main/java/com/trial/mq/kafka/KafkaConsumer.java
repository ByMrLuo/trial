package com.trial.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/12 01:47
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void onMessage(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            String msg = (String)optional.get();
            System.out.println(msg);
        }
    }
}
