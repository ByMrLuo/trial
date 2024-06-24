package com.trial.HWod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:从此处开始是200分值的题
 * @author: Mr.Luo
 * @create: 2024-06-24 23:38
 **/
public class HJH75 {
    /**
     * 题目描述
     * 孙悟空爱吃蟠桃，有一天趁着蟠桃园守卫不在来偷吃。已知蟠桃园有 N 棵桃树，每颗树上都有桃子，守卫将在 H 小时后回来。
     * 孙悟空可以决定他吃蟠桃的速度K（个/小时），每个小时选一颗桃树，并从树上吃掉 K 个，如果树上的桃子少于 K 个，则全部吃掉，并且这一小时剩余的时间里不再吃桃。
     * 孙悟空喜欢慢慢吃，但又想在守卫回来前吃完桃子。
     * 请返回孙悟空可以在 H 小时内吃掉所有桃子的最小速度 K（K为整数）。如果以任何速度都吃不完所有桃子，则返回0。
     * 输入描述
     * 第一行输入为 N 个数字，N 表示桃树的数量，这 N 个数字表示每颗桃树上蟠桃的数量。
     * 第二行输入为一个数字，表示守卫离开的时间 H。
     * 其中数字通过空格分割，N、H为正整数，每颗树上都有蟠桃，且 0 < N < 10000，0 < H < 10000。
     * 输出描述
     * 吃掉所有蟠桃的最小速度 K，无解或输入异常时输出 0。
     * 用例1
     * 输入
     * 2 3 4 5
     * 4
     *
     * 输出
     * 5
     *
     * 用例2
     * 输入
     * 2 3 4 5
     * 3
     *
     * 输出
     * 0
     *
     * 用例3
     * 输入
     * 30 11 23 4 20
     * 6
     *
     * 输出
     * 23
     * */
    static int[] nums;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int h = scanner.nextInt();
        String[] strArrs = str.split(" ");
        if(strArrs.length > h){
            System.out.println(0);
            return;
        }
        nums = new int[strArrs.length];
        int sum = 0;
        for (int i = 0; i < strArrs.length; i++) {
            nums[i] = Integer.valueOf(strArrs[i]);
            sum += nums[i];
        }
        Arrays.sort(nums);
        int left = sum / h;
        int right = nums[nums.length -1];
        int k = 0;
        while(left <= right){
            int temp = (left + right + 1) / 2;
            if(eatTime(temp, h)){
                right = temp - 1;
                k = temp;
            }else{
                left = temp + 1;
            }
        }
        System.out.println(k);
    }

    private static boolean eatTime(int k,int h){
        int costTime = 0;
        for (int num : nums) {
            costTime += (num + k - 1) / k;
            if(costTime > h){
                return false;
            }
        }
        return true;
    }
}
