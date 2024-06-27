package com.trial.HWod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-26 15:25
 **/
public class HJH79 {
    /**
     *中秋节，公司分月饼，m 个员工，买了 n 个月饼，m ≤ n，每个员工至少分 1 个月饼，但可以分多个，
     *     单人分到最多月饼的个数是 Max1 ，单人分到第二多月饼个数是 Max2 ，Max1 - Max2 ≤ 3 ，
     *     单人分到第 n - 1 多月饼个数是 Max(n-1)，单人分到第n多月饼个数是 Max(n) ，Max(n-1) – Max(n) ≤ 3,
     * 问有多少种分月饼的方法？
     * 输入描述
     * 每一行输入m n，表示m个员工，n个月饼，m ≤ n
     * 输出描述
     * 输出有多少种月饼分法
     * 用例1
     * 输入
     * 2 4
     * 输出
     * 2
     * 说明
     *     分法有2种:
     *         4 = 1 + 3
     *         4 = 2 + 2
     *     注意：1+3和3+1算一种分法
     * 用例2
     * 输入
     * 3 5
     *
     * 输出
     * 2
     *
     * 说明
     *     5 = 1 + 1 + 3
     *     5 = 1 + 2 + 2
     *
     * 用例3
     * 输入
     * 3 12
     *
     * 输出
     * 6
     * 说明
     *     满足要求的有6种分法：
     *         12 = 1 + 1 + 10（Max1 = 10, Max2 = 1，不满足Max1 - Max2 ≤ 3要求）
     *         12 = 1 + 2 + 9（Max1 = 9, Max2 = 2，不满足Max1 - Max2 ≤ 3要求）
     *         12 = 1 + 3 + 8（Max1 = 8, Max2 = 3，不满足Max1 - Max2 ≤ 3要求）
     *         12 = 1 + 4 + 7（Max1 = 7, Max2 = 4，Max3 = 1，满足要求）
     *         12 = 1 + 5 + 6（Max1 = 6, Max2 = 5，Max3 = 1，不满足要求）
     *         12 = 2 + 2 + 8（Max1 = 8, Max2 = 2，不满足要求）
     *         12 = 2 + 3 + 7（Max1 = 7, Max2 = 3，不满足要求）
     *         12 = 2 + 4 + 6（Max1 = 6, Max2 = 4，Max3 = 2，满足要求）
     *         12 = 2 + 5 + 5（Max1 = 5, Max2 = 2，满足要求）
     *         12 = 3 + 3 + 6（Max1 = 6, Max2 = 3，满足要求）
     *         12 = 3 + 4 + 5（Max1 = 5, Max2 = 4，Max3 = 3，满足要求）
     *         12 = 4 + 4 + 4（Max1 = 4，满足要求）
     * */
    static int m;
    static int n;
    /**统计人数*/
    static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //人数
        m = scanner.nextInt();
        //月饼数
        n = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        /***
         * 因为每个值必须要比前一个值大0~3，所以，a1的范围必然在1-n/m之间，否则
         * 前n的和必然会大于n,也就是说后面必然会有不符合 0<=Max(n-1) - Max(n) <= 3
         * 我们要保证员工之间的月饼个数保证升序才不会出现重复的方案，即避免元素排序后整体方案相同，
         * 只是排序前的员工不同
         */
        int a1 = n / m;
        if(m == 1){
            System.out.println(1);
        }else{
            count(n, 0, 1, a1);
        }
        System.out.println(count);
    }

    /**
     *
     * @param remain 剩余的月饼数量
     * @param num 员工编号
     * @param min 最小值
     * @param max 最大值
     */
    private static void count (int remain, int num ,int min, int max){
        //员工编号从0~m-1,当员工位m-1的时候剩余的所有月饼都是他的
        if(num == m - 1){
            /**
             * 剩余月饼数 减去 倒数第二个人拿到的数量min 如果<=3说明是合理的分配方案,
             * 如果最后一个值不符合 >3说明这个方案不可行，不能统计
             * */
            if(remain - min <= 3){
                count++;
            }
            return;
        }
        for (int i = min; i <= max; i++) {
            //减去当前人员分的月饼数
            remain -= i;
            //更新人员编号
            /**
             * 下一个人员的最小值就是当前人员的值，最大值是这里需要判定，因为我们需要保证升序，才能去重，
             * 所以我们要保证后面的值是递增的，那么我们就要获取 min+3 和 remain / ( m - num-1)中的最小值
             * 如果 min+3< remain / ( m - num - 1),那么刚好最为上限，
             * 如果 min+3 > remain / ( m - num - 1),那么为了保证升序去重，就需要选择平均值，
             * */
            count(remain, num + 1, i, Math.min(i + 3, remain / (m - num - 1)));
            //当人员进行其他值的尝试的时候，我们需要将上一个可能只减去的数量在加回来
            remain += i;
        }
    }
}
