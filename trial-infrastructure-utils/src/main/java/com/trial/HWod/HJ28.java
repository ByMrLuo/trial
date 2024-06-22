package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-01 15:52
 **/
public class HJ28 {
    /**
     * 题目描述
     * 给定一个二叉树，每个节点上站一个人，节点数字表示父节点到该节点传递悄悄话需要花费的时间。
     * 初始时，根节点所在位置的人有一个悄悄话想要传递给其他人，求二叉树所有节点上的人都接收到悄悄话花费的时间。
     * 输入描述
     * 给定二叉树
     *     0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2
     * 注：-1表示空节点
     *
     * 输出描述
     * 返回所有节点都接收到悄悄话花费的时间
     *     38
     *
     * 用例1
     * 输入
     * 0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2
     *
     * 输出
     * 38
     * */
    public static void main(String[] args) {
        /**
         * 这道题的重点在于记录每一个父节点的子节点的索引，，而遍历到的节点应该，
         * 重新赋值为根节点到当前节点的累加值，以此才能最后找到各个分支的最大值，确实是一个类似于广度遍历bfs的题
         * 因为下一次就会作为父节点进行各个分支的累加
         * */
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(scanner.hasNextInt()){
            int time = scanner.nextInt();
            list.add(time);
        }
        //遍历是所有节点，作为根节点
        for (int i = 0; i < list.size(); i++) {
            int root = list.get(i);
            //计算当前节点的左右子节点
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            //更新当前位置的时间，累计他之前的时间
            if(left < list.size() && list.get(left) != -1){
                list.set(left, root + list.get(left));
            }
            if(right < list.size() && list.get(right) != -1){
                list.set(right, root + list.get(right));
            }
        }
        //降序排序，最后一个就是最大时间
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }
}
