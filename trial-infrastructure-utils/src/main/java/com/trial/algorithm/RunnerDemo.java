package com.trial.algorithm;

import java.util.*;

/**
 * @description:CyclicBarrier测试类
 * @author: Mr.Luo
 * @create: 2023-11-10 18:33
 **/
public class RunnerDemo {


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int length = nums.length;
        //数组存放最大值，为什么是length-k+1,是因为滑动窗口每次向后移动一个位置
        //总共只能移动length - k + 1次，也就只会有这么多最大值
        int[] result = new int[length - k + 1];
        //维护一个双端队列存储数据是从大到小的顺序
        Deque<Integer> queue = new LinkedList();
        //获取到第一个中的最大值
        for(int i = 0; i <= length - k; i++){
            int j = i;
            //始终将最大值放在队首，当nums[i]的值大于队首，则需要剔除掉
            if(queue.isEmpty()){
                queue.add(nums[i]);
            }
            while(j < i + k){
                if(nums[j] > queue.getFirst()){
                    queue.removeFirst();
                    queue.add(nums[j]);
                }
                j++;
            }
            //此时队列中只剩下华东窗口k中的最大值,将队列清空，将当前最大值添加到list中
            result[i] = queue.removeFirst();
        }
        System.out.println(Arrays.toString(result));
    }

}
