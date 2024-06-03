package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-02 18:36
 **/
public class HJ32 {
    /**
     * 题目描述
     * 攀登者喜欢寻找各种地图，并且尝试攀登到最高的山峰。
     * 地图表示为一维数组，数组的索引代表水平位置，数组的元素代表相对海拔高度。其中数组元素0代表地面。
     * 例如：[0,1,2,4,3,1,0,0,1,2,3,1,2,1,0]，代表如下图所示的地图，地图中有两个山脉位置分别为 1,2,3,4,5 和 8,9,10,11,12,13，最高峰高度分别为 4,3。最高峰位置分别为3,10。
     * 一个山脉可能有多座山峰(高度大于相邻位置的高度，或在地图边界且高度大于相邻的高度)。
     * 登山者想要知道一张地图中有多少座山峰。
     * 输入描述
     * 输入为一个整型数组，数组长度大于1。
     * 输出描述
     * 输出地图中山峰的数量。
     * 用例1
     * 输入
     * 0,1,4,3,1,0,0,1,2,3,1,2,1,0
     * 输出
     * 3
     * 说明
     *     山峰所在索引分别为3，10，12
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split(",");
        int length = strArrs.length;
        int count = 0;
        for (int i = 0; i < length; i++){
            int hight = Integer.valueOf(strArrs[i]);

            int leftHight = i - 1 >= 0 ? Integer.valueOf(strArrs[i-1]) : 0;
            int rightHight = i + 1 < length ? Integer.valueOf(strArrs[i + 1]) : 0;

            if(leftHight < hight && rightHight < hight){
                count++;
            }
        }
        System.out.println(count);
    }
}
