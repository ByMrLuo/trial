package com.trial.HWod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-08 15:58
 **/
public class HJ56 {
    /**
     * 题目描述
     * 公司用一个字符串来表示员工的出勤信息
     *     absent：缺勤
     *     late：迟到
     *     leaveearly：早退
     *     present：正常上班
     * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
     *     缺勤不超过一次；
     *     没有连续的迟到/早退；
     *     任意连续7次考勤，缺勤/迟到/早退不超过3次。
     * 输入描述
     * 用户的考勤数据字符串
     *     记录条数 >= 1；
     *     输入字符串长度 < 10000；
     *     不存在非法输入；
     * 输出描述
     * 根据考勤数据字符串，如果能得到考勤奖，输出”true”；否则输出”false”。
     * 用例1
     * 输入
     * 2
     * present
     * present present
     *
     * 输出
     * true true
     *
     * 用例2
     * 输入
     * 2
     * present
     * present absent present present leaveearly present absent
     *
     * 输出
     * true false
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> presentList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            presentList.add(scanner.nextLine());
        }

        HashSet<String> lateOrleaveearlySet = new HashSet<>();
        lateOrleaveearlySet.add("late");
        lateOrleaveearlySet.add("leaveearly");


        StringJoiner sj = new StringJoiner(" ");
        for (String presentArr : presentList) {
            //缺勤次数
            int absentNumber = 0;
            //连续迟到早退
            boolean lateOrleaveearlyBoolean = false;
            //任意连续7天缺勤迟到早退统计
            int count = 0;
            int left = 0;
            int right = 0;
            //拆解每条考勤次数,
            String[] s = presentArr.split(" ");
            while(right < s.length){
                //任意七天，缺勤/迟到/早退不超过3次
                if(right - left + 1 > 7){
                    if(s[left].equals("absent") || lateOrleaveearlySet.contains(s[left])){
                        count--;
                    }
                    left++;
                    continue;
                }

                //缺勤1次以上
                if(s[right].equals("absent")){
                    absentNumber++;
                    //连续7天缺勤可以在这里统计
                    count++;
                    if(absentNumber > 1){
                        break;
                    }
                }
                //迟到或早退
                if(lateOrleaveearlySet.contains(s[right])){
                    count++;
                    //连续两天
                    if(right > 0 && lateOrleaveearlySet.contains(s[right - 1])){
                        lateOrleaveearlyBoolean = true;
                        break;
                    }
                }
                if(count > 3){
                    break;
                }
                right++;
            }
            /**
             * 缺勤超过一次；
             * 连续的迟到/早退；
             * 任意连续7次考勤，缺勤/迟到/早退超过3次。
             * */
            if(absentNumber > 1 || lateOrleaveearlyBoolean || count > 3){
                sj.add("false");
                continue;
            }
            sj.add("true");
        }
        System.out.println(sj.toString());
    }
}
