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
        int number = scanner.nextInt();
        int money = scanner.nextInt();
        int allRisk = scanner.nextInt();
        int[] returns = new int[number];
        //回报率
        for(int i = 0; i < number ;i++){
            returns[i] = Integer.valueOf(scanner.nextInt());
        }
        //风险
        int[] risks = new int[number];
        for(int i = 0; i < number ;i++){
            risks[i] = Integer.valueOf(scanner.nextInt());
        }
        //最大购买量
        int[] maxInvestments = new int[number];
        for(int i = 0; i < number ;i++){
            maxInvestments[i] = Integer.valueOf(scanner.nextInt());
        }
        //处理单个产品购买的情况
        //定义指针
        int left = 0;
        //最大回报
        int maxReturn = 0;
        //存放最佳产品组合
        int[] bestInvestments = new int[number];
        int selectedRisk = Integer.MAX_VALUE;
        while(left < number){
            if(risks[left] > allRisk){
                left++;
                continue;
            }
            //当前产品的信息
            int thisRisk = risks[left];
            int thisMaxInvestment = maxInvestments[left];
            int thisReturn = returns[left];
            int thisMaxReturn = 0;
            //判定是否当前的投资金额大于拥有的资金，
            // 如果大于那么你只能投资你拥有的金额
            if(thisMaxInvestment > money){
                thisMaxInvestment =  money;
            }
            thisMaxReturn = thisMaxInvestment * thisReturn;
            //判定最大回报是否大于当前回报，大于则进行下一次
            if(maxReturn > thisMaxReturn){
                left++;
                continue;
            }else if(maxReturn == thisMaxReturn){
                //回报等于，则选择风险小的
                if(selectedRisk <= thisRisk){
                    left++;
                    continue;
                }
            }
            //更新各个最大值，以及数组的集合
            maxReturn = thisMaxReturn;
            selectedRisk = thisRisk;
            //每次更新都要初始化，否则会遗留上一次的更新信息
            bestInvestments = new int[number];
            bestInvestments[left] = thisMaxInvestment;
            left++;
        }
        //初始化left，定义第二个变量right；
        left = 0;
        int right = 1;
        //两个组合最大
        while(left < number){
            //判定边界条件
            if(right >= number){
                left++;
                right = left + 1;
                continue;
            }
            //第一款产品信息
            int leftRisk = risks[left];
            int leftMaxInvestment = maxInvestments[left];
            int leftReturn = returns[left];
            int leftMaxReturn = 0;
            //第二款产品信息
            int rightRisk = risks[right];
            int rightMaxInvestment = maxInvestments[right];
            int rightReturn = returns[right];
            int rightMaxReturn = 0;
            //两种产品总风险
            int thisAllRisk = leftRisk + rightRisk;
            int thisAllMaxReturn = 0;
            //第一款产品大于或者等于说明当前产品不适合组合销售，直接left++
            if(leftRisk >= allRisk){
                left++;
                right = left + 1;
                continue;
            }else if(rightRisk >= allRisk || thisAllRisk > allRisk){
                //第二款产品大于或者等于说明当前产品不适合组合销售，
                // 或者两个的组合大于总风险，又因为leftRisk经过上面的条件，肯定是小雨的，那么就需要直接right++
                right++;
                continue;
            }
            //开始计算两种产品的组合，回报高的优先购买，回报低的见剩下的,如果相同，优先买风险小的
            if(leftReturn > rightReturn){
                //现货区回报高的，在他能投资的最大值和持有资金选择最小的，
                // 因为如果投资最大投资大于持有资金，那么他只能投所有的钱，
                // 如果最大投资小于持有资金，那么就对最高回报全部投资
                leftMaxInvestment = Math.min(leftMaxInvestment, money);
                //投资完最大回报的，如果有剩余就投剩下资金和最大能投资第二产品的最小值，
                //因为剩余的钱在 0~money - leftMaxInvestment，看他和第二产品的最大投资谁更小，就选哪个
                rightMaxInvestment = Math.min(money - leftMaxInvestment, rightMaxInvestment);
            }else if(leftReturn < rightReturn){
                rightMaxInvestment = Math.min(rightMaxInvestment, money);
                leftMaxInvestment = Math.min(money - rightMaxInvestment, leftMaxInvestment);
            }else if(leftRisk < rightRisk){
                leftMaxInvestment = Math.min(leftMaxInvestment, money);
                rightMaxInvestment = Math.min(money - leftMaxInvestment, rightMaxInvestment);
            }else{
                rightMaxInvestment = Math.min(rightMaxInvestment, money);
                leftMaxInvestment = Math.min(money - rightMaxInvestment, leftMaxInvestment);
            }
            //总的投资回报
            thisAllMaxReturn = leftMaxInvestment * leftReturn + rightMaxInvestment * rightReturn;
            if(maxReturn < thisAllMaxReturn){
                maxReturn = thisAllMaxReturn;
                selectedRisk = thisAllRisk;
                bestInvestments = new int[number];
                bestInvestments[left] = leftMaxInvestment;
                bestInvestments[right] = rightMaxInvestment;
            }
            right++;
        }
        for(int i : bestInvestments){
            System.out.print(i + " ");
        }
    }

}
