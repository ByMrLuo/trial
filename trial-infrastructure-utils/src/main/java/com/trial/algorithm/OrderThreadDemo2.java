package com.trial.algorithm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 线程按照顺序打印1-100样例
 * @author: Mr.Luo
 * @create: 2023-11-14 18:08
 **/
public class OrderThreadDemo2 {

    private static final ReentrantLock lock = new ReentrantLock();

    private static volatile int MAX = 0;

    public static void main(String[] args) {
        new Thread(new OrderThread(0)).start();
        new Thread(new OrderThread(1)).start();
        new Thread(new OrderThread(2)).start();
    }

    static class OrderThread implements Runnable{

        private Integer index;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        OrderThread (Integer index){
            this.index = index;
        }

        @Override
        public void run() {
            for (;;){
                try {
                    lock.lock();
                    if(MAX % 3 != index){
                        lock.notifyAll();
                        lock.wait();
                    }else{
                        System.out.println("线程" + index + "号打印数字：" + MAX);
                    }
                    MAX++;
                }catch (Exception e){

                }finally {
                    lock.unlock();

                }
            }
        }
    }
}
