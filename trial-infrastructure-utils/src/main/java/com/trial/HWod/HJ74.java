package com.trial.HWod;

import java.util.*;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-13 01:18
 **/
public class HJ74 {
    /**
     *
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        //构建一个优先队列，按照人员身高进行升序排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        //记录谁是自己朋友的数组
        int[] indexs = new int[num];
        for (int i = 0; i < num; i++) {
            //获取输入的身高和他自己的索引，添加到队列
            int height = scanner.nextInt();
            /**
             * 将队列中的存在的和后面输入的值进行比对，
             * 有比自己高的的就出栈将自己数组peek[0]中拿到自己的索引，然后
             * 去改变indexs数组中对应位置的值，改成配对成功的索引
             * */
            while(!pq.isEmpty()){
                int[] peek = pq.peek();
                if(peek[1] < height){
                    int index = peek[0];
                    indexs[index] = i;
                    pq.poll();
                }else{
                    break;
                }
            }
            /**
             * 然后将每次后输入的入队列等待更后面的来配对
             * 直到全部结束，这样就表示我们配对完成
             * */
            int[] heightAndIndex = new int[]{i, height};
            pq.add(heightAndIndex);
        }
        /**
         * 遍历输出对应的位置的数据
         * */
        StringJoiner sj = new StringJoiner(" ");
        for (int index : indexs) {
            sj.add(String.valueOf(index));
        }
        System.out.println(sj.toString());
    }
    /**
     * 这种做法固然是避免了多次扫描数组中的重复数据，但同样你在弹栈的时候也需要依次遍历栈，
     * 而且实现较for循环，更为复杂，效率尚不明确，还是推荐双层for
     * */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        int[] tallArrs = new int[number];
//        for (int i = 0; i < number; i++) {
//            tallArrs[i] = scanner.nextInt();
//        }
//        Deque<int[]> queue = new LinkedList<int[]>();
//        int[] newArrs = new int[number];
//        int index = 0;
//        while(index < number){
//            int[] firstArrs = queue.peekFirst();
//            //判定队列首位元素是否大于当前元素，如果大于则将他放入队首，否则，这就是队首元素的朋友
//            //将队首弹出队列，并修改队首索引所在新数组的值，改为index也就是大于他的这个索引
//            if(firstArrs == null || firstArrs[0]  >= tallArrs[index]){
//                queue.addFirst(new int[]{tallArrs[index], index});
//                index++;
//                continue;
//            }
//            //找到队首元素所在的索引位置，将值改为当前元素的index；
//            newArrs[firstArrs[1]] = index;
//            //找到了朋友，队首则直接出占，但是还需要和后续的比较是否大于新的队首，
//            // 所以这里不index++，直到
//            queue.pollFirst();
//        }
//        StringJoiner sj = new StringJoiner(" ");
//        for (int newArr : newArrs) {
//            sj.add(String.valueOf(newArr));
//        }
//        System.out.println(sj.toString());
//    }

}
