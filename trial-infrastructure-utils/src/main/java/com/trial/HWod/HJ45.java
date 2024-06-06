package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-06 21:40
 **/
public class HJ45 {
    /**
     * 题目描述
     * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
     *     x#y = 4*x+3*y+2
     *     x$y = 2*x+y+3
     *     其中 x、y 是无符号整数
     *     地球人公式按C语言规则计算
     *     火星人公式中，#的优先级高于$，相同的运算符，按从左到右的顺序计算
     * 现有一段火星人的字符串报文，请你来翻译并计算结果。
     * 输入描述
     * 火星人字符串表达式（结尾不带回车换行）
     * 输入的字符串说明： 字符串为仅由无符号整数和操作符（#、$）组成的计算表达式。例如：
     *     123#4$5#67$78
     *     用例保证字符串中，操作数与操作符之间没有任何分隔符。
     *     用例保证操作数取值范围为32位无符号整数。
     *     保证输入以及计算结果不会出现整型溢出。
     *     保证输入的字符串为合法的求值报文，例如：123#4$5#67$78
     *     保证不会出现非法的求值报文，例如类似这样字符串：
     *     #4$5 //缺少操作数
     *     4$5# //缺少操作数
     *     4#$5 //缺少操作数
     *     4 $5 //有空格
     *     3+4-5*6/7 //有其它操作符
     *     12345678987654321$54321 //32位整数计算溢出
     *
     * 输出描述
     * 根据输入的火星人字符串输出计算结果（结尾不带回车换行）
     * 用例1
     * 输入
     * 7#6$5#12
     *
     * 输出
     * 157
     * 说明
     *     7#6$5#12
     *     =(4*7+3*6+2)$5#12
     *     =48$5#12
     *     =48$(4*5+3*12+2)
     *     =48$58
     *     =2*48+58+3
     *     =157
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split("\\$");
        long[] countArrs = new long[strArrs.length];

        for (int i = 0; i < strArrs.length; i++) {
            String[] intArrs = strArrs[i].split("#");
            long count = Integer.valueOf(intArrs[0]);
            //x#y = 4*x+3*y+2
            for (int j = 1; j < intArrs.length; j++) {
                count = 4 * count + 3 * Integer.valueOf(intArrs[j]) + 2;
            }
            countArrs[i] = count;
        }
        long allCount = countArrs[0];
        //x$y = 2*x+y+3
        for (int i = 1; i < countArrs.length; i++) {
            allCount = 2 * allCount + countArrs[i] + 3;
        }
        System.out.println(allCount);
    }


}
