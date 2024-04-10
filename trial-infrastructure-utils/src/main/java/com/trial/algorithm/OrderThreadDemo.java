package com.trial.algorithm;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 线程顺序打印1-100
 * @author: Mr.Luo
 * @create: 2023-11-10 17:20
 **/
public class OrderThreadDemo {

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();

    private static final Semaphore semaphore = new Semaphore(1);

    private static final Object objLock = new Object();

    private static int sum = 0;


    public static void main(String[] args) throws Exception{
        TaskDemo thread1 = new TaskDemo();
        thread1.setName("A");
        thread1.setIndex(0);

        TaskDemo thread2 = new TaskDemo();
        thread2.setName("B");
        thread2.setIndex(1);

        TaskDemo thread3 = new TaskDemo();
        thread3.setName("C");
        thread3.setIndex(2);

        thread1.start();
        thread2.start();
        thread3.start();


    }

    static class TaskDemo extends Thread{
        private Integer index;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
        /**
         * @description 基于锁的实现
         * @author Mr.Luo
         * @date 2023/12/04 01:16
         */
//        @Override
//        public void run(){
//
//            synchronized(objLock){
//                try {
//                    while(sum < 100){
//                        if(sum % 3 != index){
//                            objLock.wait();
//                        }else {
//                            System.out.println("name = " + Thread.currentThread().getName() + "当前值 = " + sum);
//                            sum++;
//                        }
//                        if(sum >= 100){
//                            break;
//                        }
//                        objLock.notifyAll();
//                    }
//                }catch (Exception e ){
//
//                }
//            }
//
//        }
        /**
         * @description 基于Condition实现
         * @author Mr.Luo
         * @date 2023/12/04 01:22
         */
//        @Override
//        public void run() {
//            try {
//                while(sum < 100){
//                    lock.lock();
//                    if(sum %3 != index){
//                        condition.await();
//                    }else{
//                        System.out.println("name = " + Thread.currentThread().getName() + "当前值 = " + sum);
//                        sum++;
//                    }
//                    condition.signalAll();
//                }
//            }catch (Exception e){
//
//            }finally {
//                lock.unlock();
//            }
//
//        }
        /**
         * @description 基于 semaphore实现
         * @author Mr.Luo
         * @date 2023/12/04 01:24
         */
        @Override
        public void run() {
            try {
                while (sum < 100){
                    semaphore.acquire();
                    if(sum % 3 != index){
                        semaphore.release();
                    }else{
                        System.out.println("name = " + Thread.currentThread().getName() + "当前值 = " + sum);
                        sum++;
                    }
                    semaphore.release();
                }
            }catch (Exception e){

            }

        }
    }

    static class TaskDemo2 extends Thread{

        private Integer a;

        private static final int num = 3;

        @Override
        public void run(){
            try {
                lock.lock();
                if(a % 3 == 0){
                    condition.await();
                    System.out.println(this.getName());
                }else {
                    System.out.println(this.getName());
                    condition.signalAll();
                }
            }catch (Exception e){

            }finally {
                lock.unlock();
            }

        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

    }



}
