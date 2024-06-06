package com.trial.HWod;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-06 22:43
 **/
public class HJ47 {
    /**
     * 题目描述
     * 输入字符串s，输出s中包含所有整数的最小和。
     * 说明：
     * 字符串s，只包含 a-z A-Z ±
     * 合法的整数包括
     * 1）正整数：一个或者多个0-9组成，如 0 2 3 002 102
     * 2）负整数：负号 – 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
     * 输入描述
     * 包含数字的字符串
     * 输出描述
     * 所有整数的最小和
     * 用例1
     * 输入
     * bb1234aa
     *
     * 输出
     * 10
     *
     * 用例2
     * 输入
     * bb12-34aa
     *
     * 输出
     * -31
     * 说明
     *     1+2+（-34） = -31
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        /**
         * 因为求最小所以只要负数最大，整数拆解为个位数就是相加最小，按照这个思路
         * 正则表达式为 "-\\d+|[0-9]",如果是-号，那么之后可以匹配多位数字
         * 或者没有符号只匹配0-9的数字，这样负数我们可以得到最小的，正数我们可以拿到单个一个数字
         * */
        Pattern compile = Pattern.compile("-\\d+|[0-9]");
        Matcher matcher = compile.matcher(str);
        long count = 0;
        while(matcher.find()){
            String numStr = matcher.group();
            long num = Long.valueOf(numStr);
            count += num;
        }
        System.out.println(count);
    }
}
