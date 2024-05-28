package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-28 16:06
 **/
public class HJ16 {
    /**
     *围棋棋盘由纵横各19条线垂直相交组成，棋盘上一共19 x 19 = 361 个交点，对弈双方一方执白棋，一方执黑棋，落子时只能将棋子置于交点上。
     * “气”是围棋中很重要的一个概念，某个棋子有几口气，是指其上下左右方向四个相邻的交叉点中，有几个交叉点没有棋子，由此可知：
     *     在棋盘的边缘上的棋子最多有 3 口气（黑1），在棋盘角点的棋子最多有2口气（黑2），其他情况最多有4口气（白1）
     *     所有同色棋子的气之和叫做该色棋子的气，需要注意的是，同色棋子重合的气点，对于该颜色棋子来说，只能计算一次气，比如下图中，黑棋一共4口气，而不是5口气，因为黑1和黑2中间红色三角标出来的气是两个黑棋共有的，对于黑棋整体来说只能算一个气。
     *     本题目只计算气，对于眼也按气计算，如果您不清楚“眼”的概念，可忽略，按照前面描述的规则计算即可。
     * 现在，请根据输入的黑棋和白棋得到坐标位置，计算黑棋和白棋一共各有多少气？
     *
     * 输入描述
     * 输入包含两行数据，如：
     *     0 5 8 9 9 10
     *     5 0 9 9 9 8
     *     每行数据以空格分隔，数据个数是2的整数倍，每两个数是一组，代表棋子在棋盘上的坐标；
     *     坐标的原点在棋盘左上角点，第一个值是行号，范围从0到18；第二个值是列号，范围从0到18。
     *     举例说明：第一行数据表示三个坐标（0, 5）、(8, 9)、(9, 10)
     *     第一行表示黑棋的坐标，第二行表示白棋的坐标。
     *     题目保证输入两行数据，无空行且每行按前文要求是偶数个，每个坐标不会超出棋盘范围。
     *
     * 输出描述
     *     8 7
     * 两个数字以空格分隔，第一个数代表黑棋的气数，第二个数代表白棋的气数。
     * 用例1
     * 输入
     * 0 5 8 9 9 10
     * 5 0 9 9 9 8
     *
     * 输出
     * 8 7
     *
     * 说明
     *     如果将输入数据放到棋盘上
     *     数数黑棋一共8口气，数数白棋一共7口气。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String blackStr = scanner.nextLine();
        String writeStr = scanner.nextLine();
        String[] blackStrArrs = blackStr.split(" ");
        String[] writeStrArrs = writeStr.split(" ");
        int[][] arrs = new int[19][19];
        //黑子为1
        for(int i = 0; i < blackStrArrs.length; i= i+2){
            int row = Integer.valueOf(blackStrArrs[i]);
            int line = Integer.valueOf(blackStrArrs[i+1]);
            arrs[row][line] = 1;
        }
        //白子为2
        for(int i = 0; i < writeStrArrs.length; i= i+2){
            int row = Integer.valueOf(writeStrArrs[i]);
            int line = Integer.valueOf(writeStrArrs[i+1]);
            arrs[row][line] = 2;
        }
        int black = 0;
        int write = 0;
        //当前气是否被上下左右任意同种颜色统计过
        boolean isBlackNotCount = true;
        boolean isWriteNotCount = true;
        for (int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                //存在棋子就不可能是气直接跳过，只计算没有棋子，是否可能是气的时候
                if(arrs[i][j] == 1 || arrs[i][j] == 2){
                    continue;
                }
                //查看当前位置上 下 左 右 是否存在棋子，
                // 不论同种颜色有几个都只能算一口气因为同种多个说明是是共用的
                //上
                if(i - 1 >= 0 && arrs[i-1][j] == 1 && isBlackNotCount){
                    black++;
                    isBlackNotCount = false;
                }else if(i - 1 >= 0 && arrs[i-1][j] == 2 && isWriteNotCount){
                    write++;
                    isWriteNotCount = false;
                }
                //下
                if(i + 1 < 19 && arrs[i+1][j] == 1 && isBlackNotCount){
                    black++;
                    isBlackNotCount = false;
                }else if(i + 1 < 19 && arrs[i+1][j] == 2 && isWriteNotCount){
                    write++;
                    isWriteNotCount = false;
                }
                //左
                if(j - 1 >= 0 && arrs[i][j-1] == 1 && isBlackNotCount){
                    black++;
                    isBlackNotCount = false;
                }else if(j - 1 >= 0 && arrs[i][j-1] == 2 && isWriteNotCount){
                    write++;
                    isWriteNotCount = false;
                }
                //右
                if(j + 1 < 19 && arrs[i][j+1] == 1 && isBlackNotCount){
                    black++;
                    isBlackNotCount = false;
                }else if(j + 1 < 19 && arrs[i][j+1] == 2 && isWriteNotCount){
                    write++;
                    isWriteNotCount = false;
                }
                //初始化供下一个气点使用
                isWriteNotCount = true;
                isBlackNotCount = true;
            }
        }
        System.out.print(black);
        System.out.print(" ");
        System.out.print(write);
    }
}
