package com.trial.HWod;


import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-26 23:54
 **/
public class HJ13 {
    /**
     *题目描述
     * 现代计算机系统中通常存在多级的存储设备，针对海量 workload 的优化的一种思路是将热点内存页优先放到快速存储层级，这就需要对内存页进行冷热标记。
     * 一种典型的方案是基于内存页的访问频次进行标记，如果统计窗口内访问次数大于等于设定阈值，则认为是热内存页，否则是冷内存页。
     * 对于统计窗口内跟踪到的访存序列和阈值，现在需要实现基于频次的冷热标记。内存页使用页框号作为标识。
     *
     * 输入描述
     * 第一行输入为 N，表示访存序列的记录条数，0 < N ≤ 10000。
     * 第二行为访存序列，空格分隔的 N 个内存页框号，页面号范围 0 ~ 65535，同一个页框号可能重复出现，出现的次数即为对应框号的频次。
     * 第三行为热内存的频次阈值 T，正整数范围 1 ≤ T ≤ 10000。
     * 输出描述
     * 第一行输出标记为热内存的内存页个数，如果没有被标记的热内存页，则输出 0 。
     * 如果第一行 > 0，则接下来按照访问频次降序输出内存页框号，一行一个，频次一样的页框号，页框号小的排前面。
     *
     * 用例1
     * 输入
     * 10
     * 1 2 1 2 1 2 1 2 1 2
     * 5
     * 输出
     * 2
     * 1
     * 2
     * 说明
     *     内存页1和内存页2均被访问了5次，达到了阈值5，因此热内存页有2个。内存页1和内存页2的访问频次相等，页框号小的排前面。
     * */
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int size = scanner.nextInt();
        String[] strArrs = str.split(" ");
        int hot = 0;
        int[] arrs = new int[num];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num; i++){
            Integer no = Integer.valueOf(strArrs[i]);
            arrs[i] = no;
            if(map.containsKey(no)){
                int count = map.get(no);
                map.put(no, ++count);
            }else{
                map.put(no,1);
            }
        }
        Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o2.getValue().equals(o1.getValue())){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        };
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() >= size){
                list.add(entry);
            }
        }
        Collections.sort(list, comparator);
        System.out.println(list.size());
        for(Map.Entry<Integer,Integer> entry : list){
            System.out.println(entry.getKey());
        }
    }
}
