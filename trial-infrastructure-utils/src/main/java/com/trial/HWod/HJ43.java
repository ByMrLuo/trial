package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-06 16:52
 **/
public class HJ43 {
    /**
     * 题目描述
     * 有一个总空间为100字节的堆，现要从中新申请一块内存，内存分配原则为：优先紧接着前一块已使用内存，分配空间足够且最接近申请大小的空闲内存。
     * 输入描述
     * 第1行是1个整数，表示期望申请的内存字节数
     * 第2到第N行是用空格分割的两个整数，表示当前已分配的内存的情况，每一行表示一块已分配的连续内存空间，
     * 每行的第1和第2个整数分别表示偏移地址和内存块大小，如：
     *     0 1
     *     3 2
     * 表示 0 偏移地址开始的 1 个字节和 3 偏移地址开始的 2 个字节已被分配，其余内存空闲。
     * 输出描述
     * 若申请成功，输出申请到内存的偏移；
     * 若申请失败，输出 -1。
     * 备注
     *     若输入信息不合法或无效，则申请失败
     *     若没有足够的空间供分配，则申请失败
     *     堆内存信息有区域重叠或有非法值等都是无效输入
     * 用例1
     * 输入
     * 1
     * 0 1
     * 3 2
     *
     * 输出
     * 1
     *
     * 说明
     *     堆中已使用的两块内存是偏移从0开始的1字节和偏移从3开始的2字节，
     *     空闲的两块内存是偏移从1开始2个字节和偏移从5开始95字节，
     *     根据分配原则，新申请的内存应从1开始分配1个字节，所以输出偏移为1。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //希望申请堆内存
        int hopeMemory = scanner.nextInt();
        if(hopeMemory > 100 || hopeMemory < 0){
            System.out.println(-1);
           return;
        }
        int[] memory = new int[100];
        while(scanner.hasNextInt()){
            int offset = scanner.nextInt();
            int useMemory = scanner.nextInt();
            if(offset < 0 || useMemory < 0 || offset >= 100 || useMemory > 100){
                System.out.println(-1);
                return;
            }
            //偏移量有重叠不合法,申请内存大于偏移量之后的内存不合法
            if(memory[offset] == 1 || useMemory > 100 - offset){
                System.out.println(-1);
                return;
            }
            //结束偏移量呆的位置
            int end = offset + useMemory;

            for(int i = offset; i < end; i++){
                //必须连续都为0，否则就是被占用重叠，不合法
                if(memory[i] == 1){
                    System.out.println(-1);
                    return;
                }
                memory[i] = 1;
            }
        }
        HashMap<Integer, Integer> offsetAndMemory = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            if(memory[i] == 1){
                continue;
            }
            int countMemory = 0;
            for(int j = i; j < 100; j++){
                if(memory[j] == 1){
                    i = j + 1;
                    break;
                }
                countMemory++;
                //记录offset和空闲的memory
                offsetAndMemory.put(i, countMemory);
                //这里存在边界问题，如果j=length-1还是0那么i将不会被重新赋值j+1，
                // 而是退出了循环，那这样外层循环就会从第二个0开始一直到1或者到数组结束
                // 不断地添加错误的值到map中，导致后续的排序完全失效
                if(j == 99){
                    i = j + 1;
                }
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> sortList = new ArrayList<>(offsetAndMemory.entrySet());
        //优先根据内存升序，然后内存相等的按照offset升序
        Collections.sort(sortList, (a,b)->{
            if(a.getValue().equals(b.getValue())){
                return a.getKey() -b.getKey();
            }
            return a.getValue() - b.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : sortList) {
            int o = entry.getKey();
            int m = entry.getValue();
            if(m >= hopeMemory){
                System.out.println(o);
                return;
            }
        }
        System.out.println(-1);
    }
}
