package com.trial.HWod;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-11 20:52
 **/
public class HJ65 {
    /**
     * 题目描述
     * 一个整数可以由连续的自然数之和来表示。
     * 给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式
     * 输入描述
     * 一个目标整数T (1 <=T<= 1000)
     * 输出描述
     * 该整数的所有表达式和表达式的个数。
     * 如果有多种表达式，输出要求为：自然数个数最少的表达式优先输出，每个表达式中按自然数递增的顺序输出，具体的格式参见样例。
     * 在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
     * 用例1
     * 输入
     * 9
     *
     * 输出
     * 9=9
     * 9=4+5
     * 9=2+3+4
     * Result:3
     *
     * 说明
     *     整数 9 有三种表示方法，第1个表达式只有1个自然数，最先输出，
     *     第2个表达式有2个自然数，第2次序输出，
     *     第3个表达式有3个自然数，最后输出。
     *     每个表达式中的自然数都是按递增次序输出的。
     *     数字与符号之间无空格
     *
     * 用例2
     * 输入
     * 10
     *
     * 输出
     * 10=10
     * 10=1+2+3+4
     * Result:2
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        //好像等差数列求和，差值为1  sum = (a1+an)n/2
        //2sum = (a1+an)n 又因为等差值为1可得
        //2sum = (a1+a1+n-1)n =》 2sum = (2a1+n-1)n = (2sum/n)+1-n = 2a1
        int twoSum = number * 2;
        ArrayList<String> list = new ArrayList();
        //因为是项数是从少到多，所以，需要n是项数这样保证从少到多
        for(int n = 1; n < number; n++){
            /**
             * 等差的公式的推到公式中的除法一定都是整除，
             * 2sum/n = (a1+an) 所以 2sum % n !=0
             * a1 = ((2sum/n)+1-n)/2 所以 (2sum / n + 1 - n) % 2 != 0
             * 所以只要有一个不满足就直接跳过,说明当项数为n的时候没有合适的值
             * */
            if(twoSum % n != 0 || (twoSum / n + 1 - n) % 2 != 0){
                continue;
            }
            //首项
            int a1 = (twoSum / n + 1 - n) / 2;
            //当起始点已经等于0那么后面就没有必要再去遍历了，
            if(a1 <= 0){
                break;
            }
            StringJoiner sj = new StringJoiner("+");
            sj.add(number + "=" + a1);
            int i = 2;
            //拼接前n项
            while(i <= n){
                sj.add(String.valueOf(++a1));
                i++;
            }
            list.add(sj.toString());
        }
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("Result:" + list.size());
    }
}
