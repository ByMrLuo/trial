package com.trial.controller.websocket;

import com.trial.websocket.config.WebSocketFuture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @description: websocket相关样例接口
 * @author: Mr.Luo
 * @create: 2023-11-16 22:14
 **/
@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    @RequestMapping("/demo")
    public Object demo()throws Exception{
        WebSocketFuture webSocketFuture = new WebSocketFuture("");
        //这是个假的
        //本地存放一份index获取session，redis中存放客户indexcode = pms服务的indexcode
        synchronized ("session"){
            Boolean webSocketFutureRequest = WebSocketFuture.request(null, "null是因为没有session");
        }
        //阻塞住等待
        Object o = webSocketFuture.get(10);
        return null;
    }


}
