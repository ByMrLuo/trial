package com.trial.HWod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-04 16:09
 **/
public class HJ37 {
    /**
     * 题目描述
     * 现有若干个会议，所有会议共享一个会议室，用数组表示各个会议的开始时间和结束时间，格式为：
     *     [[会议1开始时间, 会议1结束时间], [会议2开始时间, 会议2结束时间]]
     * 请计算会议室占用时间段。
     * 输入描述
     * 第一行输入一个整数 n，表示会议数量
     * 之后输入n行，每行两个整数，以空格分隔，分别表示会议开始时间，会议结束时间
     * 输出描述
     * 输出多行，每个两个整数，以空格分隔，分别表示会议室占用时间段开始和结束
     * 备注
     *     会议室个数范围：[1, 100]
     *     会议室时间段：[1, 24]
     *
     * 用例1
     * 输入
     * 4
     * 1 4
     * 2 5
     * 7 9
     * 14 18
     *
     * 输出
     * 1 5
     * 7 9
     * 14 18
     * 说明
     *     输入：[[1,4],[2,5],[7,9],[14,18]]
     *     输出：[[1,5],[7,9],[14,18]]
     *     说明：时间段[1,4]和[2,5]重叠，合并为[1,5]
     * 用例2
     * 输入
     * 2
     * 1 4
     * 4 5
     *
     * 输出
     * 1 5
     * 说明
     *     输入：[[1,4],[4,5]]
     *     输出：[[1,5]]
     *     说明：时间段[1,4]和[4,5]连续
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[][] times = new int[number][2];
        for(int i = 0; i < number; i++){
            times[i][0] = scanner.nextInt();
            times[i][1] = scanner.nextInt();
        }
        Arrays.sort(times, (a,b) -> a[0]-b[0]);
        int left = 0;
        int right = 1;
        int[][] merge = new int[number][2];
        merge[0] = times[0];
        while(right < number){
            //判定是否重合
            if(merge[left][1] >= times[right][0]){
                //扩展右边界, 选取两个区间的最大值
                merge[left][1] = Math.max(merge[left][1], times[right][1]);
            }else{
                //否则
                merge[++left] = times[right];
            }
            right++;
        }
        int[][] newTimes = Arrays.copyOf(merge,left+1);
        for (int[] newTime : newTimes) {
            System.out.print(newTime[0] + " ");
            System.out.print(newTime[1]);
            System.out.println();
        }
    }
}
