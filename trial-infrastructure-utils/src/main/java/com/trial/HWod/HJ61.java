package com.trial.HWod;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-10 18:19
 **/
public class HJ61 {
    /**
     * 题目描述
     * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
     * 说明：
     *     数组中数字范围[0, 1000]
     *     最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
     *     输入非法返回-1
     * 输入描述
     *     第一行输入M， M标识数组大小
     *     第二行输入M个数，标识数组内容
     *     第三行输入N，N表达需要计算的最大、最小N个数
     * 输出描述
     * 输出最大N个数与最小N个数的和
     * 用例1
     * 输入
     * 5
     * 95 88 83 64 100
     * 2
     *
     * 输出
     * 342
     *
     * 说明
     *     最大2个数[100,95],最小2个数[83,64], 输出为342。
     *
     * 用例2
     * 输入
     * 5
     * 3 2 3 4 2
     * 2
     *
     * 输出
     * -1
     *
     * 说明
     *     最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        TreeSet<Integer> numSet = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            int num = scanner.nextInt();
            if(num < 0 || num > 1000){
                System.out.println(-1);
                return;
            }
            numSet.add(num);
        }
        int n = scanner.nextInt();
        //如果n的2倍超过了去重后的长度说明会有重叠
        if(n < 0 || n * 2 > numSet.size()){
            System.out.println(-1);
            return;
        }
        int maxSum = 0;
        int minSum = 0;
        int size = numSet.size();
        for (int i = 0; i < size; i++) {
            if(n == 0){
               break;
            }
            minSum += numSet.pollFirst();
            maxSum += numSet.pollLast();
            n--;
        }
        System.out.println(maxSum + minSum);
        int m =0;
        for (int i = 0; i < 200; i++) {
            m+=i;
        }
        System.out.println(m);
    }

}
