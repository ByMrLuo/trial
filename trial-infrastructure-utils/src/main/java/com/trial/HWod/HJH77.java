package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-25 00:14
 **/
public class HJH77 {
    /**
     *题目描述
     * 一个局域网内有很多台电脑，分别标注为 0 ~ N-1 的数字。相连接的电脑距离不一样，所以感染时间不一样，感染时间用 t 表示。
     * 其中网络内一台电脑被病毒感染，求其感染网络内所有的电脑最少需要多长时间。如果最后有电脑不会感染，则返回-1。
     * 给定一个数组 times 表示一台电脑把相邻电脑感染所用的时间。
     * 如图：path[i] = {i, j, t} 表示：电脑 i->j，电脑 i 上的病毒感染 j，需要时间 t。
     * 输入描述
     * 4
     * 3
     * 2 1 1
     * 2 3 1
     * 3 4 1
     * 2
     *
     * 输出描述
     * 2
     *
     * 用例1
     * 输入
     * 4
     * 3
     * 2 1 1
     * 2 3 1
     * 3 4 1
     * 2
     *
     * 输出
     * 2
     *
     * 说明
     *     第一个参数：局域网内电脑个数N，1 ≤ N ≤ 200；
     *     第二个参数：总共多少条网络连接
     *     第三个 2 1 1 表示2->1时间为1
     *     第六行：表示病毒最开始所在电脑号2
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int all = scanner.nextInt();
        int num = scanner.nextInt();
        /**
         * path[i] = {i, j, t} 表示：电脑 i->j，电脑 i 上的病毒感染 j，需要时间 t
         * */
        /**邻接表*/
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            //出发点
            int begin = scanner.nextInt();
            //目标点
            int end = scanner.nextInt();
            //消耗时间
            int costTime = scanner.nextInt();
            List<int[]> list = map.getOrDefault(begin, new ArrayList<int[]>());
            list.add(new int[]{end, costTime});
            map.put(begin, list);
        }

        //病毒最初的位置
        int init = scanner.nextInt();
        /**
         * 为什么是+1是因为没有0号的电脑，为了对应索引所以+1(布尔类型默认是false)
         */
        boolean[] shorts = new boolean[all + 1];

        //起始点到i节点最小的花费时间
        int[] dist = new int[all + 1];
        //设置数组的默认值是最大，默认是都不可达
        Arrays.fill(dist, Integer.MAX_VALUE);
        //起始节点的耗时为0
        dist[init] = 0;
        //记录当前节点到起始点的花费时长，升序排列[当前节点， 起始点到当前节点的耗时]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{init, 0});

        //bfs,开始遍历
        while(!pq.isEmpty()){
            //获取局部最优解
            int[] poll = pq.poll();
            //获取当前节点
            int point = poll[0];
            int costTime = poll[1];
            //如果当前节点已经有了最优解，则跳过
            if(shorts[point]){
                continue;
            }
            /**
             * 没有开始寻找，这里先将标识位设置为true，然后开始寻找
             * */
            shorts[point] = true;
            //获取当前节点可以传染的所有下级电脑
            if(map.containsKey(point)){
                List<int[]> listPoints = map.get(point);
                for (int[] pointArr : listPoints) {
                    /**
                     * 将当前节点到下一个节点的时间进行累加
                     * */
                    int end = pointArr[0];
                    int time = pointArr[1];
                    int allTime = costTime + time;

                    //更新起始电脑到这个下级电脑感染所需要的时间,但不一定是最短时间（还需要看后期是否会有更新）
                    if(dist[end] > allTime){
                        dist[end] = allTime;
                        //添加到优先队列中，这样最后队列中没有值了那么数组dist中各个电脑的耗时就是最短的
                        pq.add(new int[]{end, allTime});
                    }
                }
            }
        }
        /**
         * 这里不能直接排序获取最后的值，因为我们的0索引是没有使用的，如果排序获取最后一个值
         * 会造成永远都是-1，所以我们获取最大的时候忽略与索引0的比对，或者我们也可以排序，但是
         * 获取值的时候要拿倒数第二个，因为如果存在没感染的电脑那么就会存在多个 Integer.MAX_VALUE
         * 如果都可达，那么我们直接获取倒数第二位的值即可，这样也可以避免获取到索引0的最大值
         * */
        int maxTime = 0;
        for (int i = 1; i < dist.length; i++) {
            if(maxTime < dist[i]){
                maxTime = dist[i];
            }
        }
        /**
         * 因为可能存在不会被感染的电脑，所以要进行判定，如果是Integer.MAX_VALUE
         * 那么说明有正常的电脑输出-1,否则正常输出最大耗时
         * */
        maxTime  = maxTime == Integer.MAX_VALUE ? -1 : maxTime;
        System.out.println(maxTime);
    }
}
