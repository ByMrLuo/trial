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
        String str = scanner.nextLine();
        String[] strArrs = str.split(" ");
        int length = strArrs.length;
        int[] allTimes = new int[length];
        for(int i = 0; i < length; i++){
            allTimes[i] = Integer.valueOf(strArrs[i]);
        }
        //存储所有的传话时长不为-1的节点，在使用时完成移除
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(0);
        int maxTime = allTimes[0];
        //不为空则一直对各项累加
        while(!queue.isEmpty()){
            Integer index = queue.removeLast();
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            /**
             * -1为空节点不必统计
             * 统计完后每次记录子节点，因为如果又下一次循环他们将作为父节点的索引对下级节点进行累加
             * */
            if(left < length && allTimes[left] != -1){
                allTimes[left] += allTimes[index];
                queue.addFirst(left);
                maxTime = Math.max(maxTime, allTimes[left]);
            }

            if(right < length && allTimes[right] != -1){
                allTimes[right] += allTimes[index];
                queue.addFirst(right);
                maxTime = Math.max(maxTime, allTimes[right]);
            }
        }
        System.out.println(maxTime);
    }
}
