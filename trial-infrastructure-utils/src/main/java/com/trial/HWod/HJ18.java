package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-28 18:40
 **/
public class HJ18 {
    /**
     * 题目描述
     * 小朋友出操，按学号从小到大排成一列；
     * 小明来迟了，请你给小明出个主意，让他尽快找到他应该排的位置。
     * 算法复杂度要求不高于nLog(n)；学号为整数类型，队列规模 ≤ 10000；
     * 输入描述
     * 第一行：输入已排成队列的小朋友的学号（正整数），以","隔开；例如：
     *     93,95,97,100,102,123,155
     * 第二行：小明学号，如：
     *     110
     *
     * 输出描述
     * 输出一个数字，代表队列位置（从1开始）。例如：
     *     6
     *
     * 用例1
     * 输入
     * 93,95,97,100,102,123,155
     * 110
     *
     * 输出
     * 6
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strArrs = s.split(",");
        int length = strArrs.length;
        int[] peoples = new int[length];
        for(int i = 0; i < length; i++){
            peoples[i] = Integer.valueOf(strArrs[i]);
        }
        String xiaoming = scanner.nextLine();
        Integer xiaomingInt = Integer.valueOf(xiaoming);
        //这里是索引的位置，题目要求的是真实的长度应该+1
        int mid = 0;
        int left = 0;
        int right = length-1;
        while(left <= right){
            mid = (left + right + 1)/2;
            //小于中间值将右边界缩小
            if(xiaomingInt <= peoples[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        /**
         * 这里解释一下为什么返回的是left，因为在数组中，
         * 只有在left=right的时候才算是确定到插入的位置
         * 这时有三种结果，但是等于的情况，你可以归结到另外两种的任意一个里面去
         * 当xiaomingInt > peoples[mid]的时候，应该移动left到mid后一个的位置，
         * 这时left = mid+1 > right ，说明他只能在在mid+1的位置，这时刚好left = mid+1；所以使用left没问题
         * 当xiaomingInt <= peoples[mid]的时候，按道理我们应该返回right的值，也就是mid-1，
         * 但是right-1后刚好满足条件left>right,我们有知道left边界的形成就是因为当left = mid的时候
         * xiaomingInt > peoples[mid],所以left = mid + 1，就算left为0的边界也是一样，所以返回left
         * */
        //mid是索引要返回长度的位置所以要+1
        System.out.println(left + 1);
    }
}
