package com.trial.controller.rocketmq;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trial.object.pojo.Order;
import com.trial.service.sendtmq.MessageEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @方法说明: sendtmq
 * @Description: 中文官方文档
 * https://github.com/apache/rocketmq/tree/master/docs/cn
 * @Auther: Mr.Luo
 * @Date: 2021/11/11 22:39
 */
@RestController
@RequestMapping("/sendMQ")
public class RocketMqController {

    @Autowired
    private MessageEventService messageEventService;

    @GetMapping("/rocketmq/sendMessage")
    public String rocketMqSendMessage(){
        return messageEventService.rocketMqSendMessage("tail_test_topic:test-group", "rocketmq,我来了");
    }

    /**
     * @description
     * @author Mr.Luo
     * @date 2021/12/05 20:05
     */
    @GetMapping(value = "/kafka/sendMessage")
    public String kafkaSendMessage() throws Exception{

        return messageEventService.kafkaSendMessage("tail_test_topic", "kafka, 我来了");
    }

    @GetMapping("/rocketmq/sendOrderlyMessage")
    public String rocketMqSendOrderlyMessage(){
        //模拟接收到的消息
        ArrayList<Order> orderList = new ArrayList<>();
        Order order0 = new Order(11111L, "创建订单", 3);
        Order order3 = new Order(22222L, "创建订单", 6);
        Order order1 = new Order(11111L, "订单支付", 3);
        Order order4 = new Order(22222L, "订单支付", 6);
        Order order5 = new Order(22222L, "订单完成", 6);
        Order order2 = new Order(11111L, "订单完成", 3);
        orderList.add(order0);
        orderList.add(order1);
        orderList.add(order2);

        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.forEach(order ->
                messageEventService.rocketMqSendOrderlyMessage("tail_orderly_topic_test", order.toString(),order.getOrderId())
        );
//        return messageEventService.rocketMqSendOrderlyMessage("tail_test_orderly_topic:test-group", "rocketmq,有序消息我来了");
        return "success";
    }

    @GetMapping("/rocketmq/sendTransactionMessage")
    public String rocketMqSendTransactionMessage(){
        HashMap<String, String> message = new HashMap<>();
        message.put("status", "success");
        message.put("orderId", "23114131321432131421");
        return messageEventService.rocketMqSendTransactionMessage("tail_transaction_topic:tail_transaction_topic_group", message);
//        return messageEventService.rocketMqSendOrderlyMessage("tail_test_orderly_topic:test-group", "rocketmq,有序消息我来了");
    }

}
