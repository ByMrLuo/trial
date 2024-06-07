package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-07 15:24
 **/
public class HJ49 {
    /**
     * 题目描述
     * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
     * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
     * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
     * 输入描述
     * 输入为两行，第一行为参数K，第二行为字符串S。
     * 输出描述
     * 输出转换后的字符串。
     *
     * 用例1
     * 输入
     * 3
     * 12abc-abCABc-4aB@
     *
     * 输出
     * 12abc-abc-ABC-4aB-@
     *
     * 说明
     *     子串为12abc、abCABc、4aB@，第一个子串保留，
     *     后面的子串每3个字符一组为abC、ABc、4aB、@，
     *     abC中小写字母较多，转换为abc，
     *     ABc中大写字母较多，转换为ABC，
     *     4aB中大小写字母都为1个，不做转换，
     *     @中没有字母，连起来即12abc-abc-ABC-4aB-@
     *
     * 用例2
     * 输入
     * 12
     * 12abc-abCABc-4aB@
     *
     * 输出
     * 12abc-abCABc4aB@
     *
     * 说明
     *     子串为12abc、abCABc、4aB@，第一个子串保留，
     *     后面的子串每12个字符一组为abCABc4aB@，
     *     这个子串中大小写字母都为4个，不做转换，
     *     连起来即12abc-abCABc4aB@
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();

        String[] strArrs = str.split("-");
        int length = strArrs.length;

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < length; i++) {
            sb.append(strArrs[i]);
        }

        //剩余字符组合的新字符串
        String changeStr = sb.toString();
        //转化为字符数组开始重新组合
        char[] chars = changeStr.toCharArray();

        //重新赋值,作为主串，拼接好第一个开头
        sb = new StringBuffer(strArrs[0]);

        //子串拼接sb2
        StringBuffer sb2 = new StringBuffer();
        //统计字符个数
        int count = 0;
        /**统计每组字符大小写字母个数*/
        int upCount = 0;
        int lowCount = 0;
        //开始遍历
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] >= 'a' && chars[j] <= 'z') {
                lowCount++;
            }
            if (chars[j] >= 'A' && chars[j] <= 'Z') {
                upCount++;
            }

            sb2.append(chars[j]);
            count++;
            /**
             * 满足count长度为number则需要将期拼接到主串，
             * 但是存在边界，当j=chars.length - 1时
             * 如果count ！= number则无法完成拼接，后续子串到主串的拼接
             * 会丢失子串，所以增加边界的条件：
             * count ！= number && j == chars.length - 1时，直接拼接到主串
             * */
            if (count == number || j == chars.length - 1) {
                //将拼接好的sb转化为字符串，等待是否需要进行大小写的转换
                String newStr = sb2.toString();
                //相等不必转换，否则谁多转换为谁
                if (lowCount > upCount) {
                    newStr = newStr.toLowerCase();
                } else if (lowCount < upCount) {
                    newStr = newStr.toUpperCase();
                }
                /**拼接到主串上的变量sb*/
                sb.append("-");
                sb.append(newStr);
                //拼接完成后初始化统计参数
                count = 0;
                lowCount = 0;
                upCount = 0;
                /**
                 * 也要重新重置sb2变量拼接下一个，
                 * 否则会包含上一个已经拼接万的数据最后导致转换的大小写有问题
                 * */
                sb2 = new StringBuffer();
            }
        }
        System.out.println(sb.toString());
    }
}
