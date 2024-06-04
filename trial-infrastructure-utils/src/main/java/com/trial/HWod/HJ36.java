package com.trial.HWod;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-04 01:35
 **/
public class HJ36 {
    /**
     * 给一个正整数数列 nums，一个跳数 jump，及幸存数量 left。
     * 运算过程为：从索引0的位置开始向后跳，中间跳过 J 个数字，命中索引为 J+1 的数字，该数被敲出，并从该点起跳，以此类推，直到幸存 left 个数为止，然后返回幸存数之和。
     * 约束：
     *     0是第一个起跳点
     *     起跳点和命中点之间间隔 jump 个数字，已被敲出的数字不计入在内。
     *     跳到末尾时无缝从头开始（循环查找），并可以多次循环。
     *     若起始时 left > len(nums) 则无需跳数处理过程。
     *  nums 正整数数列，长度范围 [1, 10000]
     *  jump 跳数，范围 [1, 10000]
     *  left 幸存数量，范围 [0, 10000]
     *  return 幸存数之和
     *  int sumOfLeft(int[] nums, int jump, int left)
     *输入描述
     * 第一行输入正整数数列
     * 第二行输入跳数
     * 第三行输入幸存数量
     * 输出描述
     * 输出幸存数之和
     * 用例1
     * 输入
     * 1,2,3,4,5,6,7,8,9
     * 4
     * 3
     *
     * 输出
     * 13
     * 说明
     *     从1（索引为0）开始起跳，中间跳过 4 个数字，因此依次删除 6,2,8,5,4,7。剩余1,3,9，返回和为13
     * */
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArrs = str.split(",");
        //每次跳过个数
        int jump = scanner.nextInt();
        //存货多少的时候停止
        int live = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < strArrs.length; i++) {
            arrayList.add(Integer.valueOf(strArrs[i]));
        }
        int size = arrayList.size();
        int i = 1;
        while(size > live){
            /**
             * 我们必须计算他要移除的位置，而不能计算每次跳过jump个后再+1，因为第一次确实应该+1，
             * 但是当我们每次移除一个后集合的元素就会向前移动，也就是我们的+1这个操作，
             * 这个时候如果你再跳jump，就是要移除的点，否则你计算的值除了第一项后面的会全部都错
             * 想使用jump+1的前提是数组的长度不变才能每次移除到对的位置，但可惜的是我们的是一个动态数组
             */
            i += jump;
            /**
             * 因为是一个圆环，取余才是实际环上的位置,
             */
            i %= size;
            arrayList.remove(i);


            //移除后重新计算容量
            size = arrayList.size();
        }
        int count = 0;
        for (Integer in : arrayList) {
            count += in;
        }
        System.out.println(count);
    }
}
