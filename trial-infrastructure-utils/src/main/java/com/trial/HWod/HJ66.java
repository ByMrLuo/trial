package com.trial.HWod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description: HJ66同HJ2
 * @author: Mr.Luo
 * @create: 2024-06-11 23:00
 **/
public class HJ66 {
    /**
     *小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差 对他们进行排序，请帮他实现排序。
     *      * 输入描述：
     *      * 第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。 第二行为N个正整数H1-HN，分别是其他小朋友的身高，
     *      * 取值范围0<Hi<200（1<=i<=N），且N个正整数各不相同。
     *      * 输出描述：
     *      * 输出排序结果 ，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，
     *      * 如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
     *      * 补充说明：
     *      * 示例1
     *      * 输入：
     *      * 100 10
     *      * 95 96 97 98 99 101 102 103 104 105
     *      * 输出：
     *      * 99 101 98 102 97 103 96 104 95 105
     *      * 说明：
     *      * 小明身高100，班级学生10个，身高分别为95 96 97 98 99 101 102 103 104 105，
     *      * 按身高差排序后结果为：99 101 98 102 97 103 96 104 95 105。
     *      * 解题思路：考察对数组的理解和运用。
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //小明身高
        int tall = scanner.nextInt();
        int number = scanner.nextInt();

        Integer[] peopleArrs = new Integer[number];
        for (int i = 0; i < number; i++) {
            peopleArrs[i] = scanner.nextInt();
        }

        Arrays.sort(peopleArrs, (a,b)->{
            int aABS = Math.abs(tall - a);
            int bABS = Math.abs(tall - b);
            if(aABS == bABS){
                return a - b;
            }
            return aABS - bABS;
        });
        StringJoiner sj = new StringJoiner(" ");
        for (Integer peopleArr : peopleArrs) {
            sj.add(String.valueOf(peopleArr));
        }
        System.out.println(sj.toString());
    }
}
