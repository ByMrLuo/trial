package com.trial.algorithm;

/**
 * @description:堆排序
 *
 *  小根堆：
 *   其中每个结点的值都不大于其孩子结点的值；
 *   Ri <= R2i+1 且 Ri <= R2i+2 (小根堆)
 *
 *  大根堆：
 *   其中每个结点的值都不小于其孩子结点的值。
 *   Ri >= R2i+1 且 Ri >= R2i+2 (大根堆)
 *
 *  其中i=1,2,…,n/2向下取整
 * @date: 2022/2/15 17:35
 * @author: luoziwen
 */
public class HeapSort {

    private static int[] littleArr = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0 } ;

    private static int[] bigArr = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0 } ;
    /**
     * 功能描述:
     * @param args
     * @return: void
     * @auther: luoziwen
     * @date: 2022/2/17 11:00
     */
    public static void main(String[] args) {
        //小根堆
        littleRootHeapSort(littleArr);
        System.out.println("==============无滴分割线================");
        //大根堆
        bigRootHeapSort(bigArr);
    }

    /**
     * 功能描述: 小根堆排序(小根堆是最后得到的数组是降序，大根堆是升序，每次对顶的)
     * @param arr
     * @return: void
     * @auther: luoziwen
     * @date: 2022/2/16 10:16
     */
    public static void littleRootHeapSort(int[] arr) {
        /**
         * 获取所有的父节点：
         * 长度为：    1  2  3  4  5  6  7
         * 最后父节点：0  1  1  2  2  3  3
         * 可知可以为父节点的索引是 最后一个父节点之前的索引
         * 最后一个父节点节点不管数组长度是奇数还是偶数都可以考（arr.length-1)/2 得到其索引
         * */
        int length = arr.length;
        //初始化排序
        for (int i = length/2; i >= 0; i--) {
            littleHeapAdjuest(arr, i, length);
        }
        // 进行n-1次循环，完成排序
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            littleHeapAdjuest(arr, 0, i);
            printPart(arr,0, length-1);
        }
    }

    /**
     * 功能描述:小根堆
     * @param arr
     * @param parentIndex
     * @param length
     * @return: void
     * @auther: luoziwen
     * @date: 2022/2/17 14:12
     */
    public static void littleHeapAdjuest(int[]arr, int parentIndex, int length){
        //左孩子
        int child = 2 * parentIndex +1;
        //暂时存放父节点
        int temp = arr[parentIndex];
        //循环替换
        while(child < length){
            //左节点小于右节点,将最小的与父节点交换
            if(child + 1 < length && arr[child] > arr[child+1]){
                child++;
            }
            //如果父节点小于他的最小子节点则直接跳出
            if(temp <= arr[child]){
                break;
            }
            // 把父节点最小的子结点的值赋给父结点
            arr[parentIndex] = arr[child];
            parentIndex = child;
            child = 2 * child + 1;
        }
        arr[parentIndex] = temp;
    }

    /**
     * 功能描述:大根堆的到的arr数据为升序
     * @param arr
     * @return: void
     * @auther: luoziwen
     * @date: 2022/2/17 14:18
     */
    public static void bigRootHeapSort(int[] arr) {
        /**
         * 获取所有的父节点：
         * 长度为：    1  2  3  4  5  6  7
         * 最后父节点：0  1  1  2  2  3  3
         * 可知可以为父节点的索引是 最后一个父节点之前的索引
         * 最后一个父节点节点不管数组长度是奇数还是偶数都可以考（arr.length-1)/2 得到其索引
         * */
        int length = arr.length;
        //初始化排序
        for (int i = length/2; i >= 0; i--) {
            bigHeapAdjuest(arr, i, length);
        }
        // 进行n-1次循环，完成排序
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            bigHeapAdjuest(arr, 0, i);
            printPart(arr,0, length-1);
        }
    }
    /**
     * 功能描述:初始化构建大根堆
     * @param arr
     * @param parentIndex
     * @param length
     * @return: void
     * @auther: luoziwen
     * @date: 2022/2/17 14:16
     */
    public static void bigHeapAdjuest(int[]arr, int parentIndex, int length){
        //获取父节点
        int temp = arr[parentIndex];
        //左子节点
        int child = parentIndex * 2 + 1;
        while (child < length){
            if(child+1 < length && arr[child] < arr[child+1]){
                child++;
            }
            //如果父节点已经是最大则直接跳出，对下一个进行遍历
            if(temp > arr[child]){
                break;
            }
            //父节点获取更大的值
            arr[parentIndex] = arr[child];
            //查找以子节点为父节点的下级节点
            parentIndex = child;
            child = 2 * child + 1;
        }
        arr[parentIndex] = temp;

    }

    // 打印序列
    public static void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }

}
