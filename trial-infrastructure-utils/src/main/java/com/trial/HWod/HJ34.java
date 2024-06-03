package com.trial.HWod;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-03 17:22
 **/
public class HJ34 {
    /**
     *题目描述
     * 给定一段“密文”字符串 s，其中字符都是经过“密码本”映射的，现需要将“密文”解密并输出。
     * 映射的规则（'a' ~ 'i'）分别用（'1' ~ '9'）表示；（'j' ~ 'z'）分别用（"10*" ~ "26*"）表示。
     * 约束：映射始终唯一。
     * 输入描述
     * “密文”字符串
     *
     * 输出描述
     * 明文字符串
     *
     * 备注
     * 翻译后的文本长度在100以内
     * 用例1
     * 输入
     * 20*19*20*
     *
     * 输出
     * tst
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        /**
         * 这里需要注意的是：密码的替换你必须从数字最大的开始也就是对于20*这种从大到小替换
         * 不然从小到大会出现20*原本是一个字母，但是从小到大替换会出现20会被替换为字母c而*却不被替换的现象
         * 这里使用replaceAll方法，该方法中的第一个参数是一个正则表达式。
         * 所以在我们输入的时候*表示一次或多次所以我们要对其进行转义
         * */
        for(int i = 26; i > 0; i--){
            String number = i > 9 ? i+"\\*" : i+"";
            String replace = String.valueOf((char)('a' + i-1));
            password = password.replaceAll(number, replace);
        }
        System.out.println(password);
    }
}
