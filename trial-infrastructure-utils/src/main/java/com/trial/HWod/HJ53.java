package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-07 22:38
 **/
public class HJ53 {
    /**
     *题目描述
     * 给定一个url前缀和url后缀,通过,分割 需要将其连接为一个完整的url
     *     如果前缀结尾和后缀开头都没有/，需要自动补上/连接符
     *     如果前缀结尾和后缀开头都为/，需要自动去重
     * 约束：不用考虑前后缀URL不合法情况
     * 输入描述
     * url前缀(一个长度小于100的字符串)，url后缀(一个长度小于100的字符串)
     * 输出描述
     * 拼接后的url
     * 用例1
     * 输入
     * /acm,/bb
     *
     * 输出
     * /acm/bb
     *
     * 用例2
     * 输入
     * /abc/,/bcd
     *
     * 输出
     * /abc/bcd
     *
     * 用例3
     * 输入
     * /acd,bef
     *
     * 输出
     * /acd/bef
     *
     * 用例4
     * 输入
     * ,
     *
     * 输出
     * /
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] uriArrs = str.split(",");
        int length = uriArrs.length;
        /**
         * 先判定长度，可能题目出现的分割后长度<2都有可能
         * 这里记住几个记忆点
         * ","分割后是[]
         * "1,"分割后是["1"]
         * ",1"分割后是["","1"]
         * */
        String befor = length > 0 ? uriArrs[0] : "";
        /** $ 表示末尾匹配*/
        befor = befor.replaceAll("/+$","");
        /** ^表示开头匹配*/
        String after = length > 1 ?  uriArrs[1] : "";
        after = after.replaceAll("^/+","");

        System.out.println(befor + "/" + after);


    }
}
