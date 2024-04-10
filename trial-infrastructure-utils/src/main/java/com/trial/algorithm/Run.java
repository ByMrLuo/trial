package com.trial.algorithm;

import java.util.concurrent.CyclicBarrier;

/**
 * @description: 赛跑
 * @author: Mr.Luo
 * @create: 2023-11-10 18:29
 **/
public class Run implements Runnable{

    private String name;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(6);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();

        }catch (Exception e){

        }

    }


}
