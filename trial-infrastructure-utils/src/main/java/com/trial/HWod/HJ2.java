package com.trial.HWod;


import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-22 17:19
 **/
public class HJ2 {
    /**
     * 疫情期间，小明隔离在家，百无聊赖，在纸上写数字玩。他发明了一种写法：
     *
     * 给出数字个数 n （0 < n ≤ 999）和行数 m（0 < m ≤ 999），从左上角的 1 开始，
     * 按照顺时针螺旋向内写方式，依次写出2,3,....,n，最终形成一个 m 行矩阵。
     *
     * 小明对这个矩阵有些要求：
     *
     *     每行数字的个数一样多
     *     列的数量尽可能少
     *     填充数字时优先填充外部
     *     数字不够时，使用单个 * 号占位
     *  输入
     * 9 4
     *
     * 输出
     *  1 2 3
     *  * * 4
     *  9 * 5
     *  8 7 6
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] strArrs = str.split(" ");
            int number = Integer.valueOf(strArrs[0]);
            int row = Integer.valueOf(strArrs[1]);
            //求列
            int line = 0;
            if(number % row == 0){
                line = number/row;
            }else{
                line = number/row + 1;
            }
            String[][] secondArrays = new String[row][line];
            int top = 0;
            int botton = row-1;
            int left = 0;
            int right = line-1;
            int count = 1;
            for(;;){
                if(left > right){
                    break;
                }
                //从左到右
                for(int i = left; i <= right;i++){
                    if(count <= number){
                        secondArrays[top][i] = (count++) +"";
                    }else{
                        secondArrays[top][i] = "*";
                    }
                }
                top++;
                if(top > botton){
                    break;
                }
                //从上到下
                for(int i = top; i <= botton; i++){
                    if(count <= number){
                        secondArrays[i][right] = (count++) +"";
                    }else{
                        secondArrays[i][right] = "*";
                    }
                }
                right--;
                if(left > right){
                    break;
                }
                //从右到左
                for(int i = right; i >= left; i--){
                    if(count <= number){
                        secondArrays[botton][i] = (count++) +"";
                    }else{
                        secondArrays[botton][i] = "*";
                    }
                }
                botton--;
                if(top > botton){
                    break;
                }
                //从下到上
                for(int i = botton; i >= top; i--){
                    if(count <= number){
                        secondArrays[i][left] = (count++) +"";
                    }else{
                        secondArrays[i][left] = "*";
                    }
                }
                left++;
            }
            for(int i= 0; i < row; i++){
                for(int j = 0;j < line; j++){
                    System.out.print(secondArrays[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
}
