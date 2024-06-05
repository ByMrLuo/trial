package com.trial.HWod;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

import static java.lang.Math.max;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-05 17:40
 **/
public class HJ41 {
    /**
     * 题目描述
     * 每个方块代表一个像素，每个像素用其行号和列号表示。
     * 为简化处理，多线段的走向只能是水平、竖直、斜向45度。
     * 上图中的多线段可以用下面的坐标串表示：(2,8),(3,7),(3,6),(3,5),(4,4),(5,3),(6,2),(7,3),(8,4),(7,5)。
     * 但可以发现，这种表示不是最简的，其实只需要存储6个蓝色的关键点即可，它们是线段的起点、拐点、终点，而剩下4个点是冗余的。
     * 现在，请根据输入的包含有冗余数据的多线段坐标列表，输出其最简化的结果。
     * 输入描述
     *     2 8 3 7 3 6 3 5 4 4 5 3 6 2 7 3 8 4 7 5
     *     所有数字以空格分隔，每两个数字一组，第一个数字是行号，第二个数字是列号；
     *     行号和列号范围 为 [0, 64)，用例输入保证不会越界，考生不必检查；
     *     输入数据至少包含两个坐标点
     * 输出描述
     *     2 8 3 7 3 5 6 2 8 4 7 5
     * 压缩后的最简化坐标列表，和输入数据的格式相同。
     * 备注
     * 输出的坐标相对顺序不能变化
     * 用例1
     * 输入
     * 2 8 3 7 3 6 3 5 4 4 5 3 6 2 7 3 8 4 7 5
     *
     * 输出
     * 2 8 3 7 3 5 6 2 8 4 7 5
     *
     * 说明
     *     如上图所示，6个蓝色像素的坐标依次是：
     *     (2, 8)、(3, 7)、(3, 5)、(6, 2)、(8, 4)、(7, 5)
     *     将他们按顺序输出即可。
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] sArrs = s.split(" ");
        //记录上一个点的坐标
        StringBuffer sb = new StringBuffer();
        int preRow = Integer.valueOf(sArrs[0]);
        int preLine = Integer.valueOf(sArrs[1]);
        //记录运动方向
        int toRow = 0;
        int toLine = 0;
        for(int i = 2; i < sArrs.length; i++){
            int row = Integer.valueOf(sArrs[i]);
            int line = Integer.valueOf(sArrs[++i]);
            //计算和上一点的差值
            int m = row - preRow;
            int n = line - preLine;
            int base =  Math.max(Math.abs(m), Math.abs(n));
            int baseRow = m / base;
            int baseLine = n / base;

            //方向相同直接开始下一个点，不同则记录拐点
            if(baseRow != toRow || baseLine != toLine){
                sb.append(preRow);
                sb.append(" ");
                sb.append(preLine);
                sb.append(" ");
            }
            //记录上一个点
            preRow = row;
            preLine = line;
            toRow = baseRow;
            toLine = baseLine;
        }
        sb.append(preRow);
        sb.append(" ");
        sb.append(preLine);
        System.out.println(sb.toString());
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String[] sArrs = s.split(" ");
//        //记录上一个点的坐标
//        StringBuffer sb = new StringBuffer();
//        int preRow = Integer.valueOf(sArrs[0]);
//        int preLine = Integer.valueOf(sArrs[1]);
//
//
//        int preToRow = 0;
//        int preToLine = 0;
//        for(int i = 2; i < sArrs.length; i++){
//            int row = Integer.valueOf(sArrs[i]);
//            int line = Integer.valueOf(sArrs[++i]);
//
//            int r = row - preRow;
//            int l = line - preLine;
//
//
//            if((preToRow ==0 && preToLine == 0) || preToRow * l - preToLine * r != 0){
//                /**
//                 * 向量x1y2-x2y1=0证明两个向量共线
//                 * 不共线说明方向改变了
//                 * */
//                    sb.append(preRow);
//                    sb.append(" ");
//                    sb.append(preLine);
//                    sb.append(" ");
//
//            }else if(preToRow * l - preToLine * r == 0 && preToRow*r + preToLine *l < 0){
//                /**
//                 * 共线但是反向也要打印 不能使用(x1,y1)=m(x2,y2)的方式因为如果存在0的情况,会有异常
//                 */
//                sb.append(preRow);
//                sb.append(" ");
//                sb.append(preLine);
//                sb.append(" ");
//            }
//
//            preRow = row;
//            preLine = line;
//            preToRow = r;
//            preToLine = l;
//        }
//        sb.append(preRow);
//        sb.append(" ");
//        sb.append(preLine);
//        System.out.println(sb.toString());
//    }
}
