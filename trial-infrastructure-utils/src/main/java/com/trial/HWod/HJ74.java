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
        int number = scanner.nextInt();
        int[] tallArrs = new int[number];
        for (int i = 0; i < number; i++) {
            tallArrs[i] = scanner.nextInt();
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < number; i++) {
            for (int j = i+1; j < number; j++) {
                if(tallArrs[i] < tallArrs[j]){
                    sj.add(String.valueOf(j));
                    break;
                }
                if(j == number-1){
                    sj.add(String.valueOf(0));
                }
            }
            if(i == number-1){
                sj.add(String.valueOf(0));
            }
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
