package com.trial.HWod;

import java.util.Scanner;

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
    /**
     * 这个解法没问题，但是当number大的时候会有用例超时
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextInt();
        //每移动一格会增长的值最小是2开始的，即两个数的组合
        long left2Right = 2;
        boolean have = false;
        //当right>number的时候跳出循环，说明已经不在符合条件，
        //在最后的循环逻辑中会不断随着right >= number,增加left的值并初始化right，所以这里并不会一次就跳出
        //符合条件的最短连续等差数列
        while(left2Right <= number){
            //等差公式 等差求和 =（首项+末项）*项数/2
            long sum = (1 + left2Right) * left2Right / 2;
            if(sum > number){
                break;
            }
            /**
             * 通过观察的值在差值为1等差的数值中，连续的m项的和整体向后每移动一格会增长m，
             * 即第n项的m项和是number = （n-1）m + sum
             * */
            if((number -sum) % left2Right == 0){
                long n = (number - sum)/left2Right + 1;
                StringBuffer sb = new StringBuffer();
                sb.append(number);
                sb.append("=");
                for(long i = 0; i < left2Right; i++){
                    sb.append(n+i);
                    if(i != left2Right-1){
                        sb.append("+");
                    }
                }
                System.out.println(sb.toString());
                return;
            }
            left2Right++;
        }

        System.out.print("N");
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
