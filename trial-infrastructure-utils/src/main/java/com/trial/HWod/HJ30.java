package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-01 18:41
 **/
public class HJ30 {
    /**
     * 题目描述
     * "吃货"和"馋嘴"两人到披萨店点了一份铁盘（圆形）披萨，并嘱咐店员将披萨按放射状切成大小相同的偶数个小块。但是粗心的服务员将披萨切成了每块大小都完全不同奇数块，且肉眼能分辨出大小。
     * 由于两人都想吃到最多的披萨，他们商量了一个他们认为公平的分法：从"吃货"开始，轮流取披萨。除了第一块披萨可以任意选取外，其他都必须从缺口开始选。
     * 他俩选披萨的思路不同。"馋嘴"每次都会选最大块的披萨，而且"吃货"知道"馋嘴"的想法。
     * 已知披萨小块的数量以及每块的大小，求"吃货"能分得的最大的披萨大小的总和。
     * 输入描述
     * 第 1 行为一个正整数奇数 N，表示披萨小块数量。
     *     3 ≤ N < 500
     * 接下来的第 2 行到第 N + 1 行（共 N 行），每行为一个正整数，表示第 i 块披萨的大小
     *     1 ≤ i ≤ N
     * 披萨小块从某一块开始，按照一个方向次序顺序编号为 1 ~ N
     *     每块披萨的大小范围为 [1, 2147483647]
     *
     * 输出描述
     *
     * "吃货"能分得到的最大的披萨大小的总和。
     * 用例1
     * 输入
     * 5
     * 8
     * 2
     * 10
     * 5
     * 7
     *
     * 输出
     * 19
     *
     * 说明
     *     此例子中，有 5 块披萨。每块大小依次为 8、2、10、5、7。
     *     按照如下顺序拿披萨，可以使"吃货"拿到最多披萨：
     *     "吃货" 拿大小为 10 的披萨
     *     "馋嘴" 拿大小为 5 的披萨
     *     "吃货" 拿大小为 7 的披萨
     *     "馋嘴" 拿大小为 8 的披萨
     *     "吃货" 拿大小为 2 的披萨
     *     至此，披萨瓜分完毕，"吃货"拿到的披萨总大小为 10 + 7 + 2 = 19
     *     可能存在多种拿法，以上只是其中一种。
     * */
    private static int length;
    private static long[][] catche;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        length = number;
        long[] arrs = new long[number];
        catche = new long[number][number];
        for(int i = 0; i < number; i++){
            arrs[i] = scanner.nextLong();
        }
        long max = 0;
        for(int i = 0; i < number; i++){
            //递归,不算当前已经随意拿走的第一块
            max = Math.max(max, method(arrs, init(i - 1) , init(i + 1)) + arrs[i]);
        }
        System.out.println(max);
    }
    public static long method(long[] arrs, int left,int right){
        //馋嘴选饼
        if(arrs[left] > arrs[right]){
            left = init(left - 1);
        }else{
            right = init( right + 1);
        }
        //如果已经存在递归后的的大小值结果，就没必要再去递归
        if(catche[left][right] > 0){
            return catche[left][right];
        }
        //吃货选饼
        if(left == right){
            catche[left][right] = arrs[left];
        }else{
            //吃货选饼
            long leftMax = method(arrs,  init(left-1), right) + arrs[left];
            long rightMax = method(arrs,  left, init(right + 1)) + arrs[right];
            catche[left][right] = Math.max(leftMax, rightMax);
        }
        return catche[left][right];

    }

    private static int init(int index){
        if(index < 0){
            return length -1;
        }
        if(index >= length){
            return 0;
        }
        return index;
    }
}
