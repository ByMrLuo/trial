package com.trial.HWod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-25 17:25
 **/
public class HW11 {
    /**
     * 题目描述
     * 提取字符串中的最长合法简单数学表达式，字符串长度最长的，并计算表达式的值。如果没有，则返回 0 。
     * 简单数学表达式只能包含以下内容：
     *     0-9数字，符号+-*
     *
     * 说明：
     *     所有数字，计算结果都不超过long
     *     如果有多个长度一样的，请返回第一个表达式的结果
     *     数学表达式，必须是最长的，合法的
     *     操作符不能连续出现，如 +--+1 是不合法的
     *
     * 输入描述
     * 字符串
     * 输出描述
     * 表达式值
     *
     * 用例1
     * 输入
     * 1-2abcd
     *
     * 输出
     * -1
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("([+-]?\\d+)([*+-])(\\d+)");
        int maxLength = 0;
        long result = 0;
        int left = 0;
        int length = str.length();
        while(left < length){
            if(length - (left+1)  <= maxLength){
                break;
            }
            int right = left+1;
            while(right < length){
                String substring = str.substring(left, right);
                Matcher matcher = pattern.matcher(substring);
                if(matcher.find() && substring.length() > maxLength){
                    long num1 = Long.valueOf(matcher.group(1));
                    String sign = matcher.group(2);
                    long num2 = Long.valueOf(matcher.group(3));
                    if(sign.equals("+")){
                        result = num1 + num2;
                    }else if (sign.equals("-")){
                        result = num1 - num2;
                    }else{
                        result = num1 * num2;
                    }
                    maxLength = str.length();
                }
                right++;
            }
            left++;
        }
        System.out.println(result);
    }


}
