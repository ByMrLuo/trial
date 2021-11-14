package com.trial.controller.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/12 00:13
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap message = new HashMap<>();
        message.put("id", UUID.randomUUID().toString());
        message.put("sendTime",new Date());
        message.put("message", "kafka,我来啦");
        kafkaTemplate.send("test", objectMapper.writeValueAsString(message));
        return "Success";
    }



}
