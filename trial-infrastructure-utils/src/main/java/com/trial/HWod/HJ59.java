package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-10 16:58
 **/
public class HJ59 {
    /**
     * 题目描述
     * 为了充分发挥GPU算力，需要尽可能多的将任务交给GPU执行，现在有一个任务数组，数组元素表示在这1秒内新增的任务个数且每秒都有新增任务。
     * 假设GPU最多一次执行n个任务，一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多长时间执行完成。
     * 输入描述
     * 第一个参数为GPU一次最多执行的任务个数，取值范围[1, 10000]
     * 第二个参数为任务数组长度，取值范围[1, 10000]
     * 第三个参数为任务数组，数字范围[1, 10000]
     * 输出描述
     * 执行完所有任务最少需要多少秒。
     * 用例1
     * 输入
     * 3
     * 5
     * 1 2 3 4 5
     *
     * 输出
     * 6
     * 说明
     *     一次最多执行3个任务，最少耗时6s
     *
     * 用例2
     * 输入
     * 4
     * 5
     * 5 4 1 1 1
     * 输出
     * 5
     * 说明
     *     一次最多执行4个任务，最少耗时5s
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //一次最多执行任务
        int maxUse = scanner.nextInt();
        //任务数组的长度
        int number = scanner.nextInt();

        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArrs = str.split(" ");
        int[] numArrs = new int[number];
        for (int i = 0; i < number; i++) {
            numArrs[i] = Integer.valueOf(strArrs[i]);
        }
        //最少耗时
        int useMin = 0;
        int left = 1;
        int count = numArrs[0];
        while(true){
            if(count <= 0 && left == number){
                break;
            }
            if(left < number){
                //每次小于0的时候直接归零，大于0的时候要进行累计
                count = count - maxUse < 0 ? 0 : count - maxUse;
                count += numArrs[left];
                left++;
            }else{
                count -= maxUse;
            }
            useMin++;

        }
        System.out.println(useMin);
    }


}
