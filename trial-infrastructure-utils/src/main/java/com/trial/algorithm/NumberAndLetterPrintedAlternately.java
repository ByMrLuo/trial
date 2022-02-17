package com.trial.algorithm;

/**
 * @description:数字字母交替打印
 * @date: 2022/2/17 19:19
 * @author: luoziwen
 */
public class NumberAndLetterPrintedAlternately {
    private static volatile boolean flag = true;

    private static final int[] number = {0,1,2,3,4,5,6,7,8,9};

    private static final String[] letter = {"A","B","C","D","E","F","G","H","I","G"};

    private static int i = 0;

    private static int j = 0;

    public static void main(String[] args) {

        //数字
        new Thread(()->{
            while(i < 10){
                if(flag){
                    System.out.println("数字："+ number[i]);
                    i++;
                    flag = false;
                }
            }
        }).start();

        //字母
        new Thread(()->{
            while(j < 10){
                if(!flag){
                    System.out.println("字母："+ letter[j]);
                    j++;
                    flag = true;
                }
            }
        }).start();
    }
}
