package com.trial.HWod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-04 22:53
 **/
public class HJ39 {
    /**
     *题目描述
     * 幼儿园组织活动，老师布置了一个任务：
     * 每个小朋友去了解与自己同一个小区的小朋友还有几个。
     * 我们将这些数量汇总到数组 garden 中。
     * 请根据这些小朋友给出的信息，计算班级小朋友至少有几个？
     * 输入描述
     * 输入：garden[] = {2, 2, 3}
     * 输出描述
     * 输出：7
     * 备注
     *     garden 数组长度最大为 999
     *     每个小区的小朋友数量最多 1000 人，也就是 garden[i] 的范围为 [0, 999]
     * 用例1
     * 输入
     * 2 2 3
     *
     * 输出
     * 7
     * 说明
     *     第一个小朋友反馈有两个小朋友和自己同一小区，即此小区有3个小朋友。
     *     第二个小朋友反馈有两个小朋友和自己同一小区，即此小区有3个小朋友。
     *     这两个小朋友，可能是同一小区的，且此小区的小朋友只有3个人。
     *     第三个小区反馈还有3个小朋友与自己同一小区，则这些小朋友只能是另外一个小区的。这个小区有4个小朋友。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        int[] childes = new int[s.length];
        for(int i = 0; i < s.length; i++){
            childes[i] = Integer.valueOf(s[i]);
        }
        //先排序
        Arrays.sort(childes);
        //双指针解法
        int left = 0;
        int right = 1;
        int count = childes[left] + 1;
        int length = childes.length;
        while(right < length){
            /**
             * 如果两个小区人数相等那么可以算在一个小区，但是当下标 right - left 之差已经和childes[left]相等的时候
             * 说明这个可能在同一小区的人已经满了，那么这个right下标的值只能下另外一个小区的
             */
            if(childes[left] == childes[right] && (right-left) <= childes[left]){
                right++;
            }else{
                /**
                 * 当小区人数不同和相同但是下标之差已经和childes[left]相等的时候就必须要统计人数
                 * 然后重新初始化双指针，要记住的是这个时候的下标right的值还没有被统计，一定要加上，
                 * 并且累计的时候是没有算上自己这个人的，要+1
                 * */
                left = right;
                right = left + 1;
                if(left < length){
                    count += childes[left] + 1;
                }

            }
        }
        System.out.println(count);
    }
}
