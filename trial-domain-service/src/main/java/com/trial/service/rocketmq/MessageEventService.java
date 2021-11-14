package com.trial.service.rocketmq;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/15 01:29
 */
public interface MessageEventService {

    String sendMessage(String topic , String message);
}
