package com.trial.HWod;

import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-30 19:41
 **/
public class HJ23 {
    /**
     * 题目描述
     * 定义构造三叉搜索树规则如下：
     * 每个节点都存有一个数，当插入一个新的数时，从根节点向下寻找，直到找到一个合适的空节点插入。查找的规则是：
     *     如果数小于节点的数减去500，则将数插入节点的左子树
     *     如果数大于节点的数加上500，则将数插入节点的右子树
     *     否则，将数插入节点的中子树
     * 给你一系列数，请按以上规则，按顺序将数插入树中，构建出一棵三叉搜索树，最后输出树的高度。
     * 输入描述
     * 第一行为一个数 N，表示有 N 个数，1 ≤ N ≤ 10000
     * 第二行为 N 个空格分隔的整数，每个数的范围为[1,10000]
     * 输出描述
     * 输出树的高度（根节点的高度为1）
     * 用例1
     * 输入
     * 5
     * 5000 2000 5000 8000 1800
     *
     * 输出
     * 3
     *
     * 说明
     *     最终构造出的树如下，高度为3： image
     *
     * 用例2
     * 输入
     *
     * 3
     * 5000 4000 3000
     *
     * 输出
     * 3
     * 说明
     *     最终构造出的树如下，高度为3：
     *
     * 用例3
     * 输入
     * 9
     * 5000 2000 5000 8000 1800 7500 4500 1400 8100
     *
     * 输出
     * 4
     * 说明
     *     最终构造出的树如下，高度为4：
     * */
    static class Node{
        int val;
        Node left;
        Node mid;
        Node right;
        Node(int val){
            this.val = val;
        }
        Node(){

        }
    }
    //层深
    static int maxHight = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Node root = new Node();
        for(int i = 0; i < number; i++){
            int val = scanner.nextInt();
            if(i == 0){
                root.val = val;
                maxHight++;
            }else{
                joinTree(root, val, 1);
            }
        }
        System.out.println(maxHight);

    }
    public static void joinTree(Node root, int val, int hight){
        int left = root.val + 500;
        int right = root.val - 500;
        if(val > left){
            if(root.left == null){
                root.left = new Node(val);
                hight++;
            }else{
                hight++;
                joinTree(root.left, val, hight);
            }
        }else if(val < right){
            if(root.right == null){
                root.right = new Node(val);
                hight++;
            }else{
                hight++;
                joinTree(root.right, val, hight);
            }
        }else{
            if(root.mid == null){
                root.mid = new Node(val);
                hight++;
            }else{
                hight++;
                joinTree(root.mid, val, hight);
            }
        }
        maxHight = Math.max(hight, maxHight);
    }
}
