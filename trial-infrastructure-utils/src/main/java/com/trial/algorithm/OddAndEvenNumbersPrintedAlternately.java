package com.trial.algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:多线程奇偶数交替打印
 * @date: 2022/2/17 15:10
 * @author: luoziwen
 */
public class OddAndEvenNumbersPrintedAlternately {

    private static final Lock lock = new ReentrantLock();
    //阻塞奇数
    private static final Condition odd = lock.newCondition();
    //阻塞偶数
    private static final Condition event = lock.newCondition();

    private static volatile int sum = 0;


    public static void main(String[] args) {

        Odd odd = new Odd();
        Event event = new Event();
        odd.start();
        event.start();

    }
    /**
     * 功能描述:奇数
     * @return:
     * @auther: luoziwen
     * @date: 2022/2/17 15:24
     */
    static class Odd extends Thread{

        @Override
        public void run() {
            try {
                lock.lock();
                while (sum <= 21){
                    if(sum % 2 == 0){
                        event.signal();
                        if(sum < 20){
                            odd.await();
                        }
                    }
                    if(sum > 20){
                        break;
                    }
                    System.out.println("打印的奇数是：" + sum);
                    sum++;
                }
            }catch (Exception e ){
                lock.unlock();
            }


        }
    }

    /**
     * 功能描述:偶数
     * @return:
     * @auther: luoziwen
     * @date: 2022/2/17 15:24
     */
    static class Event extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                while (sum <= 21){
                    if(sum % 2 != 0){
                        odd.signal();
                        if(sum < 20){
                            event.await();
                        }
                    }
                    System.out.println("打印的偶数是：" + sum);
                    if(sum > 20){
                        break;
                    }
                    sum++;
                }
            }catch (Exception e ){
                lock.unlock();
            }
        }
    }
}
