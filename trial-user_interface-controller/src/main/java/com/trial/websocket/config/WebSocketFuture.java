package com.trial.websocket.config;

import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 回调阻塞
 * @author: Mr.Luo
 * @create: 2023-11-07 23:36
 **/
public class WebSocketFuture {

    //回调集合
    private static ConcurrentHashMap<String, WebSocketFuture> FUTURE = new ConcurrentHashMap();

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition =  lock.newCondition();

    private Object data;

    private String sessionId;

    public WebSocketFuture(String sesionId) {
        sessionId = sesionId;
        FUTURE.put(sesionId,this);
    }

    public WebSocketFuture creat(String sesionId){
        return new WebSocketFuture(sesionId);
    }
    /**
     * @description 同步请求发送消息给客户端，如果成功则调用这个类中的
     * get（）方法阻塞等待客户端的响应
     * @author Mr.Luo
     * @date 2023/11/08 01:48
     */
    public Boolean request(Session sesion, String mes) throws Exception{
        if(sesion.isOpen()){
            sesion.getBasicRemote().sendText(mes);
            return true;
        }
        return false;
    }
    /**
     * @description 当客户端响应是会调用该方法，
     * 唤醒get中的阻塞webSocketFuture对象，服务端将响应值返回前端
     * 并移除对应的对象。
     * @author Mr.Luo
     * @date 2023/11/08 01:51
     */
    public static void received(String reponse){
        WebSocketFuture future = FUTURE.remove("session");
        if(future != null){
            future.doReceived(reponse);
        }
    }
    private void doReceived(String reponse){
        lock.lock();
        try {
            this.data = reponse;
            condition.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    //同步阻塞
    private Object get(int timeout){
        long start = System.currentTimeMillis();
        if(data != null){
            lock.lock();
            try {
                while (data != null){

                    boolean await = condition.await(1000, TimeUnit.MILLISECONDS);
                    if(!await){
                        //阻塞失败
                    }
                    if(data == null &&  System.currentTimeMillis() - start > timeout){
                        break;
                    }
                }
            }catch (Exception e){
                FUTURE.remove(this.sessionId);
            }finally {
                lock.unlock();
            }
        }
        if(data == null){
            FUTURE.remove(this.sessionId);
            throw new RuntimeException();
        }
        return data;
    }

}
