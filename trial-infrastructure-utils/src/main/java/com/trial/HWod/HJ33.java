package com.trial.HWod;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-03 15:00
 **/
public class HJ33 {
    /**
     *题目描述
     * 给定长度为 n 的无序的数字数组，每个数字代表二叉树的叶子节点的权值，数字数组的值均大于等于1。
     * 请完成一个函数，根据输入的数字数组，生成哈夫曼树，并将哈夫曼树按照中序遍历输出。
     * 为了保证输出的二叉树中序遍历结果统一，增加以下限制：
     *     二叉树节点中，左节点权值小于右节点权值，根节点权值为左右节点权值之和。当左右节点权值相同时，左子树高度小于等于右子树高度。
     * 注意：
     *     所有用例保证有效，并能生成哈夫曼树。
     * 提醒：
     *     哈夫曼树又称为最优二叉树，是一种带权路径长度最短的二叉树。
     *     所谓树的带权路径长度，就是树中所有的叶节点的权值乘上其到根节点的路径长度（若根节点为 0 层，叶节点到根节点的路径长度为叶节点的层数）
     *
     * 输入描述
     * 例如：由叶子节点：5 15 40 30 10，生成的最优二叉树如下图所示，该树的最短带权路径长度为：40 * 1 + 30 * 2 + 5 * 4 + 10 * 4 = 205。
     *
     * 输出描述
     * 输出一个哈夫曼树的中序遍历数组，数值间以空格分隔
     * 用例1
     * 输入
     * 5
     * 5 15 40 30 10
     *
     * 输出
     * 40 100 30 60 15 30 5 15 10
     *
     * 说明
     *     根据输入，生成哈夫曼树，按照中序遍历返回。所有节点中，左节点权值小于等于右节点权值之和。当左右节点权值相同时，左子树高度小于右子树。结果如上图所示。
     * */
    static class Node{
        Node left;
        Node right;
        int weight;
        int hight;
        Node(int weight){
            this.weight = weight;
        }
        Node(Node left, Node right,int weight, int hight){
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.hight = hight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        //升序排列
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a,b)->{
            /**
             * 这里需要注意：如题中所说，左权重小于有权重，当权重相等时，左层高<=右层高，这里程序如果这样判断，会有问题
             * if(a.weight == b.weight){
             *     return  b.hight - a.hight;
             *  }
             *  我们加入节点的时候层高必然都是为0的，那么在按照上面的代码，我们会有如下情况【weight，hight】
             *  【20,0】，【60,0】【80,0】【80,0】【160,0】【240,0】
             *  在第一次按照哈夫曼的固定规则生成新节点后（每次选其中最小的两个组合，求和生成新节点，并加入优先队列），
             *  就会重新赋予层高，那么必然有【20,0】，【60,0】生成【80,1】，放入优先队列后，根据题意排序的顺序必然有
             *  【80,0】【80,0】【80,1】【240,0】那么下两个组合就会是【80,0】【80,0】生成【160，1】
             *  成为【80,1】【160,1】【240,0】但是实际上这并非唯一，
             * */
            if(a.weight == b.weight){
                return a.hight - b.hight;
            }
            return a.weight - b.weight;
        });
        //先添加节点
        for(int i = 0; i<number; i++){
            int weight = scanner.nextInt();
            Node node = new Node(weight);
            queue.add(node);
        }
        //只剩一个的时候说明是根节点
        while(queue.size() != 1){
            Node first = queue.poll();
            Node second = queue.poll();
            int weight = first.weight + second.weight;
            //当权重一样时我们应选层级最大的+1
            int hight = Math.max(first.hight, second.hight) + 1;
            Node node = new Node(first, second, weight, hight);
            queue.add(node);
        }
        //取出最后的一个节点就是根节点
        StringBuffer sb = new StringBuffer();
        Node root = queue.poll();
        //开始dfs中序遍历
        method(root, sb);
        System.out.println(sb.toString());

    }
    //递归拼接字符串
    private static void method(Node root, StringBuffer sb){
        if(root == null){
            return;
        }
        //左
        method(root.left, sb);
        //中
        sb.append(root.weight);
        sb.append(" ");
        //右
        method(root.right, sb);
    }
}
