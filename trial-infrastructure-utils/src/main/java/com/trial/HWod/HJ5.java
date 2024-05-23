package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-23 16:45
 **/
public class HJ5 {
    /**
     * 题目描述
     * 在一个大型体育场内举办了一场大型活动，由于疫情防控的需要，要求每位观众的必须间隔至少一个空位才允许落座。
     * 现在给出一排观众座位分布图，座位中存在已落座的观众，请计算出，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
     * 输入描述
     * 一个数组，用来标识某一排座位中，每个座位是否已经坐人。0表示该座位没有坐人，1表示该座位已经坐人。
     *1 ≤ 数组长度 ≤ 20000
     *
     * 输出描述
     * 整数，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
     * 用例1
     * 输入
     * 10001
     * 输出
     * 1
     *
     * 用例2
     * 输入
     * 0101
     * 输出
     * 0
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int canSit = 0;
        int length = chars.length;
        for(int i = 0; i < length; i++){
            if(chars[i] == '0'){
                if(i == 0 && (i+1 >= length || chars[i+1] == '0')){
                    canSit++;
                    chars[i] ='1';
                }else if(i == length-1  && chars[length-2] == '0'){
                    canSit++;
                    chars[i] ='1';
                }else if(i != 0 && i != length-1  && chars[i-1] == '0' && chars[i+1] == '0'){
                    canSit++;
                    chars[i] ='1';
                }
            }
        }
        System.out.println(canSit);
    }
}
