package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-08 00:49
 **/
public class HJ54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] strChars = str.toCharArray();

        String longStr = scanner.nextLine();
        char[] longStrChars = longStr.toCharArray();

        int longStrindex = 0;
        int strIndex = 0;
        for (int i = 0; i < longStrChars.length; i++) {
            if(strChars[strIndex] == longStrChars[i]){
                strIndex++;
                longStrindex = i;
                if(strIndex == strChars.length){
                    System.out.println(longStrindex);
                    return;
                }
            }
        }
        if(strIndex == 0){
            System.out.println(-1);
            return;
        }
        //因为最后相等之后还是会有longStrindex++;，所以要-1
        System.out.println(longStrindex);
    }
}
