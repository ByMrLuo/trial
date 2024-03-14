package com.trial.mq.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @description: 生产者在发送完半消息后，如果成功则会进入到这个类中进行本地事务提交
 * 如果提交成功，则事务消息会被消费者正式接收到，如果失败则需要回滚，半消息也就不会再发送给消费者
 * @date: 2021/12/28 19:43
 * @date: 2024/3/14 19:43
 * @author: luoziwen
 */
@Component
@RocketMQTransactionListener
public class RocketMqHalfTransactionConsumer implements RocketMQLocalTransactionListener {
    /**
     * @description 在正确发送事务半消息后会进入到这里执行生产者的本地事务提交
     * @author Mr.Luo
     * @date 2024/03/14 18:23
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        //执行业务如：退款= 售后服务发起退款变更为退款中，rpc调用账户退款接口，开启事务消息，
        // 账户退款成功后提交完本地事务，通知退款修改状态退款成功，通知订单订单关闭
        /**~~~开始执行二阶段事务~~*/
        RocketMQLocalTransactionState result = RocketMQLocalTransactionState.COMMIT;
        try {
            //加装处理本地事务
            String jsonString = new String((byte[]) msg.getPayload(), StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(jsonString, Map.class);
            String uuid = (String) arg;
            System.out.println("map=========" + map);
            System.out.println("uuid=========" + uuid);
        } catch (Exception e) {
            System.out.println("======executeLocalTransaction异常回滚========");
            result = RocketMQLocalTransactionState.UNKNOWN;
        }
        result = RocketMQLocalTransactionState.UNKNOWN;
        return result;
    }
    /**
     * @description 当本地事务一直没有相应的时候会被调用该方法检查该对应的本地事务是否已经成功
     * 成功则将消息转化为正式的消息，否则回滚
     * @author Mr.Luo
     * @date 2024/03/14 18:23
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        // 检查本地事务
        RocketMQLocalTransactionState result = RocketMQLocalTransactionState.COMMIT;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("=========checkLocalTransaction=========");
            System.out.println("msg===" + objectMapper.writeValueAsString(msg.getPayload()));
            System.out.println("msg===" + msg.getHeaders());
            String jsonString = new String((byte[]) msg.getPayload(), StandardCharsets.UTF_8);
            Map map = objectMapper.readValue(jsonString, Map.class);
            System.out.println(map);
        } catch (Exception e) {
            // 异常就回滚
            System.out.println("======checkLocalTransaction异常回滚========");
            result =  RocketMQLocalTransactionState.ROLLBACK;
        }
        result =  RocketMQLocalTransactionState.ROLLBACK;
        return result;
    }
}
