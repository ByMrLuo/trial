package com.trial.HWod;

import java.util.*;

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
    static class Student{
        String name;
        int[] results;

        Student(String name, int[] results){
            this.name = name;
            this.results = results;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n个人，m个课程
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        /**所有课程*/
        String str = scanner.nextLine();
        String[] clazzs = str.split(" ");

        ArrayList<Student> sortStudents = new ArrayList<>();
        /**读取每个人的各科成绩*/
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] sArrs = s.split(" ");
            //这里之所以还是这个长度，是因为结果我们放了一个总分数在最后
            int[] results = new int[sArrs.length];
            int sum = 0;
            for (int j = 1; j < sArrs.length; j++) {
                results[j - 1] = Integer.valueOf(sArrs[j]);
                sum += results[j - 1];
            }
            /**总分数放在最后*/
            results[sArrs.length -1] = sum;
            //sArrs[0]是姓名
            Student student = new Student(sArrs[0], results);
            sortStudents.add(student);
        }
        /**读取排序的课程*/
        String clazz = scanner.nextLine();
        /**
         * 默认排序的成绩是总成绩，如果有对应匹配的就会转化为对应的课程下标索引
         * 如果没有就是按总成绩，总成绩在results成绩数组最后一个元素也就是课程长度的位置
         * */
        int index = clazzs.length;
        for (int i = 0; i < clazzs.length; i++) {
            if(clazz.equals(clazzs[i])){
                index = i;
            }
        }
        /**
         * 因为匿名表达式里面的不能是变量，需要一个常量，所以这里才有复制这一步
         * */
        int sortIntdex = index;
        /**按照对应的课程成绩下标索引升序，分数相等按照名字字典顺序排序*/
        Collections.sort(sortStudents, (a,b)-> a.results[sortIntdex] == b.results[sortIntdex] ?
                a.name.compareTo(b.name) :
                b.results[sortIntdex]- a.results[sortIntdex]);
        StringJoiner sj = new StringJoiner(" ");
        for (Student student : sortStudents) {
            sj.add(student.name);
        }
        System.out.println(sj.toString());
    }
}
