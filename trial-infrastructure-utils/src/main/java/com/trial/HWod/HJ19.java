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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int length = chars.length;
        int left = 0;
        int right = 1;
        //因为构成均衡字符串至少需要两位，所以只需要遍历到left为=length-2，即<lengh-1
        //单个字符到下一个字符前出现的次数
        int count = 1;
        int number = 0;
        boolean isEnd = false;
        while(left < length-1){
            char ch = chars[left];
            /**
             * 这里做一下说明：当left位置和right位置的字母相同，结束标志位为false，
             * 说明他在要统计同一个单词出现的次数count++
             * 当left位置和right位置的字母不同的时候count--，并开启结束位置的true，
             * 直到扣减为0的时候说明一次统计均衡子串结束，number++
             * 但是当count不为0，left位置和right从在相等和不等之间来回变换的时候，
             * 只要count不为0他每一次的从不同变为相同都要继续对count进行累加，这个时候也要吧结束标志位重新变为false
             * */
            if(chars[right] == ch && !isEnd){
                count++;
            }else if(chars[right] == ch && count > 0){
                count++;
                isEnd = false;
            }else if(count > 0){
                /**
                 * 当left和right的不相等的时候说明遇到了第二个字幕
                 * 这个时候需要看count是否大于0如果大于0则需要减到0才
                 * 算是一个均衡子串
                 */
                count--;
                isEnd = true;
            }
            right++;

            if(count == 0){
                /**
                 * 党走到了这里说明满足了以下条件：
                 * left和right分别为两个不同的字母，且出现的次数都为count
                 * 这个时候说明他是一个完整的均衡子串，数量统计+1，重置left的位置
                 * 开始，寻找下一组
                 * */
                number++;
                /**初始化所有统计下一个单词的条件*/
                left = right;
                right = left + 1;
                count = 1;
                isEnd = false;
                continue;
            }
            /**
             * 在这段逻辑中如果还可以在分割，那么逻辑一定会进入到number++;这段代码中
             * right一定不<length,当right=length时候说明
             * 这个循环一定是到了最后不需要在进行下一个left的切割
             * */
            if(right == length){
                break;
            }
        }
        System.out.println(number);
    }
}
