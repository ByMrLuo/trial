package com.trial.HWod;

import java.util.Scanner;


/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-26 15:54
 **/
public class HJ12 {
    /**
     * 题目描述
     * 机器人搬砖，一共有 N 堆砖存放在 N 个不同的仓库中，第 i 堆砖中有 bricks[i] 块砖头，要求在 8 小时内搬完。
     * 机器人每小时能搬砖的数量取决于有多少能量格，机器人一个小时中只能在一个仓库中搬砖，机器人的能量格只在这一个小时有效，
     * 为使得机器人损耗最小化，应尽量减小每次补充的能量格数。
     * 为了保障在 8 小时内能完成搬砖任务，请计算每小时给机器人充能的最小能量格数。
     *     无需考虑机器人补充能力格的耗时；
     *     无需考虑机器人搬砖的耗时；
     *     机器人每小时补充能量格只在这一个小时中有效；
     *
     * 输入描述
     * 第一行为一行数字，空格分隔
     * 输出描述
     * 机器人每小时最少需要充的能量格，若无法完成任务，输出 -1
     * 用例1
     * 输入
     * 30 12 25 8 19
     * 输出
     * 15
     *
     * 用例2
     * 输入
     * 10 12 25 8 19 8 6 4 17 19 20 30
     * 输出
     * -1
     *
     * 说明
     *     砖的堆数为12堆存放在12个仓库中，机器人一个小时内只能在一个仓库搬砖，不可能完成任务。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");
        int length = strArray.length;
        if(length > 8){
            System.out.println(-1);
            return;
        }
        int count = 0;
        int min = 0;
        int max = 0;
        int[] nums = new int[length];
        for(int i = 0; i<length; i++){
            nums[i] = Integer.valueOf(strArray[i]);
            max = Math.max(max, nums[i]);
            count += nums[i];
        }
        int reblance = count / 8;
        min = reblance;
        //这里其实无所谓，0还是平均值都可以
        int mid = min;
        while(min <= max){
            /**
             * 向上取整，如果max本身能够整除2，那么他+2再-1还是整除的值本身
             * 如果max/2后有余数要向上取整也就是+1，那么我提前+2后正好是向上取整，
             * 因为本身就有余数，也就是 0<余数<除数 就算-1也不会有任何影响，-1就是为了整除的情况准备的
             * */
            int temp = (max + min + 1)/2;
            boolean check = check(temp, nums);
            if(check){
                mid = temp;
                max = temp - 1;
            }else{
                min = temp + 1;
            }
        }
        System.out.println(mid);
    }
    private static boolean check(int temp, int[] nums){
        int cost = 0;
        for (int num : nums){
            cost += (num + temp -1)/temp;
            if(cost > 8){
                return false;
            }
        }
        return true;
    }
}
