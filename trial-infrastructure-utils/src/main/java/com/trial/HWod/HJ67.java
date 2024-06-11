package com.trial.HWod;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-11 23:44
 **/
public class HJ67 {
    /**
     *题目描述
     * 给定一个非空数组（列表），其元素数据类型为整型，请按照数组元素十进制最低位从小到大进行排序，十进制最低位相同的元素，相对位置保持不变。
     * 当数组元素为负值时，十进制最低位等同于去除符号位后对应十进制值最低位。
     * 输入描述
     * 给定一个非空数组，其元素数据类型为32位有符号整数，数组长度[1, 1000]
     * 输出描述
     * 输出排序后的数组
     * 用例1
     * 输入
     * 1,2,5,-21,22,11,55,-101,42,8,7,32
     *
     * 输出
     * 1,-21,11,-101,2,22,42,32,5,55,7,8
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split(",");

        Integer[] numArrs = new Integer[strArrs.length];

        for (int i = 0; i < strArrs.length; i++) {
            numArrs[i] = Integer.valueOf(strArrs[i]);
        }

        Arrays.sort(numArrs,(a,b)->{
            int aAbs = Math.abs(a);
            a = aAbs % 10;
            int bAbs = Math.abs(b);
            b = bAbs % 10;
            if(a == b){
                return 0;
            }
            return a - b;
        });
        StringJoiner sj = new StringJoiner(",");
        for (Integer numArr : numArrs) {
            sj.add(String.valueOf(numArr));
        }
        System.out.println(sj.toString());
    }
}
