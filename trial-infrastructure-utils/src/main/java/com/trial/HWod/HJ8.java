package com.trial.HWod;

import java.lang.reflect.GenericDeclaration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-24 15:54
 **/
public class HJ8 {
    /**
     * 题目描述
     * 小明来到某学校当老师，需要将学生按考试总分或单科分数进行排名，你能帮帮他吗？
     * 输入描述
     *
     * 第 1 行输入两个整数，学生人数 n 和科目数量 m。
     *
     *     0 < n < 100
     *     0 < m < 10
     *
     * 第 2 行输入 m 个科目名称，彼此之间用空格隔开。
     *
     *     科目名称只由英文字母构成，单个长度不超过10个字符。
     *     科目的出现顺序和后续输入的学生成绩一一对应。
     *     不会出现重复的科目名称。
     *
     * 第 3 行开始的 n 行，每行包含一个学生的姓名和该生 m 个科目的成绩（空格隔开）
     *
     *     学生不会重名。
     *     学生姓名只由英文字母构成，长度不超过10个字符。
     *     成绩是0~100的整数，依次对应第2行种输入的科目。
     *
     * 第n+2行，输入用作排名的科目名称。若科目不存在，则按总分进行排序。
     * 输出描述
     * 输出一行，按成绩排序后的学生名字，空格隔开。成绩相同的按照学生姓名字典顺序排序。
     * 用例1
     * 输入
     * 3 2
     * yuwen shuxue
     * fangfang 95 90
     * xiaohua 88 95
     * minmin 100 82
     * shuxue
     *
     * 输出
     * xiaohua fangfang minmin
     * 说明
     *     按shuxue成绩排名，依次是xiaohua、fangfang、minmin
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleNum = scanner.nextInt();
        int classNum = scanner.nextInt();
        scanner.nextLine();
        String className = scanner.nextLine();
        String[] classNameArrays = className.split(" ");
        int n = 0;
        //list<<学生姓名，成绩>>
        List<Map<String, Integer>> lists = new ArrayList<>();

        for (int i = 0; i < classNum; i++){
            Map<String, Integer> peopleNameAndResult = new HashMap();
            lists.add(peopleNameAndResult);
        }
        Map<String, Integer> sum = new HashMap();
        while(n < peopleNum){
            String peopleResult = scanner.nextLine();
            String [] resultArrs = peopleResult.split(" ");
            String peropleName = resultArrs[0];
            int count = 0;
            int length = resultArrs.length;
            for(int i = 1; i < length; i++){
                //获取对应科目的人员成绩目录
                Map<String, Integer> map = lists.get(i-1);
                //姓名及成绩
                Integer result = Integer.valueOf(resultArrs[i]);
                map.put(peropleName, result);
                count += result;
            }
            sum.put(peropleName, count);
            n++;
        }


        String sortClassName = scanner.nextLine();

        Map<String ,Integer> peopleMap = new HashMap<>();
        for(int i = 0; i < classNameArrays.length; i++){
            if(sortClassName.equals(classNameArrays[i])){
                peopleMap = lists.get(i);
            }
        }
        //降序 compare放1表示要交换位置 -1和0表示不交换位置
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o1.getKey().compareTo(o2.getKey()) ;
                }
                return o2.getValue() - o1.getValue();
            }
        };
        ArrayList<Map.Entry<String, Integer>> sort = null;
        if(peopleMap.isEmpty()){
            sort = new ArrayList<>(sum.entrySet());
        }else{
            sort = new ArrayList<>(peopleMap.entrySet());
        }
        Collections.sort(sort,comparator);
        for (Map.Entry entry: sort){
            System.out.print(entry.getKey() + " ");
        }
    }
}
