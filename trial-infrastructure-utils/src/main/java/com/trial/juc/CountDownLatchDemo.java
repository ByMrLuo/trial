package com.trial.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @description: CountDownLatchDemo一次性的不可循环
 * @author: Mr.Luo
 * @create: 2023-11-14 17:01
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(3);

        for(int i = 0;i < 3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //阻塞当前线程
                        startSignal.await();
                        System.out.println(Thread.currentThread().getName() + "==开始干活了");
                        doneSignal.countDown();
                    }catch (Exception e){
                        //打印输出
                    }
                }
            }).start();
        }
        //发号枪，所有线程启动
        startSignal.countDown();
        //阻塞住当前主线程，等待所有线程的结果
        doneSignal.await();
    }
}
