package com.trial;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @description:
 * @date: 2020/7/15 11:22
 * @author: luoziwen
 */
public class demo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("","");
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");
        /**顺序执行任务*/
        Thread thread = new Thread();
        //单线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(thread);
        //定时任务线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> future1 = scheduledExecutorService.schedule(thread, 0, TimeUnit.MILLISECONDS);
//        scheduledExecutorService.schedule(thread,future1.get(), TimeUnit.MILLISECONDS);
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("");
        //CompletableFuture
    }
}
