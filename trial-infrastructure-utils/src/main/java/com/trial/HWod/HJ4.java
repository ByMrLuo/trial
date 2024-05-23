package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-23 15:59
 **/
public class HJ4 {
    /**
     * 给你一个字符串 s，首尾相连成一个环形，请你在环中找出 'o' 字符出现了偶数次最长子字符串的长度。
     * 输入描述
     * 输入是一个小写字母组成的字符串
     * 输出描述
     * 输出是一个整数
     * 备注
     * 1 ≤ s.length ≤ 500000
     * s 只包含小写英文字母
     * 用例1
     * 输入
     * alolobo
     * 输出
     * 6
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int haveO = 0;
        for(int i = 0; i< chars.length;i++){
            if(chars[i] == 'o'){
                haveO++;
            }
        }
        if(haveO % 2 == 0){
            System.out.println(str.length());
        }else{
            System.out.println(str.length()-1);
        }
    }
}
