package com.trial.HWod;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-30 00:42
 **/
public class HJ21 {
    /**
     *题目描述
     *
     * 给定一个正整数 n，如果能够分解为 m（m > 1）个连续正整数之和，请输出所有分解中，m最小的分解。
     * 如果给定整数无法分解为连续正整数，则输出字符串"N"。
     * 输入描述
     * 输入数据为一整数，范围为 (1, 2^30]
     * 输出描述
     * 比如输入为：
     *     21
     * 输出：
     *     21=10+11
     *
     * 用例1
     * 输入
     * 21
     *
     * 输出
     * 21=10+11
     *
     * 说明
     *     21可以分解的连续正整数组合的形式有多种：
     *     21=1+2+3+4+5+6
     *     21=6+7+8
     *     21=10+11
     *     其中 21=10+11，是最短的分解序列。
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long begin = 0;
        long n = 0;
        /**
         * (a1+an)n/2 = number
         * (2a1+n-1)n = 2number
         * 2a1*n + n*n -n = 2number
         * n*n = 2number - (2a1-1)n
         * 因为a1和n都大于等于0 那么必然有 n*n <= 2number
         * a1 = (2number/n +1-n)/2
         * */
        for(long i = 2; i*i <= 2*number; i++){
            if(2 * number % i != 0 || (2 * number / i + 1 - i) % 2 != 0){
                continue;
            }
            begin = (2 * number / i + 1 - i) / 2;
            n = i;
            break;
        }

        if(n == 0){
            System.out.println("N");
        }else{
            StringJoiner sj = new StringJoiner("+",number+"=","");
            for (long i = 0; i < n; i++) {
                sj.add(String.valueOf(begin+i));
            }
            System.out.println(sj.toString());
        }
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long number = scanner.nextInt();
//        long from = 1;
//        long left = 1;
//        long right = left + from;
//        boolean have = false;
//        while(left + from < number){
//            int sum = 0;
//            for(long i = left; i <= right; i++){
//                sum += i;
//                //不管有没有遍历完如果已经大于则直接跳出循环需要进行下一个测试
//                if(sum > number){
//                    break;
//                }
//            }
//            if(sum == number){
//                have = true;
//                break;
//            }
//            left++;
//            right = left + from;
//            if(sum > number ||right > number){
//                from++;
//                left = 1;
//                right = left + from;
//            }
//        }
//        if(have){
//            System.out.print(number + "=");
//            for(long i = left; i <= right; i++){
//                System.out.print(i);
//                if(i != right){
//                    System.out.print("+");
//                }
//            }
//        }else{
//            System.out.println("N");
//        }
//
//
//    }
}
