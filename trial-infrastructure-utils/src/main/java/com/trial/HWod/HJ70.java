package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-12 17:03
 **/
public class HJ70 {
    /**
     *
     * */

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int x = scanner.nextInt();
//        int[] numArrs = new int[n];
//        for (int i = 0; i < n; i++) {
//            numArrs[i] = scanner.nextInt();
//        }
//
//
//    }
    public static void main(String[] args) {
        /**已经测试过前缀和会有三分之一左右的用例超时*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] numArrs = new int[n];
        for (int i = 0; i < n; i++) {
            numArrs[i] = scanner.nextInt();
        }
        int[] sumArrs = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            sumArrs[i] = sumArrs[i-1] + numArrs[i-1];
        }
        //注意这里和可能会int的上限可能不够
        long count = 0;
        int begin = 0;
        int end = 1;
        /**
         * 这里为什么选end < sumArrs.length的原因
         * 1.end结束时，如果都没有符合的那么begin++后的前缀和更不会比现在的值大，
         * 所以后续也就没必要了
         * 2.如果当前的前缀和之差已经大于x，那么就会重置begin和end，这样end就会被初始化
         * 继续寻找后续的连续前缀和，直到条件1的出现
         * */
        while(end < sumArrs.length){
            int m = sumArrs[end] - sumArrs[begin];
            /**
             * 因为数组元素都是正整数，所以便有当m>=x的时候
             * 后续如果end还有前缀和也不需要进行计算,因为begin不变，
             * m的值只会更大不会变小,所以直接添加到count就可以
             * 后面的值是sumArrs.length -1 - end + 1 = sumArrs.length- end
             * sumArrs.length - 1 - begin + 1
             * -1是最后一个前缀和的下标
             * -end就是后续还有几个符合条件的
             * +1是因为没有算当前end所在的越是符合的
             * 这里就是靠找到边界值来节省时间的
             * */
            if(m >= x){
                count += sumArrs.length - end;
                begin++;
                end = begin + 1;
                continue;
            }
            end++;
        }
        System.out.println(count);
    }
}
