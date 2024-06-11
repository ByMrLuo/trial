package com.trial.HWod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-11 23:00
 **/
public class HJ66 {
    /**
     *
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //小明身高
        int tall = scanner.nextInt();
        int number = scanner.nextInt();

        Integer[] peopleArrs = new Integer[number];
        for (int i = 0; i < number; i++) {
            peopleArrs[i] = scanner.nextInt();
        }

        Arrays.sort(peopleArrs, (a,b)->{
            int aABS = Math.abs(tall - a);
            int bABS = Math.abs(tall - b);
            if(aABS == bABS){
                return a - b;
            }
            return aABS - bABS;
        });
        StringJoiner sj = new StringJoiner(" ");
        for (Integer peopleArr : peopleArrs) {
            sj.add(String.valueOf(peopleArr));
        }
        System.out.println(sj.toString());
    }
}
