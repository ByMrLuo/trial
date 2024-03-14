package com.trial.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @description: CyclicBarrier使用实例,多个线程等待栅栏开放
 * @author: Mr.Luo
 * @create: 2023-11-14 16:50
 **/
public class JUCDemo {

    public static void main(String[] args) throws Exception{
        /**CyclicBarrier使用实例，多个线程等待发号枪后开始*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"1号开始了");
                }catch (Exception e){

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"2号开始了");
                }catch (Exception e){

                }
            }
        }).start();
        cyclicBarrier.await();
    }
}
