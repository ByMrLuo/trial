package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-25 16:02
 **/
public class HJH78 {
    /**
     *给出一个二叉树如下图所示：
     * 请由该二叉树生成一个新的二叉树，它满足其树中的每个节点将包含原始树中的左子树和右子树的和。
     * 左子树表示该节点左侧叶子节点为根节点的一颗新树；右子树表示该节点右侧叶子节点为根节点的一颗新树。
     * 输入描述
     * 2行整数，第1行表示二叉树的中序遍历，第2行表示二叉树的前序遍历，以空格分割
     * 例如：
     *     7 -2 6 6 9
     *     6 7 -2 9 6
     *
     * 输出描述
     * 1行整数，表示求和树的中序遍历，以空格分割
     * 例如：
     *     -2 0 20 0 6
     *
     * 用例1
     * 输入
     * -3 12 6 8 9 -10 -7
     * 8 12 -3 6 -10 9 -7
     *
     * 输出
     * 0 3 0 7 0 2 0
     * */
    static class Node {
        int val;
        int sum;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    static Map<Integer, List<Integer>> map;
    static int[]  midArrs;
    static int[]  beforArrs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * 中序遍历数组
         * */
        String midStr = scanner.nextLine();
        String[] midStrArrs = midStr.split(" ");
        midArrs = new int[ midStrArrs.length];
        for (int i = 0; i < midStrArrs.length; i++) {
            midArrs[i] = Integer.valueOf(midStrArrs[i]);
        }

        /**
         * 前序遍历数组
         * */
        String beforStr = scanner.nextLine();
        String[] beforStrArrs = beforStr.split(" ");
        beforArrs = new int[beforStrArrs.length];
        for (int i = 0; i < beforStrArrs.length; i++) {
            beforArrs[i] = Integer.valueOf(beforStrArrs[i]);
        }

        map = new HashMap<>();
        for (int i = 0; i < midArrs.length; i++) {
            List<Integer> list = map.getOrDefault(midArrs[i], new ArrayList<Integer>());
            list.add(i);
            map.put(midArrs[i], list);
        }
        //构建二叉树
        Node root = bulidNode(0, beforArrs.length - 1, 0, midArrs.length - 1);
        StringJoiner sj = new StringJoiner(" ");
        //深度优先中序遍历
        dfs(root, sj);
        System.out.println(sj.toString());
    }

    private static Node bulidNode(int befL, int befR, int midL, int midR){
        if(befL > befR){
            return null;
        }
        /**
         * 通过前序遍历的特点拿到根节点,然后通过根节点的值找到在中序遍历中的索引
         * 然后开始发起递归构建
         * */
        Node root = new Node(beforArrs[befL]);
        List<Integer> list = map.get(root.val);
        /**
         * 因为节点中的值可能不唯一，但是构成前中序遍历的结果只能是一个不符合的直接跳过
         */
        for (Integer index : list) {
            if(index < midL || index > midR){
                continue;
            }
            /**左子树,做右子树都相等才说明这个node是根节点，且位置正确*/
            int leftLength = index - midL;
            if(!isEquals(midL, befL + 1, leftLength)){
                continue;
            }
            /**右子树*/
            int rightLength = midR - index;
            if(!isEquals(index + 1, befL + leftLength + 1, rightLength)){
                continue;
            }

            /**递归查找下级节点的根节点，并构建拼接*/
            root.left = bulidNode(befL + 1, befL + leftLength, midL, index - 1);
            root.right = bulidNode(befL+ leftLength + 1, befR, index + 1, midR);
            /**一旦有一组成功就可以退出，因为正确的位置只有一种是唯一的*/
            root.sum = (root.left == null ? 0 : root.left.val + root.left.sum ) +
                        (root.right == null ? 0 : root.right.val + root.right.sum );
            break;
        }
        return root;
    }

    /**
     * 比较 mid和bef数组中的这一部分是否元素和个数都是相同的，
     * 相同说明是一个分支，否则是不同分支
     * @param midIndex 起始索引
     * @param befIndex 起始索引
     * @param length 元素长度
     * @return
     */
    private static boolean isEquals(int midIndex, int befIndex, int length){
        int[] arr1 = Arrays.copyOfRange(midArrs, midIndex, midIndex + length);
        int[] arr2 = Arrays.copyOfRange(beforArrs, befIndex, befIndex + length);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    /**中序遍历*/
    private static void dfs(Node root, StringJoiner sj){
        if(root == null){
            return;
        }
        dfs(root.left, sj);
        sj.add(String.valueOf(root.sum));
        dfs(root.right, sj);
    }
}
