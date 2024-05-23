package com.trial.HWod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-22 00:03
 **/
public class HJ1 {
    /**
     * 小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差 对他们进行排序，请帮他实现排序。
     * 输入描述：
     * 第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。 第二行为N个正整数H1-HN，分别是其他小朋友的身高，
     * 取值范围0<Hi<200（1<=i<=N），且N个正整数各不相同。
     * 输出描述：
     * 输出排序结果 ，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，
     * 如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
     * 补充说明：
     * 示例1
     * 输入：
     * 100 10
     * 95 96 97 98 99 101 102 103 104 105
     * 输出：
     * 99 101 98 102 97 103 96 104 95 105
     * 说明：
     * 小明身高100，班级学生10个，身高分别为95 96 97 98 99 101 102 103 104 105，
     * 按身高差排序后结果为：99 101 98 102 97 103 96 104 95 105。
     * 解题思路：考察对数组的理解和运用。
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            String[] arrs = a.split(" ");
            String[] bArrs = b.split(" ");
            int xiaoMingTall = Integer.valueOf(arrs[0]);

            ArrayList<Integer> lists = new ArrayList<>();
            for(int i =0; i< bArrs.length; i++){
                lists.add(Integer.valueOf(bArrs[i]));
            }
            //排序先将同学大小排好
            Comparator<Integer> comparator = new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    int n = Math.abs(xiaoMingTall - o1);
                    int m = Math.abs(xiaoMingTall - o2);

                    if(m != n){
                        //不相等的话绝对值小的靠前
                        return Integer.compare(n , m);
                    }else{
                        //绝对值中矮的靠前
                        return Integer.compare(o1,o2);
                    }

                }
            };
            Collections.sort(lists, comparator);
            System.out.println(lists);
        }
    }
}
