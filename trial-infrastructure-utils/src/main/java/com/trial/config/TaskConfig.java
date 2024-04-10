package com.trial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @description: 动态定时任务调度
 * @author: Mr.Luo
 * @create: 2023-11-13 15:57
 **/
public class TaskConfig {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private static ConcurrentHashMap<String, ScheduledFuture> taskMap = new ConcurrentHashMap();

    public void creatTask(){
        TaskRunner taskRunner = new TaskRunner();
        CronTrigger cronTrigger = new CronTrigger("");
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(taskRunner, cronTrigger);
        taskMap.put("corn", schedule);
    }
}
