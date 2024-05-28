package com.trial.HWod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-28 17:23
 **/
public class HJ17 {
    /**
     * 题目描述
     * 有一个字符串数组 words 和一个字符串 chars。
     * 假如可以用 chars 中的字母拼写出 words 中的某个“单词”（字符串），那么我们就认为你掌握了这个单词。
     * words 的字符仅由 a-z 英文小写字母组成，例如 "abc"
     * chars 由 a-z 英文小写字母和 "?" 组成。其中英文 "?" 表示万能字符，能够在拼写时当作任意一个英文字母。例如："?" 可以当作 "a" 等字母。
     * 注意：每次拼写时，chars 中的每个字母和万能字符都只能使用一次。
     * 输出词汇表 words 中你掌握的所有单词的个数。没有掌握任何单词，则输出0。
     * 输入描述
     * 第一行：输入数组 words 的个数，记作N。
     * 第二行 ~ 第N+1行：依次输入数组words的每个字符串元素
     * 第N+2行：输入字符串chars
     * 输出描述
     * 输出一个整数，表示词汇表 words 中你掌握的单词个数
     * 备注
     *     1 ≤ words.length ≤ 100
     *     1 ≤ words[i].length, chars.length ≤ 100
     *     所有字符串中都仅包含小写英文字母、英文问号
     *
     * 用例1
     * 输入
     * 4
     * cat
     * bt
     * hat
     * tree
     * atach??
     *
     * 输出
     * 3
     * 说明
     *     可以拼写字符串"cat"、"bt"和"hat"
     *
     * 用例2
     * 输入
     * 3
     * hello
     * world
     * cloud
     * welldonehohneyr
     *
     * 输出
     * 2
     * 说明
     *     可以拼写字符串"hello"和"world"

     * 用例3
     * 输入
     * 3
     * apple
     * car
     * window
     * welldoneapplec?
     *
     * 输出
     * 2
     * 说明
     *     可以拼写字符串"apple"和“car”
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[number];
        for(int i = 0; i < number; i++){
            words[i] = scanner.nextLine();
        }

        String charStr = scanner.nextLine();
        char[] chars = charStr.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int questionNum = 0;
        for(char c : chars){
            if(charMap.containsKey(c)){
                Integer num = charMap.get(c);
                num++;
                charMap.put(c, num);
            }else{
                charMap.put(c, 1);
            }
        }
        int learn = 0;
        HashMap<Character, Integer> tempMap = new HashMap<>();
        tempMap.putAll(charMap);
        for(int i = 0; i < number; i++){
            boolean cantLearn = true;
            char[] charArray = words[i].toCharArray();
            for(char c : charArray){
                //判断是否包含这个字符如果包含数量-1，不包含看是否有？有则去问扣减万能
                //当没有字符且万能也不够的时候，跳出循环说明这个单词不会
                if(tempMap.containsKey(c)){
                    Integer num = tempMap.get(c);
                    if(num > 0){
                        num--;
                        tempMap.put(c, num);
                        continue;
                    }
                }
                if(tempMap.containsKey('?')){
                    //万能符抵扣
                    Integer j = tempMap.get('?');
                    //说明这个单词不会
                    if(j <= 0){
                        cantLearn = false;
                        break;
                    }
                    j--;
                    tempMap.put('?', j);
                }else {
                    cantLearn = false;
                }

            }
            if(cantLearn){
                learn++;
            }
            //重新初始化
            tempMap = new HashMap<>();
            tempMap.putAll(charMap);
        }
        System.out.println(learn);
    }
}
