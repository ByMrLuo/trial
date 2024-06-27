package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-29 10:41
 **/
public class HJ19 {
    /**
     * 题目描述
     * 均衡串定义：字符串中只包含两种字符，且这两种字符的个数相同。
     * 给定一个均衡字符串，请给出可分割成新的均衡子串的最大个数。
     * 约定：字符串中只包含大写的 X 和 Y 两种字符。
     * 输入描述
     * 输入一个均衡串。
     *     字符串的长度：[2， 10000]。
     *     给定的字符串均为均衡字符串
     * 输出描述
     * 输出可分割成新的均衡子串的最大个数。
     * 备注
     * 分割后的子串，是原字符串的连续子串
     *
     * 用例1
     * 输入
     * XXYYXY
     *
     * 输出
     * 2
     * 说明
     *     XXYYXY可分割为2个均衡子串，分别为：XXYY、XY
     * */
    //增加一种更简单的写法，只用统计XY的格数相等时就均衡子串+1，并初始化XY格数重新统计，不需要指针一次循环完成
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int length = chars.length;
        //因为构成均衡字符串至少需要两位，所以只需要遍历到left为=length-2，即<lengh-1
        //单个字符到下一个字符前出现的次数
        int countX = 0;
        int countY = 0;
        int number = 0;
        boolean isEnd = false;
        for(int i = 0; i<length; i++){
            if(chars[i] == 'X'){
                countX++;
            }else{
                countY++;
            }
            if(countX == countY){
                number++;
                //统计后初始化两个统计字符的单位总数
                countX = 0;
                countY = 0;
            }
        }
        System.out.println(number);
    }
    //双指针解法，有一个变量控制，对该变量完成增加，为0说明是一个均衡字符串
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        char[] chars = str.toCharArray();
//        int lettercCount = 0;
//        int count = 0;
//        for (int i = 0; i < chars.length; i++) {
//            for (int j = i; j < chars.length; j++) {
//                if(chars[i] == chars[j]){
//                    lettercCount++;
//                }else{
//                    lettercCount--;
//                }
//                if(lettercCount == 0){
//                    count++;
//                    i = j;
//                    break;
//                }
//            }
//        }
//        System.out.println(count);
//    }
}
