package com.trial.algorithm;

/**
 * @description:水壶问题（贝祖定理）
 * @date: 2022/3/7 16:40
 * @author: luoziwen
 */
public class TheKettleProblem {

    /**
     * 功能描述:
     * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
     *
     * 你允许：
     * 装满任意一个水壶
     * 清空任意一个水壶
     * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
     * @auther: luoziwen
     * @date: 2022/3/7 16:43
     */
    public static void main(String[] args) {
        /**
         * 贝祖定理 mx + ny = z
         * 那么z一定是x和y的最大公约数的倍数(m,n为整数)
         */
        /**
         * 上述问题有一下几种可能：
         * 假设现在x和y均为空，那么操作对水产生的影响就是+x，或者+y。
         * 假设现在x和y均为满，那么操作对水产生的影响就是-x，-y。
         * 假设x是满的，y是空的，那么操作产生的影响应该是-x，或者+y。
         * 假设x是空的，y是满的，那么操作产生的影响应该就是+x，或者-y。
         * 假设x不空不满，y是空的，那么操作产生的是+y，为什么呢？ 难道不可能是将x倒掉，或者将x倒满，吗？其实这种操作无意义，因为将x倒掉，等于初始x就是空的情况，将x加满，等于初始状态x就是满的情况。
         * 假设x不空不满，y是满的，根据上面的推论，应该是-y。
         * 假设x是满的，y是不空不满的，应该是-x。
         * 假设x是空的，y是不空不满的，应该+x。
         * 假设x不空不满，y不空不满，这种情况是不存在的，因为根据已知的操作，必须有一个壶是空的或满的。
         */

    }

    private static  boolean canMeasureWater(int x, int y, int z){

        if(x < 0 || y < 0 || z < 0){
            return false;
        }
        if(x + y < z){
            return false;
        }
        if(x == 0 || y == 0){
            return z==0 || x+y == z;
        }

        return z % gcd(x, y) == 0;
    }

    private static int gcd(int x, int y){
        int temp = x % y;
        while(temp != 0){
            x = y;
            y = temp;
            temp = x % y;
        }
        return y;
    }
}
