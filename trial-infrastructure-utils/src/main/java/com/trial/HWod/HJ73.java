package com.trial.HWod;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-13 00:13
 **/
public class HJ73 {
    /**
     *
     * */
    /**
     * 思路正确，但是这里的移除操作在数据量很大的时候会出现超时，所以修改方式不再移除，改为双指针
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] peopleArrs = new int[number];
        for (int i = 0; i < number; i++) {
            peopleArrs[i] = scanner.nextInt();
        }
        //最低能力要求
        int min = scanner.nextInt();
        int maxTeam = 0;
        //升序排序
        Arrays.sort(peopleArrs);
        int left = 0;
        int right = number - 1;
        /**找出所有一人一对的，缩小右边界*/
        while(right >= 0 && peopleArrs[right] >= min){
            right--;
            maxTeam++;
        }
        /**找出所有两人一队的*/
        while(left < right){
            int sum = peopleArrs[right] + peopleArrs[left];
            //如果两个人相加刚好大于等于min那么缩小左右边界，如果小于则缩小左边界，找更大的
            if(sum >= min){
                right--;
                maxTeam++;
            }
            left++;
        }
        System.out.println(maxTeam);
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < number; i++) {
//            list.add(scanner.nextInt());
//        }
//        //最低能力要求
//        int min = scanner.nextInt();
//        int maxTeam = 0;
//        //升序排序
//        Collections.sort(list);
//        /**大于最低要求的自己一队，小于的进行组队两两组队，
//         * 先一人一队，后两人一队，数量达到最大
//         * 循环一：不满足一个人时，一人一对跳出循环
//         * list.size() >= 1 避免空指针的出现 && list.peekLast() >= min，只循环一人一队的
//         * 循环二：不满足两个人一队的时候，跳出循环
//         *
//         * */
//        while(list.size() >= 1 && list.peekLast() >= min){
//            //从后开始找，将一人一队的全部移除
//            list.removeLast();
//            maxTeam++;
//        }
//        while(list.size() >= 2){
//            //走到这里的都是两两组队的
//            Integer first = list.peekFirst();
//            Integer last = list.peekLast();
//            /**
//             * 不符合只移除最小的因为，最小的和最大的不匹配，那么就永远没有合适的
//             * 但是最大的还可以和其他小的匹配
//             * */
//            if(first + last < min){
//                list.removeFirst();
//            }else{
//                //一旦符合，移除头和尾 并+1
//                maxTeam++;
//                list.pollFirst();
//                list.pollLast();
//            }
//        }
//        System.out.println(maxTeam);
//    }
}
