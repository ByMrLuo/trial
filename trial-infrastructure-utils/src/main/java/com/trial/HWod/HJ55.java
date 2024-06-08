package com.trial.HWod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-08 11:31
 **/
public class HJ55 {
    /**
     * 题目描述
     * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。
     * 判定S是否是L的有效子串。
     * 判定规则：
     * S中的每个字符在L中都能找到（可以不连续），且S在Ｌ中字符的前后顺序与S中顺序要保持一致。
     * （例如，S=”ace”是L=”abcde”的一个子序列且有效字符是a、c、e，而”aec”不是有效子序列，且有效字符只有a、e）
     * 输入描述
     * 输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。
     * 先输入S，再输入L，每个字符串占一行。
     * 输出描述
     * S串最后一个有效字符在L中的位置。（首位从0开始计算，无有效字符返回-1）
     * 用例1
     * 输入
     * ace
     * abcde
     *
     * 输出
     * 4
     *
     * 用例2
     * 输入
     * fgh
     * abcde
     *
     * 输出
     * -1
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flaw = scanner.nextInt();
        scanner.nextLine();
        String words = scanner.nextLine();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] chars = words.toCharArray();
        //记录所有元音字符的索引
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(set.contains(chars[i])){
                indexList.add(i);
            }
        }
        //记录最大长度
        int maxLength = 0;
        //双指针
        int left = 0;
        int right = 0;
        while(right < indexList.size()){
            /**两个指针出代表的元音字符的索引*/
            int leftIndex = indexList.get(left);
            int rightIndex = indexList.get(right);
            /**
             * rightIndex - leftIndex - 1 ,表示的是两个相邻元音索引之间存在多少个非元音字符
             * 但是；两个元音可能并不是相邻的，所以还要减去他们之中的原因的个数,
             * right - left -1 表示首位两个元音之间可能存在[0，right - left -1]个元音
             * */
            if(rightIndex - leftIndex - 1 - (right - left -1) == flaw){
                //长度应该是用原因索引来相减
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            }else if(rightIndex - leftIndex - 1 - (right - left -1) > flaw){
                left++;
                continue;
            }
            right++;
        }
        System.out.println(maxLength);
    }
}
