package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-11 11:05
 **/
public class HJ63 {
    /**
     *题目描述
     * 程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
     * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
     * 比如：
     *     23再多一块钱就变为25；
     *     39再多一块钱变为50；
     *     399再多一块钱变为500； 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
     * 给出计费表的表面读数，返回实际产生的费用。
     * 输入描述
     * 只有一行，数字N，表示里程表的读数。
     * (1<=N<=888888888)。
     * 输出描述
     * 一个数字，表示实际产生的费用。以回车结束。
     * 用例1
     * 输入
     * 5
     *
     * 输出
     * 4
     * 说明
     *     5表示计费表的表面读数。
     *     4表示实际产生的费用其实只有4块钱。
     *
     * 用例2
     * 输入
     * 17
     *
     * 输出
     * 15
     * 说明
     *     17表示计费表的表面读数。
     *     15表示实际产生的费用其实只有15块钱。
     *
     * 用例3
     * 输入
     * 100
     *
     * 输出
     * 81
     * 说明
     *     100表示计费表的表面读数。
     *     81表示实际产生的费用其实只有81块钱。
     * */
    public static void main(String[] args) {
        /**
         * 每遇到4就会+1，但是其他值不变，10个数中跳过4有效的只有9个
         * 类似于9进制，但是需要注意的是转换为10进制的时候并不是逢9进一
         * 而是逢4，所以这里是九进制，但是超过4的时候就要-1
         * */
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] charArrs = str.toCharArray();
        int length = charArrs.length;
        int realyCount = 0;
        for (int i = 0; i < length; i++) {
            int number = Character.getNumericValue(charArrs[i]);
            if(number > 4){
                number--;
            }
            for (int j = length - 1 - i; j > 0; j--) {
                number *= 9;
            }
            realyCount+=number;
        }
        System.out.println(realyCount);
    }
}
