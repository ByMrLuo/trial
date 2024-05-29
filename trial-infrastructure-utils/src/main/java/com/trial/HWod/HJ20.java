package com.trial.HWod;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-29 15:59
 **/
public class HJ20 {
    /**
     *题目描述
     * 小华按照地图去寻宝，地图上被划分成 m 行和 n 列的方格，横纵坐标范围分别是 [0, n-1] 和 [0, m-1]。
     * 在横坐标和纵坐标的数位之和不大于 k 的方格中存在黄金（每个方格中仅存在一克黄金），
     * 但横坐标和纵坐标之和大于 k 的方格存在危险不可进入。小华从入口 (0,0) 进入，任何时候只能向左，右，上，下四个方向移动一格。
     * 请问小华最多能获得多少克黄金？
     * 输入描述
     * 坐标取值范围如下：
     *     0 ≤ m ≤ 50
     *     0 ≤ n ≤ 50
     *
     * k 的取值范围如下：
     *     0 ≤ k ≤ 100
     *
     * 输入中包含3个字数，分别是m, n, k
     * 输出描述
     * 输出小华最多能获得多少克黄金
     *
     * 用例1
     * 输入
     * 40 40 18
     *
     * 输出
     * 1484
     *
     * 用例2
     * 输入
     * 5 4 7
     *
     * 输出
     * 20
     * */
    //去重使用看是否是已经计算过的黄金点位
    private static HashSet<Integer> set = new HashSet<>();
    //上下左右
    static int[][] arrs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    //数位和数组
    static int[] numberPositions;

    static int m;
    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //m行 * n列
        m = scanner.nextInt();
        n = scanner.nextInt();
        //阈值
        k = scanner.nextInt();
        int count = 0;
        /**
         * 1.要用深度遍历dfs或者广度遍历bfs
         * 2.不能用for循环，因为他可以上下左右进行绕路达到某一个直线前进点，并不是直线无法达到就退出，
         * 如果你只是跳过直线，看似没有问题，你会发现在路线不连续的一些地方也能达到，但实际上这些路线是无法连续链接起来的，所以也不能算
         * 所以说要么for循环会丢掉某一个值，要么会多出一些不相关的值。，切记！！！！
         * */
        //去重使用看是否是已经计算过的黄金点位
        HashSet<Integer> set = new HashSet<>();
        numberPositions = numberGPS(Math.max(m,n));
        count = dfs(0, 0, count);
        System.out.println(count);
    }

    private static int[] numberGPS(int max){
        int[] numberPositions = new int[max];
        for(int i = 0; i < max; i++){
            numberPositions[i] =  i / 10 + i % 10;
        }
        return numberPositions;
    }

    private static int dfs(int row, int line, int count){
        if(row < 0 || row >= m || line < 0 || line >= n){
            return count;
        }
        //计算在横纵坐标的数位和
        int position = numberPositions[row] + numberPositions[line];
        //计算每个二维数组坐标转换为一维数组的位置是唯一的。即 row * 每行的长度(就是列) + line(就是在横坐标的位置)
        int gps = row * n  + line;
        if(position > k || set.contains(gps)){
            return count;
        }
        set.add(gps);
        count++;
        for(int[] arr : arrs){
            count = dfs(row + arr[0], line + arr[1], count);
        }
        return count;
    }
}
