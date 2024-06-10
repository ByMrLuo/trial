package com.trial.HWod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-10 23:23
 **/
public class HJ62 {
    /**
     *题目描述
     * 给定两个整数数组array1、array2，数组元素按升序排列。
     * 假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，
     * 并对取出的所有元素求和，计算和的最小值。
     * 注意：
     * 两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素。
     * 输入描述
     * 输入两行数组array1、array2，每行首个数字为数组大小size(0 < size <= 100);
     * 0 < array1[i] <= 1000
     * 0 < array2[i] <= 1000
     * 接下来一行为正整数k
     * 0 < k <= array1.size() * array2.size()
     * 输出描述
     * 满足要求的最小和
     * 用例1
     * 输入
     * 3 1 1 2
     * 3 1 2 3
     * 2
     *
     * 输出
     * 4
     * 说明
     *     用例中，需要取2对元素
     *     取第一个数组第0个元素与第二个数组第0个元素组成1对元素[1,1];
     *     取第一个数组第1个元素与第二个数组第0个元素组成1对元素[1,1];
     *     求和为1+1+1+1=4，为满足要求的最小和。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array1Num = scanner.nextInt();
        int[]  array1 = new int[array1Num];
        for (int i = 0; i < array1Num; i++) {
            array1[i] = scanner.nextInt();
        }

        int array2Num = scanner.nextInt();
        int[] array2 = new int[array2Num];
        for (int i = 0; i < array2Num; i++) {
            array2[i] = scanner.nextInt();
        }
        //前k对
        int number = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1Num; i++) {
            for (int j = 0; j < array2Num; j++) {
                list.add(array1[i] + array2[j]);
            }
        }
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
