package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-11 19:22
 **/
public class HJ64 {
    /**
     *
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        //现判断是不是素数本身
        if(isPrime(number)){
            System.out.println("-1 -1");
        }
        //不是素数就去找两个因数是素数的结果
        double sqrt = Math.sqrt(number);
        for(int i = 2; i < sqrt; i++){
            //首先其中的要是素数，其次可以被整除，整除的数也要是素数，
            // 有则结束并输出，没有则执行后续逻辑
            if(isPrime(i) && number % i == 0 && isPrime(number/i)){
                System.out.println(i+" "+number/i);
                return;
            }
        }
        System.out.println("-1 -1");
    }

    private static boolean isPrime(long i){
        if(i < 1){
            return false;
        }
        /**
         * 符合条件的因数其中一个必定不会大于他的平方根，因为两个个平方根形成就是这个数本身，
         * 所以其中一个的最大值必定在这之内
         * */
        double sqrt = Math.sqrt(i);
        for(int j = 2; j <= sqrt; j++){
            //如果被整除说明不是素数存在出1和自身以外的因数
            if(i % j == 0){
                return false;
            }
        }
        return true;
    }
}
