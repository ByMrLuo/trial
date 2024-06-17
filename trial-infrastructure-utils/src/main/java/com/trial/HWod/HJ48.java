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
         * 当满足包含一个字母和x个数字的时候就更新长度，每次都更新，这样可以避免多个字母的时候更新出现的
         * 边界问题：
         * 比如最后一个是字母但是没有出现多个，这时候会不更新，但是满足条件就更新不会存在这个边界问题，新增加了
         * 数字统计更加容易方便判定是否已经满足更新条件
         * */
        int left = 0;
        int right = 0;
        //统计字母个数
        int letterCount = 0;
        int numberCount = 0;
        int maxLength = 0;
        while(right < chars.length){
            //优化此处逻辑，原来的判定存在不严谨的问题
            if(Character.isLowerCase(chars[right]) || Character.isUpperCase(chars[right])){
                letterCount++;
            }else{
                numberCount++;
            }
            if(letterCount > 1){
                //缩减窗口
                if(Character.isLowerCase(chars[left]) || Character.isUpperCase(chars[left])){
                    letterCount--;
                }else{
                    numberCount--;
                }
                left++;
            }else if(letterCount == 1 && numberCount > 0){
                //符合一个字母n个数字就更新长度
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        /**
         *
         * */
        System.out.println(maxLength > 0 ? maxLength : -1);
    }
}
