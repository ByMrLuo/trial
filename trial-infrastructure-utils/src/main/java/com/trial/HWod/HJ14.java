package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-27 15:35
 **/
public class HJ14 {
    /**
     *题目描述
     * 在一款虚拟游戏中生活，你必须进行投资以增强在虚拟游戏中的资产以免被淘汰出局。
     * 现有一家Bank，它提供有若干理财产品 m 个，风险及投资回报不同，你有 N（元）进行投资，能接收的总风险值为X。
     * 你要在可接受范围内选择最优的投资方式获得最大回报。
     * 备注：
     *     在虚拟游戏中，每项投资风险值相加为总风险值；
     *     在虚拟游戏中，最多只能投资2个理财产品；
     *     在虚拟游戏中，最小单位为整数，不能拆分为小数；
     *     投资额*回报率=投资回报
     * 输入描述
     * 第一行：
     *     产品数（取值范围[1,20]）
     *     总投资额（整数，取值范围[1, 10000]）
     *     可接受的总风险（整数，取值范围[1,200]）
     * 第二行：产品投资回报率序列，输入为整数，取值范围[1,60]
     * 第三行：产品风险值序列，输入为整数，取值范围[1, 100]
     * 第四行：最大投资额度序列，输入为整数，取值范围[1, 10000]
     * 输出描述
     * 每个产品的投资额序列
     *
     * 用例1
     * 输入
     * 5 100 10
     * 10 20 30 40 50
     * 3 4 5 6 10
     * 20 30 20 40 30
     * 输出
     * 0 30 0 40 0
     *
     * 说明
     *     投资第二项30个单位，第四项40个单位，总的投资风险为两项相加为4+6=10
     * */
    static class Product{
        int sumReturn;
        int sumRisk;
        int[] upsizeArrs;

        Product(int sumReturn, int sumRisk, int[] upsizeArrs){
            this.sumReturn = sumReturn;
            this.sumRisk = sumRisk;
            this.upsizeArrs = upsizeArrs;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int money = scanner.nextInt();
        int allRisk = scanner.nextInt();

        int[] returns = new int[number];
        for(int i = 0; i < number; i++){
            returns[i] = scanner.nextInt();
        }

        int[] risks = new int[number];
        for(int i = 0; i < number; i++){
            risks[i] = scanner.nextInt();
        }

        int[] upSizes = new int[number];
        for(int i = 0; i < number; i++){
            upSizes[i] = scanner.nextInt();
        }
        //总回报，产品
        List<HJDemo.Product> sortList = new ArrayList<>();
        for(int i = 0; i < number; i++){
            int leftReturn = returns[i];
            int leftUpSize = upSizes[i];
            int leftRisk = risks[i];

            if(leftRisk > allRisk){
                continue;
            }

            int upSize = Math.min(leftUpSize, money);

            int giveReturn = upSize * leftReturn;
            int[] arrs = new int[number];
            arrs[i] = upSize;

            HJDemo.Product product = new HJDemo.Product(giveReturn,leftRisk, arrs);
            sortList.add(product);
            for(int j = i+1; j < number; j++){
                int rightReturn = returns[j];
                int rightUpSize = upSizes[j];
                int rightRisk = risks[j];

                int sumRisk = leftRisk + rightRisk;
                if(sumRisk > allRisk){
                    continue;
                }

                if(leftReturn > rightReturn){
                    leftUpSize = Math.min(money,leftUpSize);
                    rightUpSize = Math.min(money - leftUpSize, rightUpSize);
                }else if(leftReturn < rightReturn){
                    rightUpSize = Math.min(money, rightUpSize);
                    leftUpSize = Math.min(money - rightUpSize, leftUpSize);
                }else{
                    //回报相同的时候优先投资风险小的
                    if(leftRisk <= rightRisk){
                        leftUpSize = Math.min(money,leftUpSize);
                        rightUpSize = Math.min(money - leftUpSize, rightUpSize);
                    }else{
                        rightUpSize = Math.min(money, rightUpSize);
                        leftUpSize = Math.min(money - rightUpSize, leftUpSize);
                    }
                }

                int sumReturn = leftReturn * leftUpSize + rightReturn * rightUpSize;

                int[] products = new int[number];
                products[i] = leftUpSize;
                products[j] = rightUpSize;
                HJDemo.Product product1 = new HJDemo.Product(sumReturn, sumRisk, products);
                sortList.add(product1);
            }
        }
        Collections.sort(sortList, (a, b)->{
            if(a.sumReturn == b.sumReturn){
                return a.sumRisk - b.sumRisk;
            }
            return b.sumReturn - a.sumReturn;
        });
        int[] upsizeArrs = sortList.isEmpty() ? new int[number] : sortList.get(0).upsizeArrs;
        StringJoiner sj = new StringJoiner(" ");
        for (int upsize : upsizeArrs) {
            sj.add(String.valueOf(upsize));
        }
        System.out.println(sj.toString());
    }

}
