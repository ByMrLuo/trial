package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-07 10:47
 **/
public class HJ48 {
    /**
     * 题目描述
     * 给定一个字符串，只包含字母和数字，按要求找出字符串中的最长（连续）子串的长度，字符串本身是其最长的子串，子串要求：
     * 1、 只包含1个字母(a~z, A~Z)，其余必须是数字；
     * 2、 字母可以在子串中的任意位置；
     * 如果找不到满足要求的子串，如全是字母或全是数字，则返回-1。
     * 输入描述
     * 字符串(只包含字母和数字)
     * 输出描述
     * 子串的长度
     * 用例1
     * 输入
     * abC124ACb
     *
     * 输出
     * 4
     * 说明
     *     满足条件的最长子串是C124或者124A，长度都是4
     *
     * 用例2
     * 输入
     * a5
     *
     * 输出
     * 2
     *
     * 说明
     *
     *     字符串自身就是满足条件的子串，长度为2
     *
     * 用例3
     * 输入
     * aBB9
     *
     * 输出
     * 2
     * 说明
     *     满足条件的子串为B9，长度为2
     *
     * 用例4
     * 输入
     * abcdef
     *
     * 输出
     * -1
     *
     * 说明
     *     没有满足要求的子串，返回-1
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        /**
         * 本题思路滑动窗口，left左缩进，right右扩展，始终保持窗口内只存在一个字母
         * 当存在一个字母的时候开始统计长度，所以存在两种这情况：
         * 1，始终只有一个字母，即 maxLength = 1；
         * 2. 只存在一个字母，多个数字，maxLength保留最长的结果
         * 那么这时候我们在输出的时候就要判定，maxLength >=2 才是有效长度，其他的只能是不符合要求输出-1
         * */
        int left = 0;
        int right = 0;
        //统计字母个数
        int count = 0;
        int maxLength = 0;
        while(right < chars.length){
            if(chars[right]  <= 'z' && chars[right] >= 'A'){
                count++;
            }
            //出现字母就开始统计最长长度
            if(count == 1){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            /**
             * 当字母统计count > 1的时候，需要缩减left边界,直到再次count=1，left停止移动
             * right继续向右扩展寻找更大长度，这样我们可以保证窗口始终只包含一个字母，
             * 尽管可能一直到最后都只有一个字母
             * */
            while(count > 1){
                if(chars[left]  <= 'z' && chars[left] >= 'A'){
                    count--;
                }
                left++;
            }
            right++;
        }
        /**
         * 通过上述计算，存在maxLength=0，全都是数字，maxLength=1，只包含了一个字母两种不符合的情况
         * 但凡maxLength>=2说明存在了符合标准的数据就要正常输出长度
         * */
        System.out.println(maxLength >= 2 ? maxLength : -1);
    }
}
