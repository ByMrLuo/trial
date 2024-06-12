package com.trial.HWod;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-12 15:51
 **/
public class HJ69 {
    /**
     *题目描述
     * 警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如 “HH:MM” 表示的时刻。
     * 根据警察和线人的约定，为了隐蔽，该时间是修改过的，
     * 解密规则为：利用当前出现过的数字，构造下一个距离当前时间最近的时刻，则该时间为可能的犯罪时间。
     * 每个出现数字都可以被无限次使用。
     * 输入描述
     * 形如HH:SS字符串，表示原始输入。
     * 输出描述
     * 形如HH:SS的字符串，表示推理处理的犯罪时间。
     * 备注
     * 1.可以保证现任给定的字符串一定是合法的。
     * 例如，“01:35”和“11:08”是合法的，“1:35”和“11:8”是不合法的。
     *
     * 2.最近的时刻可能在第二天。
     * 用例
     * 输入 	输出
     * 20:12 	20:20
     * 23:59 	22:22
     * 12:58 	15:11
     * 18:52 	18:55
     * 23:52 	23:53
     * 09:17 	09:19
     * 07:08 	08:00
     *
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeStr = scanner.nextLine();
        String[] HourAndMins = timeStr.split(":");
        Set<Integer> set = new HashSet<>();
        for (String hourAndMin : HourAndMins) {
            char[] chars = hourAndMin.toCharArray();
            for (char cha :chars){
                int num = Character.getNumericValue(cha);
                set.add(num);
            }
        }
        ArrayList<Integer> list = new ArrayList(set);
        //得到去重后的数字
        ArrayList<String> strList = new ArrayList();
        Pattern compile = Pattern.compile("([2][0-3]|[0-1]\\d)([0-5]\\d)");
        /**因为数据量小所以这里不采用递归而是四层for*/
        for (Integer a : list) {
            for (Integer b : list) {
                for (Integer c : list) {
                    for (Integer d : list) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(a);
                        sb.append(b);
                        sb.append(c);
                        sb.append(d);
                        String newStr = sb.toString();
                        Matcher matcher = compile.matcher(newStr);
                        if(matcher.find()){
                            strList.add(newStr);
                        }
                    }
                }
            }
        }
        //根据字典排序
        Collections.sort(strList);
        String time = HourAndMins[0] + HourAndMins[1];
        for (int i = 0; i < strList.size(); i++) {
            String s = strList.get(i);
            if(s.equals(time)){
                i = ++i % strList.size();
                StringBuffer sb = new StringBuffer(strList.get(i));
                sb.insert(2,":");
                System.out.println(sb.toString());
                break;
            }
        }

    }
}
