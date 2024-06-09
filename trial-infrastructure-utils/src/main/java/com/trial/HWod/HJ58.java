package com.trial.HWod;


import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-09 16:37
 **/
public class HJ58 {
    /**
     *题目描述
     * 服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示，
     * 数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
     * 给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，
     * 找出数组中最长时间段，如果未找到则直接返回NULL。
     * 输入描述
     * 输入有两行内容，第一行为{minAverageLost}，第二行为{数组}，数组元素通过空格(” “)分隔，
     * minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个。
     * 输出描述
     * 找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndx}(下标从0开始)，
     * 如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(” “)拼接，多个下标对按下标从小到大排序。
     * 用例1
     * 输入
     * 1
     * 0 1 2 3 4
     *
     * 输出
     * 0-2
     *
     * 说明
     *     输入解释：minAverageLost=1，数组[0, 1, 2, 3, 4]
     *     前3个元素的平均值为1，因此数组第一个至第三个数组下标，即0-2
     *
     * 用例2
     * 输入
     * 2
     * 0 0 100 2 2 99 0 2
     *
     * 输出
     * 0-1 3-4 6-7
     * 说明
     *     输入解释：minAverageLost=2，数组[0, 0, 100, 2, 2, 99, 0, 2]
     *     通过计算小于等于2的最长时间段为：
     *     数组下标为0-1即[0, 0]，数组下标为3-4即[2, 2]，数组下标为6-7即[0, 2]，这三个部分都满足平均值小于等于2的要求，
     *     因此输出0-1 3-4 6-7
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minAverageLost = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] strArrs = str.split(" ");
        int length = strArrs.length;
        int[] averageArrs = new int[length];
        for (int i = 0; i < length; i++) {
            averageArrs[i] = Integer.valueOf(strArrs[i]);
        }
        //前缀和
        int[] sumArrs = new int[length + 1];
        for (int i = 1; i <= averageArrs.length; i++) {
            //sumArrs[i]必须为0，因为我们计算前0-n项和的时候sumArrs[0] = 0
            //后续的才能计算
            sumArrs[i] = sumArrs[i-1] + averageArrs[i-1];
        }

        HashMap<Integer, Integer> map = new HashMap();
        int left = 0;
        int right = left + 1;
        while(left < length){
            if(right > length){
                left++;
                right = left + 1;
                continue;
            }
            //计算的是从 left - right-1项的和
            int sum = sumArrs[right] - sumArrs[left];
            /**
             * sum求得是前【n-1】项和，所以right-left刚好就是长度，
             * minAverageLost * len（长度） = 和
             * */
            if(sum <= minAverageLost * (right - left)){
                //记录下其实索引以及符合条件时候的长度
                map.put(left, right - left);
            }
            right++;
        }
        ArrayList<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(map.entrySet());
        //根据K值降序排序
        Collections.sort(sortList, (a,b)->b.getValue()-a.getValue());
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < sortList.size(); i++) {
            Map.Entry<Integer, Integer> entry = sortList.get(i);
            if(i > 0){
                if(!entry.getValue().equals(sortList.get(i-1).getValue())){
                    break;
                }
            }
            //长度-1就是end索引的位置
            int end = entry.getKey()+entry.getValue() - 1;
            sj.add(entry.getKey()+ "-" + end);
        }
        System.out.println(sj.toString().isEmpty() ? "NULL" : sj.toString());
    }
}
