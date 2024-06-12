package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-12 23:18
 **/
public class HJ72 {
    /**
     *
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int[][] points = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        //将最后的结尾点e提前放置坐标为（e.0）
        points[n] = new int[]{e,0};

        long area = 0;
        //记录y轴的高度变化
        int width = 0;
        int lenght = 0;
        for (int i = 1; i < points.length; i++) {
            lenght = points[i][0] - points[i-1][0];
            width += points[i-1][1];
            area += lenght * Math.abs(width);
        }
        System.out.println(area);
    }
}
