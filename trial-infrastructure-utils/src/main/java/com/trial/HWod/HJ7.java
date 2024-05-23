package com.trial.HWod;

import java.util.*;
import java.util.stream.Stream;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-05-23 18:59
 **/
public class HJ7 {

    /**
     * 题目描述
     * 从前有个村庄，村民们喜欢在各种田地上插上小旗子，旗子上标识了各种不同的数字。
     * 某天集体村民决定将覆盖相同数字的最小矩阵形的土地分配给村里做出巨大贡献的村民，请问此次分配土地，做出贡献的村民种最大会分配多大面积?
     * 输入描述
     * 第一行输入 m 和 n，
     *     m 代表村子的土地的长
     *     n 代表土地的宽
     * 第二行开始输入地图上的具体标识
     * 输出描述
     * 此次分配土地，做出贡献的村民种最大会分配多大面积
     * 备注
     *     旗子上的数字为1~500，土地边长不超过500
     *     未插旗子的土地用0标识
     * 用例1
     * 输入
     * 3 3
     * 1 0 1
     * 0 0 0
     * 0 1 0
     * 输出
     * 9
     * 说明
     *     土地上的旗子为1，其坐标分别为(0,0)，(2,1)以及(0,2)，为了覆盖所有旗子，矩阵需要覆盖的横坐标为0和2，纵坐标为0和2，所以面积为9，即（2-0+1）*（2-0+1）= 9
     *
     * 用例2
     * 输入
     * 3 3
     * 1 0 2
     * 0 0 0
     * 0 3 4
     * 输出
     * 1
     *
     * 说明
     *     由于不存在成对的小旗子，故而返回1，即一块土地的面积。
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Integer, List<List<Integer>>> map = new HashMap();
        int row = 0;
        int line =  0;
        int maxArea = 1;
        while(row < m){
            int point = scanner.nextInt();
            if(point != 0){
                if(map.containsKey(point)){
                    List<List<Integer>> peoplePoint = map.get(point);
                    List<Integer> lList = peoplePoint.get(0);
                    lList.add(line);
                    List<Integer> wList  = peoplePoint.get(1);
                    wList.add(row);
                }else{
                    List<List<Integer>> pointList  = new ArrayList<>();
                    //存放所有列坐标
                    List<Integer> lList  = new ArrayList<>();
                    //存放所有行坐标
                    List<Integer> wList  = new ArrayList<>();
                    lList.add(line);
                    wList.add(row);
                    pointList.add(lList);
                    pointList.add(wList);
                    map.put(point ,pointList);
                }
            }
            line++;
            if(line == n){
                row++;
                line = 0;
            }
        }
        Set<Integer> keySet = map.keySet();
        for(Integer key: keySet){
            List<List<Integer>> peoplePoint = map.get(key);
            int l = 1;
            int w = 1;
            List<Integer> lList = peoplePoint.get(0);
            List<Integer> wList = peoplePoint.get(1);
            Collections.sort(lList);
            Collections.sort(wList);
            l = lList.get(lList.size()-1) - lList.get(0)+1;
            w = wList.get(wList.size()-1) - wList.get(0)+1;
            maxArea = Math.max(maxArea, l * w);
        }
        System.out.println(maxArea);
    }
}
