package com.trial.algorithm;

/**
 * @description打家劫舍
 * @date: 2022/3/10 10:33
 * @author: luoziwen
 */
public class Plunder {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     *
     *输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * 边界：
     * 只有1个房子，那就是它本身
     * 有两个房子选最大的
     *
     * 考虑到每间房屋的最高总金额，只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
     * */
    public static void main(String[] args) {
        rollArray();
        maxArray();
    }


    /**滚动数组*/
    private static void rollArray(){
        int[] arr = {1,8,5,6,4,3,8,5};
        if (arr == null || arr.length == 0) {
            System.out.println(0);
        }
        //边界：只有一间房
        if(arr.length == 1){
            System.out.println(arr[0]);
        }
        //边界：只有两间房
        if(arr.length == 2){
            System.out.println(Math.max(arr[0],arr[1]));
        }
        int first = arr[0];
        int second = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int temp = second;
            second = Math.max(first + arr[i], second);
            first = temp;
        }
        System.out.println("最高金额：" + second);
        System.out.println("====================================");
    }

    /**数组记录获取最大值*/
    private static void maxArray(){
        int[] arr = {1,8,5,6,4,3,8,5};
        if (arr == null || arr.length == 0) {
            System.out.println(0);
        }
        //边界：只有一间房
        if(arr.length == 1){
            System.out.println(arr[0]);
        }
        //存放新的值
        int[] newArray = new int[arr.length];
        newArray[0] = arr[0];
        newArray[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            newArray[i] = Math.max(newArray[i-2] + arr[i], newArray[i-1]);
        }
        System.out.println(newArray[newArray.length - 1]);
        System.out.println();
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + ",");
        }
    }
}
