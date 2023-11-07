package com.trial.websocket;

import com.trial.websocket.config.WebSocketFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.Map;

/**
 * @description:
 * websocket通信接口
 * @author: Mr.Luo
 * @create: 2023-11-07 16:13
 **/
/**
 * 使用@ServerEndpoint注解（该注解由java提供）监听一个WebSocket请求路径，这
 * 里监听了客户端的连接端口/reverse，并定义了如何处理客户端发来的消息。
 */
@ServerEndpoint("/reverse")
public class ReverseWebSocketEndpoint {

    @Autowired
    private WebSocketRequestMappingResolver webSocketRequestMappingResolver;

    @OnOpen
    public void onOpen(Session session) throws Exception{
    //    WebSocketContextion webSocketContextion =   session.getUserProperties().get("webSocketContextion");
    //
        switch ("状态"){
            case "注册":
                if(true/**是否被绑定*/){
                    sendMessage(session,"result");
                    session.getUserProperties().put("注册失败",true);
                    //return new HttpResponseDto(false);
                }

                if(true/**是否被绑定*/){
                    sendMessage(session,"result");
                    session.getUserProperties().put("注册失败",true);
                    //return new HttpResponseDto(false);
                }
                //获取唯一码对应岗亭

                if(true/**不为空*/){
                    //将停车场的信息放入

                }
                //判定注册信息是不是存在的链接
                if(true){

                }
                //绑定注册将唯一码和设备indexcode绑定

                //将停车场id发给岗亭
                sendMessage(session,"result");

            case "重连":

            case "离线":


        }
    }
    /**
     * @description :将消息写回
     * @author Mr.Luo
     * @date 2023/11/07 23:59
     */
    private void sendMessage(Session session, String result) throws Exception{
        synchronized (session){
            session.getBasicRemote().sendText("");
        }
    }
    /**
     * @description :发送消息
     * @author Mr.Luo
     * @date 2023/11/08 00:26
     */
    @OnMessage
    public void onMessage(String message, Session session) throws Exception{
         //使用线程池进行判定
            //判断类型
            switch ("相应类型"){
                case "接受岗亭请求":
                    request(message, session);
                    break;
                case "等待岗亭响应":
                    //将字符串转换为对象
                    response(message, session);
                    WebSocketFuture.received(session.getId());
                    break;
                case "不明类型":
                    //啥都不干

                    break;
            }
    }

    private void request(String message, Session session)throws Exception{
        //创建响应体和请求体对象
        //switch逻辑
        switch ("岗亭请求咱们类型"){
            case "业务操作":
                try {
                    String host = (String)session.getUserProperties().get("host");
                    //构建请求必须得类型参数
                    webSocketRequestMappingResolver.excute();
                }catch (Exception e){

                }
                break;
        }
        sendMessage(session, "result");
    }

    private void response(String message, Session session){

    }
    @OnClose
    public void onClose(Session session) {
        System.out.println("Client disconnected");
    }
}
