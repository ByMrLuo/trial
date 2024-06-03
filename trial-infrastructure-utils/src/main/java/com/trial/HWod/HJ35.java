package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-03 19:04
 **/
public class HJ35 {
    /**
     * 题目描述
     * 有位客人来自异国，在该国使用 m 进制计数。
     * 该客人有个幸运数字n（n < m），每次购物时，其总是喜欢计算本次支付的花费（折算为异国的价格后）中存在多少幸运数字。
     * 问：当其购买一个在我国价值 k 的产品时，其中包含多少幸运数字?
     * 输入描述
     * 第一行输入为 k，n，m。
     * 其中：
     *     k 表示该客人购买的物品价值（以十进制计算的价格）
     *     n 表示该客人的幸运数字
     *     m 表示该客人所在国度采用的进制
     * 输出描述
     * 输出幸运数字的个数，行末无空格
     * 备注
     * 当输入非法内容时，输出0
     * 用例1
     * 输入
     * 10 2 4
     *
     * 输出
     * 2
     * 说明
     *     10用4进制表示时为22，同时，异国客人的幸运数字是2，故而此处输出为2，表示有2个幸运数字。
     *
     * 用例2
     * 输入
     * 10 4 4
     *
     * 输出
     * 0
     * 说明
     *     此时客人的幸运数字为4，但是由于该国最大为4进制，故而在该国的进制下不可能出现幸运数字，故而返回0。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //商品售价
        long k = scanner.nextLong();
        //幸运数字
        long luckNumber = scanner.nextLong();
        //进制
        long m = scanner.nextLong();
        if(luckNumber >= m){
            System.out.println(0);
            return;
        }
        /**
         * Integer.parseInt(k+"", m);
         * 这个方法是件该字符串，以及它对应的进制转化为十进制，而不是转化为任意进制
         * 而String money = Long.toString(k, m);方法中的m必须是int类型所以也不能使用
         * 需要使用短除法(每次用商去除以被除数，直到商小于被除数)，将余数从下到上顺序写出，
         * 余数就是对应进制的位，按位比较幸运数字
         * */
        long count = 0;
        while(k > 0){
            long a =  k % m;
            if(a == luckNumber){
                count++;
            }
            k /= m;
        }
        System.out.println(count);

    }
}
