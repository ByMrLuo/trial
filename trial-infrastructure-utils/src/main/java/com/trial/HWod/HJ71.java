package com.trial.HWod;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-12 18:30
 **/
public class HJ71 {
    /**
     *题目描述
     * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
     * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
     * 统计停车场最少可以停多少辆车，返回具体的数目。
     * 输入描述
     * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
     * 输出描述
     * 整型数字字符串，表示最少停车数目。
     * 用例1
     * 输入
     * 1,0,1
     *
     * 输出
     * 2
     * 说明
     *     1个小车占第1个车位
     *     第二个车位空
     *     1个小车占第3个车位
     *     最少有两辆车
     *
     * 用例2
     * 输入
     * 1,1,0,0,1,1,1,0,1
     *
     * 输出
     * 3
     * 说明
     *     1个货车占第1、2个车位
     *     第3、4个车位空
     *     1个卡车占第5、6、7个车位
     *     第8个车位空
     *     1个小车占第9个车位
     *     最少3辆车
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split(",");

        ArrayList<Integer> oneList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strArrs.length; i++) {
            int isZero = Integer.valueOf(strArrs[i]);
            /**
             * 注意考虑1在最后结尾的时候需要特殊判定加入集合否则将会丢失
             * */
            if(isZero == 1 && i == strArrs.length-1){
                oneList.add(++count);
                continue;
            }else if(isZero == 1){
                count++;
                continue;
            }
            oneList.add(count);
            count = 0;
        }
        int size = oneList.size();
        int minCount = 0;
        for (int i = 0; i < size; i++) {
            //余数
            minCount += result(oneList.get(i));
        }
        System.out.println(minCount);
    }

    private static int result(int haveOne){
        int minCount = 0;
        int next = haveOne % 3;
        //统计站三车位的车
        minCount += haveOne / 3;
        //不为0计算两个车的车位
        if(next != 0){
            //能整出直接跳出
            haveOne = next;
            minCount += haveOne / 2;
            //统计占两车位的车
            next = haveOne % 2;
            if(next != 0){
                //除以2后的余数就是占一个车位的车辆
                minCount += next;
            }
        }
        return minCount;
    }
}
