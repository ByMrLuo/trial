package com.trial.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description: CountDownLatchDemo的第二种场景
 * @author: Mr.Luo
 * @create: 2023-11-14 17:25
 **/
public class CountDownLatchDemo2 {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Executor executor = Executors.newScheduledThreadPool(5);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //开始做任务
                countDownLatch.countDown();

            }
        });
        //阻塞当前线程
        countDownLatch.await();
        //返回结果
    }

}
