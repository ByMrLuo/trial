package com.trial.HWod;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-12 15:37
 **/
public class HJ68 {
    /**
     *题目描述
     *
     * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，
     * 按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
     * 输入描述
     * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
     * 输出描述
     * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
     * 用例1
     * 输入
     * 4
     * 100 100 120 130
     * 40 30 60 50
     *
     * 输出
     * 2 1 3 4
     * 说明
     *     输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。
     *     由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。
     *
     * 用例2
     * 输入
     * 3
     * 90 110 90
     * 45 60 45
     *
     * 输出
     * 1 3 2
     * 说明
     *     1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Integer[][] tallAndWeights = new Integer[number][3];
        for (int i = 0; i < number; i++) {
            tallAndWeights[i][0] = scanner.nextInt();
            tallAndWeights[i][2] = i+1;
        }
        for (int i = 0; i < number; i++) {
            tallAndWeights[i][1] = scanner.nextInt();
        }
        //升序排列
        Arrays.sort(tallAndWeights,(a,b)-> {
            /**身高相等按体重升序，体重相等顺序不变*/
            if(a[0] == b[0]){
                if(a[1] == b[1]){
                    return 0;
                }
                return a[1]-b[1];
            }
            return a[0] - b[0];
        });
        StringJoiner sj = new StringJoiner(" ");
        for (Integer[] tallAndWeight : tallAndWeights) {
            sj.add(String.valueOf(tallAndWeight[2]));
        }
        System.out.println(sj.toString());
    }
}
