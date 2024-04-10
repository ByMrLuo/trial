package com.trial.juc;

import java.util.concurrent.CompletableFuture;

/**
 * @description:CompletableFuture的示例
 * @author: Mr.Luo
 * @create: 2023-12-04 00:18
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) {
        //获取返回值
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(()->{
                                                        System.out.println("当前线程" + Thread.currentThread().getId());

                                                        return 12;
                                                    });
        CompletableFuture<Object> completableFuture2 = completableFuture.handle((result, exception)->{
            if(exception != null ){
                return 0;
            }
            System.out.println(result);
            return result;
        });

        /**
         * thenApplyXXX 能接收上一次的执行结果，又可以有返回值
         * .thenApplyAsync(res -> {
         *      System.out.println("任务2启动了..." + res);
         *      return "hello " + res;
         *  }, executor);
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->         {
            System.out.println("当前线程" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("运行结果：" + i);
            return i;
        }).thenApplyAsync(res -> {
            System.out.println("任务2启动了..." + res);
            return "hello " + res;
        });


    }
}
