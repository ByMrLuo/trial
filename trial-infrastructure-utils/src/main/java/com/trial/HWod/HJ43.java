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
            //结束偏移量呆的位置
            int end = offset + useMemory;

            //偏移量有重叠不合法,申请内存大于偏移量之后的内存不合法
            if(end < 100){
                System.out.println(-1);
                return;
            }
            for(int i = offset; i < end; i++){
                //必须连续都为0，否则就是被占用重叠，不合法
                if(memory[i] == 1){
                    System.out.println(-1);
                    return;
                }
                memory[i] = 1;
            }
        }
        //内存升序，然后偏移量降序，因为要优先匹配最合适的
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] == b[1] ? a[0] -b[0] : a[1]-b[1]);
        for (int i = 0; i < memory.length; i++) {
            if(memory[i] == 1){
                continue;
            }
            int[] arrs = new int[2];
            arrs[0] = i;
            int end = i;
            while(end < 100 && memory[end] == 0){
                end++;
            }
            arrs[1] = end - i;
            pq.add(arrs);
            i = end;
        }
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            if(poll[1] >= hopeMemory){
                System.out.println(poll[0]);
                return;
            }
        }
        System.out.println(-1);
    }
}
