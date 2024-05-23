package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-22 18:43
 **/
public class HJ3 {
    /**
     * 题目描述
     * 在一颗树中，每个节点代表一个家庭成员，节点的数字表示其个人的财富值，一个节点及其直接相连的子节点被定义为一个小家庭。
     * 现给你一颗树，请计算出最富裕的小家庭的财富和。
     * 输入描述
     * 第一行为一个数 N，表示成员总数，成员编号 1~N。1 ≤ N ≤ 1000
     * 第二行为 N 个空格分隔的数，表示编号 1~N 的成员的财富值。0 ≤ 财富值 ≤ 1000000
     * 接下来 N -1 行，每行两个空格分隔的整数（N1, N2），表示 N1 是 N2 的父节点。
     * 输出描述
     * 最富裕的小家庭的财富和
     *
     * 用例1
     * 输入
     * 4
     * 100 200 300 500
     * 1 2
     * 1 3
     * 2 4
     * 输出
     * 700
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] money = new int[n];
        int[] home = new int[n];
        for(int i = 0; i < n; i++){
            home[i] = scanner.nextInt();
            money[i] = home[i];
        }
        for(int i =0;i < n-1;i++){
            int partent = scanner.nextInt();
            int son = scanner.nextInt();
            money[partent-1] += home[son-1];
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, money[i]);
        }

        System.out.println(max);
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = Integer.valueOf(scanner.nextLine());
//        int[] monsyArrs = new int[num];
//        String str = scanner.nextLine();
//        String[] arrs = str.split(" ");
//        for(int i = 0; i< arrs.length; i++){
//            monsyArrs[i] = Integer.valueOf(arrs[i]);
//        }
//        Map<Integer, List<Integer>> map= new HashMap();
//        while(num-1 > 0){
//            String s = scanner.nextLine();
//            String[] sArrs = s.split(" ");
//            int key = Integer.valueOf(sArrs[0]);
//            int value = Integer.valueOf(sArrs[1]);
//            if(map.containsKey(key)){
//                List<Integer> list = map.get(key);
//                list.add(monsyArrs[value - 1]);
//            }else{
//                List<Integer> list = new ArrayList<>();
//                list.add(monsyArrs[key -1]);
//                list.add(monsyArrs[value -1]);
//                map.put(key, list);
//            }
//            num--;
//        }
//        int max = 0;
//        if(num == 1){
//            System.out.println(monsyArrs[num-1]);
//        }else{
//            Set<Integer> set = map.keySet();
//            for(Integer key: set){
//                List<Integer> list = map.get(key);
//                int count = 0;
//                for(Integer val:list){
//                    count += val;
//                }
//                max = Math.max(max, count);
//            }
//            System.out.println(max);
//        }
//    }
}
