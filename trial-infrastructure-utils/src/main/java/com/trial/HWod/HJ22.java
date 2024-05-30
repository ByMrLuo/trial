package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-30 14:46
 **/
public class HJ22 {
    /**
     * 题目描述
     * 现有N个任务需要处理，同一时间只能处理一个任务，处理每个任务所需要的时间固定为1。
     * 每个任务都有最晚处理时间限制和积分值，在最晚处理时间点之前处理完成任务才可获得对应的积分奖励。
     * 可用于处理任务的时间有限，请问在有限的时间内，可获得的最多积分。
     * 输入描述
     * 第一行为一个数 N，表示有 N 个任务
     *     1 ≤ N ≤ 100
     * 第二行为一个数 T，表示可用于处理任务的时间
     *     1 ≤ T ≤ 100
     * 接下来 N 行，每行两个空格分隔的整数（SLA 和 V），SLA 表示任务的最晚处理时间，V 表示任务对应的积分。
     *     1 ≤ SLA ≤ 100
     *     0 ≤ V ≤ 100000
     * 输出描述
     * 可获得的最多积分
     * 用例1
     * 输入
     * 4
     * 3
     * 1 2
     * 1 3
     * 1 4
     * 1 5
     *
     * 输出
     * 5
     *
     * 说明
     *     虽然有3个单位的时间用于处理任务，可是所有任务在时刻1之后都无效。 所以在第1个时间单位内，选择处理有5个积分的任务。1-3时无任务处理。
     *
     * 用例2
     * 输入
     * 4
     * 3
     * 1 2
     * 1 3
     * 1 4
     * 3 5
     *
     * 输出
     * 9
     *
     * 说明
     *     第1个时间单位内，处理任务3，获得4个积分
     *     第2个时间单位内，处理任务4，获得5个积分
     *     第3个时间单位内，无任务可处理
     *     共获得9个积分
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int times = scanner.nextInt();
        //根据最终时间从打大小排序
        int[][] arrs = new int[number][2];
        for (int i = 0; i < number; i++){
            int lastTime = scanner.nextInt();
            int result = scanner.nextInt();
            arrs[i][0] = lastTime;
            arrs[i][1] = result;
        }
        /**
         * 错误思路：按照最后的执行时间升序,时间相等的按照积分降序，
         * 这样看起来没问题，但是我们可以想到有一种情况是，这个完成的时间比较靠前，但是积分比较小，所以拍的靠后 (4,44)
         * 但是有的完成时间靠后，但是积分又很高；那么如果限制(9,56),我们根绝这个思路排序，
         * （4 44）尽管积分靠前应该统计，但是他的前面的任务已经花费了4个小时，这时候无法在完成，所以只能跳过，而这时（5,38）
         * 刚好可以，所以被统计那这时候积分并不是最大的，因为如果将（4,44）统计进去才对，只需要将（9，56）或者（7,49）和他调整一下完成时间即可
         * 这样才是最大的，所以这个思想的漏洞在于这里
         * 9
         * 5
         * 1 66         2 77
         * 3 22         1 66
         * 10 56        9 56
         * 4 44         7 49
         * 5 38    ==》 4 44
         * 2 77         5 38
         * 9 10         3 22
         * 7 49         8 11
         * 8 11         9 10
         * */
        //换一种思路，我们先在规定时间内完成任务，先不去管积分，
        // 然后后面根据不符合条件的积分的大，替换符合条件中的积分小的
        //这样我们得到的就是你在最多的任务重，积分最大的
        Arrays.sort(arrs,(a,b)->{return a[0] - b[0];});
        int max = 0;
        int costTime = 0;
        //设置队列积分越小优先级越高如果记不住名字就用treemap，反正都是自定义比较器
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
            return a - b;
        });
        int length = arrs.length;
        //当前循环中的考虑的是符合条件的就加入，但是并没有对于只能完成time个任务做处理
        for(int i = 0; i < length; i++){
            int lastTime  = arrs[i][0];
            int result  = arrs[i][1];
            //因为costTime是从0开始所以要截止时间大于他才证明可以完成
            //当该任务时间小于等于的时候要考虑分值大小是否可以置换
            if(lastTime > costTime){
                max += result;
                queue.offer(result);
                costTime++;
            }else{
                //大于总时间后开始比对队列中的值的大小
                int a = queue.peek();
                if(a < result){
                    queue.poll();
                    queue.offer(result);
                    max = max - a + result;
                }
            }
        }
        //进一步处理time任务超出的问题
        while(queue.size() > times){
            int result = queue.poll();
            max -= result;
        }
        System.out.println(max);
    }
}
