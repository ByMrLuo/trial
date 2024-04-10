package com.trial.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @description: CompletableFuture一个测试功能类
 * @author: Mr.Luo
 * @create: 2023-11-16 01:09
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<CompletableFuture<Integer>>  future = nums.stream().map(value -> CompletableFuture.supplyAsync(()->{

                    return value;
                }))
                .collect(Collectors.toList());

    }
}
