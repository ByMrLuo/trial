package com.trial.HWod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-28 00:10
 **/
public class HJ15 {
    /**
     * 题目描述
     * 部门准备举办一场王者荣耀表演赛，有 10 名游戏爱好者参与，分为两队，每队 5 人。
     * 每位参与者都有一个评分，代表着他的游戏水平。为了表演赛尽可能精彩，我们需要把 10 名参赛者分为示例尽量相近的两队。
     * 一队的实力可以表示为这一队 5 名队员的评分总和。
     * 现在给你 10 名参与者的游戏水平评分，请你根据上述要求分队，最后输出这两组的实力差绝对值。
     * 例：10 名参赛者的评分分别为：5 1 8 3 4 6 7 10 9 2，分组为（1 3 5 8 10）和（2 4 6 7 9），两组实力差最小，差值为1。有多种分法，但是实力差的绝对值最小为1。
     *
     * 输入描述
     * 10个整数，表示10名参与者的游戏水平评分。范围在 [1, 10000] 之间。
     *
     * 输出描述
     * 1个整数，表示分组后两组实力差绝对值的最小值。
     * 用例1
     * 输入
     * 1 2 3 4 5 6 7 8 9 10
     *
     * 输出
     * 1
     * 说明
     *     10名队员分为两组，两组实力差绝对值最小为1
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] peoples = new int[10];
        int sum = 0;
        for(int i = 0; i < 10; i++){
            peoples[i]= scanner.nextInt();
            sum += peoples[i];
        }
        Arrays.sort(peoples);
        //已知五个值和他们的和直接用最终的综合减去就是另一队的，然后求绝对值
        int aCount = 0;
        int bCount = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++){
            //如果前一个和后一个元素分数一样，
            // 那么前一个所有的可能一定包含了后一个所有的可能，就是重复了，所以没必要再继续重复遍历
            if(i > 0 && peoples[i] == peoples[i-1]){
                continue;
            }
            for(int j = i+1; j < 7; j++){
                if(j > i+1 && peoples[j] == peoples[j-1]){
                    continue;
                }
                for(int k = j+1; k < 8; k++){
                    if(k > j+1 && peoples[k] == peoples[k-1]){
                        continue;
                    }
                    for(int l = k+1; l < 9; l++){
                        if(l > k+1 && peoples[l] == peoples[l-1]){
                            continue;
                        }
                        for (int m = l+1; m < 10; m++){
                            if(m > l+1 &&peoples[m] == peoples[m-1]){
                                continue;
                            }
                            aCount = peoples[i] + peoples[j] + peoples[k] + peoples[l] + peoples[m];
                            bCount = sum - aCount;
                            min = Math.min(min , Math.abs(aCount - bCount));
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}
