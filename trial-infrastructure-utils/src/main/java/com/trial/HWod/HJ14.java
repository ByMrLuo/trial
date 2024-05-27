package com.trial.HWod;

import java.util.Scanner;

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //产品数量
        int number = scanner.nextInt();
        //拥有资金
        int money = scanner.nextInt();
        //总风险
        int allRisk = scanner.nextInt();
        scanner.nextLine();
        //产品回报率集合
        int[] returns = new int[number];
        for(int i = 0; i < number; i++){
            returns[i] = scanner.nextInt();
        }
        //各个产品的风险
        int[] risks = new int[number];
        for(int i = 0; i < number; i++){
            risks[i] = scanner.nextInt();
        }
        //各个最大投资额度
        int[] maxInvestments  = new int[number];
        for(int i = 0; i < number; i++){
            maxInvestments[i] = scanner.nextInt();
        }
        //最大回报
        int maxReturnMoney = 0;
        //对应的风险
        int selectedRisk = 0;
        //最佳投资方案
        int[] bestInvestmentPlan = new int[number];
        int left = 0;
        int right = 0;
        //单个产品投资最大，和组合最大两部分
        while(left < number){
            //当前产品的风险
            int thisRisk = risks[left];
            //最大投资金额
            int thismaxInvestment = maxInvestments[left];
            //回报率
            int thisReturn = returns[left];
            //风险超出直接下一个
            if(thisRisk > allRisk){
                left++;
                continue;
            }
            //如果最大投资金额超过当前拥有的金额那么你最大只能投资你拥有的金额
            if(thismaxInvestment >= money){
                thismaxInvestment = money;
            }

            int thisMaxReturn = thismaxInvestment * thisReturn;
            //当回报相等，风险之前的和现在的小于等于，不变更
            if((thisMaxReturn == maxReturnMoney && selectedRisk <= thisRisk) || thisMaxReturn < maxReturnMoney){
                left++;
                continue;
            }
            bestInvestmentPlan = new int[number];
            //大于则重置最大值
            selectedRisk = thisRisk;
            maxReturnMoney = thisMaxReturn;
            bestInvestmentPlan[left] = thismaxInvestment;
            left++;
        }
        //两个组合的最优选择
        left = 0;
        right = 1;
        while(left < number ){
            //判定快指针的边界
            if(right >= number){
                left++;
                right = left+1;
                continue;
            }
            //left当前产品的风险
            int leftRisk = risks[left];
            //left最大投资金额
            int leftmaxInvestment = maxInvestments[left];
            //left回报率
            int leftReturn = returns[left];

            //right当前产品的风险
            int rightRisk = risks[right];
            //right最大投资金额
            int rightmaxInvestment = maxInvestments[right];
            //right回报率
            int rightReturn = returns[right];
            //超出的组合直接略过
            if(leftRisk + rightRisk > allRisk){
                right++;
                continue;
            }
            //当前产品的风险
            int thisRisk = leftRisk + rightRisk;

            //上面已经处理了钱不管是否剩余都只买一种产品的情况，现在要考虑肯定可以买两种产品的情况
            if(money - leftmaxInvestment <= 0 && money - rightmaxInvestment <= 0 ){
                right++;
                continue;
            }
            //最大投资金额
            int thismaxInvestment = leftmaxInvestment + rightmaxInvestment;
            //只考虑大于资金
            if(thismaxInvestment > money){
                //回报率高的优先拉满
                if(leftReturn > rightReturn){
                    //剩余的给回报小的，如果是负数则为0
                    rightmaxInvestment = Math.max(money - leftmaxInvestment, 0);
                    //回报高的也要确定最多购买量是否超过money，如果超过只能买money
                    leftmaxInvestment = Math.min(leftmaxInvestment, money);
                }else if(leftReturn < rightReturn){
                    leftmaxInvestment = Math.max(money - rightmaxInvestment, 0);
                    rightmaxInvestment = Math.min(rightmaxInvestment, money);
                }else if(leftRisk < rightRisk){
                    //回报相等，优先买风险小的
                    rightmaxInvestment = Math.max(money - leftmaxInvestment, 0);
                    //风险小的的也要确定最多购买量是否超过money，如果超过只能买money
                    leftmaxInvestment = Math.min(leftmaxInvestment, money);
                }else{
                    leftmaxInvestment = Math.max(money - rightmaxInvestment, 0);
                    rightmaxInvestment = Math.min(rightmaxInvestment, money);
                }
            }
            //最大回报金额
            int thisMaxReturn = rightmaxInvestment * rightReturn + leftmaxInvestment * leftReturn;
            //当回报相等，风险之前的和现在的小于等于，或者当前回报小于最大回报直接开始下一组统计
            if((thisMaxReturn == maxReturnMoney && selectedRisk <= thisRisk) || thisMaxReturn < maxReturnMoney){
                right++;
                continue;
            }
            //大于则重置最大值
            selectedRisk = thisRisk;
            maxReturnMoney = thisMaxReturn;
            bestInvestmentPlan = new int[number];
            bestInvestmentPlan[left] = leftmaxInvestment;
            bestInvestmentPlan[right] = rightmaxInvestment;
            right++;
        }

        for (int best : bestInvestmentPlan){
            System.out.print(best + " ");
        }
    }

}
