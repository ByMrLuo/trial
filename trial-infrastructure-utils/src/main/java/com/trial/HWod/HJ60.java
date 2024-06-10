package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-10 17:37
 **/
public class HJ60 {
    /**
     *题目描述
     * 众数是指一组数据中出现次数量多的那个数，众数可以是多个。
     * 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
     * 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数。
     * 输入描述
     * 输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
     * 输出描述
     * 输出众数组成的新数组的中位数
     * 用例1
     * 输入
     * 10 11 21 19 21 17 21 16 21 18 15
     *
     * 输出
     * 21
     *
     * 用例2
     * 输入
     * 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
     *
     * 输出
     * 3
     *
     * 用例3
     * 输入
     * 5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
     *
     * 输出
     * 7
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split(" ");
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i = 0; i < strArrs.length; i++) {
            int number = Integer.valueOf(strArrs[i]);
            if(hashMap.containsKey(number)){
                Integer count = hashMap.get(number);
                hashMap.put(number, ++count);
            }else{
                hashMap.put(number,1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(hashMap.entrySet());
        //根据个数降序
        Collections.sort(sortList, (a,b)-> b.getValue()-a.getValue());
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < sortList.size(); i++) {
            Map.Entry<Integer, Integer> entry = sortList.get(i);
            if(i>=1){
                if(entry.getValue() != sortList.get(i-1).getValue()){
                    break;
                }
            }
            newList.add(entry.getKey());
        }
        Collections.sort(newList);
        int size = newList.size();
        if(size == 1){
            System.out.println(newList.get(0));
            return;
        }
        int mid = size/2;
        if(size % 2 == 0){
            int left = newList.get(mid - 1);
            int right = newList.get(mid);
            System.out.println((left+right)/2);
        }else{
            //如果是奇数个index平均数向上+1，即（size+2-1） = size+1
            System.out.println(newList.get(mid));
        }
    }
}
