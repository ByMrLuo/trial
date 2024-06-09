package com.trial.HWod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-09 15:23
 **/
public class HJ57 {
    /**
     * 题目描述
     * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
     * 变换规则：交换字符串中任意两个不同位置的字符。
     * 输入描述
     * 一串小写字母组成的字符串s
     * 输出描述
     * 一串小写字母组成的字符串s
     * 备注
     *     s是都是小写字符组成
     *     1 ≤ s.length ≤ 1000
     *
     * 用例1
     * 输入
     * abcdef
     *
     * 输出
     * abcdef
     * 说明
     *     abcdef已经是最小字符串，不需要交换。
     *
     * 用例2
     * 输入
     * bcdefa
     *
     * 输出
     * acdefb
     * 说明
     *     a和b进行位置交换，可以得到最小字符串
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        char[] temp = Arrays.copyOf(chars, chars.length);
        /**
         * 升序排序,得到最小字符集合，这个时候拼成的字符串也是最小的
         * */
        Arrays.sort(temp);
        int j = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == temp[j] && i == j){
                j++;
                continue;
            }else if(chars[i] == temp[j] && i != j){
                /**当chars[i] == temp[j]相等但是i!=j的时候，他们都代表同一个字符，在字符串和升序排序的位置
                 * chars[i] 是他字符串中中的位置，temp[j]是他应该排序所在的位置
                 * 将字符调换到j的的位置那么将得到只换一个字符时候的最小的字符串，
                 * 但并不一定是最小的字符串，这里要区分，因为你只换一个字符后最小的
                 * 将chars的i和应该在的位置j调换，就会得到最小的
                 * 注意这里存在一个漏洞，就是可能存在多个相同的字符在不同的位置，这样也会导致置换一个字符仍不是最小
                 * */
                int findI = i + 1;
                while(findI < chars.length){
                    /**
                     * 思路1
                     * 当已经存在一个i位置是和temp[i]的字符相等后，
                     * 需要循环遍历后续的字符串看是否还有和这个字符相等的
                     * 如果有那就更新i的位置，因为更换的位置越靠后我们得到的只才能越小
                     * */
                    if(chars[findI] == temp[j]){
                        i = findI;
                    }
                    findI++;
                }

                char tempChar = chars[j];
                chars[j] = chars[i];
                chars[i] = tempChar;
                break;
            }
        }
        System.out.println(new String(chars));
    }
}
