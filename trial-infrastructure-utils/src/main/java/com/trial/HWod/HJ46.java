package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-06 22:19
 **/
public class HJ46 {
    /**
     * 题目描述
     *
     * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。
     * 输入描述
     * 一个数组
     * 输出描述
     * 去重排序后的数组
     * 用例1
     * 输入
     * 1,3,3,3,2,4,4,4,5
     *
     * 输出
     * 3,4,1,2,5
     * 说明
     *     数组大小不超过100 数组元素值大小不超过100。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split(",");

        LinkedHashMap<String, Integer> sortMap = new LinkedHashMap<>();
        for (String s : strArrs) {
            if(sortMap.containsKey(s)){
                int value = sortMap.get(s);
                value++;
                sortMap.put(s, value);
            }else{
                sortMap.put(s,1);
            }
        }
        List<Map.Entry<String, Integer>> sortList = new ArrayList<>(sortMap.entrySet());
        //因为linkedHash特性所以相等的时候位置不需要变动
        Collections.sort(sortList, (a,b)-> b.getValue() - a.getValue());
        StringJoiner sj= new StringJoiner(",");
        for (Map.Entry<String, Integer> entry : sortList) {
            sj.add(entry.getKey());
        }
        System.out.println(sj.toString());
    }
}
