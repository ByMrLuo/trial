package com.trial.HWod;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

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
        int k = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArrs = str.split("-");
        /**
         * 拆解为字符添加到list
         * */
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 1; i < strArrs.length; i++) {
            char[] chars = strArrs[i].toCharArray();
            for (char ch : chars) {
                list.add(ch);
            }
        }
        StringJoiner sj = new StringJoiner("-");
        /**
         * 定义一个偏移量，作为每次拼接时候就得起始位置
         * */
        int offset = 0;
        for (int i = 0; i < list.size(); i++) {
            /**
             * 定义拼接对象和统计大小写的变量
             * */
            StringBuffer sb = new StringBuffer();
            int lowCount = 0;
            int upCount = 0;
            /**
             * 开始拼接，起始为偏移量的位置，字符长度为k，但是还要小于list的长度
             * 并且更新i的位置，因为每拼接完k个长度就要添加到sj对象中，而下次开始的
             * i的位置实在当前的j的基础上+1，也就是拼接完后的i++这一步，所以在最后要更新
             * j的位置到i
             * */
            for (int j = offset; j < offset + k && j < list.size(); j++) {
                Character letter = list.get(j);
                if(Character.isUpperCase(letter)){
                    upCount++;
                }else if(Character.isLowerCase(letter)){
                    lowCount++;
                }
                sb.append(letter);
                i = j;
            }
            /**
             * 同时重新给偏移量赋值，为下次拼接做准备
             * */
            offset += k;
            String appendStr = sb.toString();
            if(upCount > lowCount){
                appendStr = appendStr.toUpperCase();
            }else if(upCount < lowCount){
                appendStr = appendStr.toLowerCase();
            }
            sj.add(appendStr);
        }
        /**会存在只有一个头的情况，所以还要注意是否拼接*/
        System.out.println(sj.toString().isEmpty() ? strArrs[0] : strArrs[0] +"-"+ sj.toString());
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        sc.nextLine();
//        String s = sc.nextLine();
//        //切割字符串
//        String[] sArrs = s.split("-");
//        /**
//         * 除sArrs[0]以外的都转换为char
//         * */
//        ArrayList<Character> charList = new ArrayList<>();
//        for (int i = 1; i < sArrs.length; i++) {
//            char[] chars = sArrs[i].toCharArray();
//            for (char ch : chars) {
//                charList.add(ch);
//            }
//        }
//
//        StringJoiner sj = new StringJoiner("-");
//        //定义几个条件变量
//        int length = 0;
//        int lowCount = 0;
//        int upCount = 0;
//        StringBuffer sb = new StringBuffer();
//        int size = charList.size();
//        /**
//         * 遍历字符集合拼接字符串
//         * */
//        for (int i = 0; i < size; i++){
//            char ch = charList.get(i);
//            if(Character.isUpperCase(ch)){
//                upCount++;
//            }else if(Character.isLowerCase(ch)){
//                lowCount++;
//            }
//            sb.append(ch);
//            length++;
//            if(length == k){
//                String kStr = sb.toString();
//                if(upCount > lowCount){
//                    kStr = kStr.toUpperCase();
//                }else if(upCount < lowCount){
//                    kStr = kStr.toLowerCase();
//                }
//                sj.add(kStr);
//                length = 0;
//                lowCount = 0;
//                upCount = 0;
//                sb = new StringBuffer();
//            }else if(i == size - 1 && length < k){
//                /**边界，到最后也没有到k长度也要拼上，并且按要求转换大小写*/
//                String kStr = sb.toString();
//                if(upCount > lowCount){
//                    kStr = kStr.toUpperCase();
//                }else if(upCount < lowCount){
//                    kStr = kStr.toLowerCase();
//                }
//                sj.add(kStr);
//            }
//        }
//        /**这里需要注意，可能只有sArr[0]没有后面的拼接所以，这里要做好边界处理*/
//        System.out.println(sj.toString().isEmpty() ? sArrs[0] : sArrs[0] + "-"+ sj.toString());
//    }

}
