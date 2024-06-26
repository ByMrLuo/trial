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
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer, Map<String, List<Integer>>> allAreaMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                if(val != 0){
                    Map<String, List<Integer>> areaMap = allAreaMap.getOrDefault(val, new HashMap<String, List<Integer>>());

                    List<Integer> row = areaMap.getOrDefault("row", new ArrayList<Integer>());
                    row.add(i);
                    List<Integer> line = areaMap.getOrDefault("line", new ArrayList<Integer>());
                    line.add(j);

                    areaMap.put("row", row);
                    areaMap.put("line", line);
                    allAreaMap.put(val, areaMap);
                }
            }
        }
        int maxArea = 0;
        for (Map.Entry<Integer, Map<String, List<Integer>>> entry : allAreaMap.entrySet()) {
            Map<String, List<Integer>> areaMap = entry.getValue();
            List<Integer> rowList = areaMap.get("row");
            Collections.sort(rowList);
            List<Integer> lineList = areaMap.get("line");
            Collections.sort(lineList);
            int row = rowList.get(rowList.size() - 1) - rowList.get(0) + 1;
            int line = lineList.get(lineList.size() -1) - lineList.get(0) + 1;
            maxArea = Math.max(maxArea, row * line);
        }

        System.out.println(maxArea);
    }
}
