package com.trial.HWod;

import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2024-06-04 16:57
 **/
public class HJ38 {
    /**
     * 题目描述
     *
     * ​智能手机方便了我们生活的同时，也侵占了我们不少的时间。
     *
     * “手机App防沉迷系统”能够让我们每天合理地规划手机App使用时间，在正确的时间做正确的事。
     *
     * 它的大概原理是这样的：
     *     在一天24小时内，可以注册每个App的允许使用时段 image
     *     一个时间段只能使用一个App，举例说明：不能同时在9:00-10:00注册App2和App3 image
     *     App有优先级，数值越高，优先级越高。注册使用时段时，如果高优先级的App时间和低优先级的时段有冲突，则系统会自动注销低优先级的时段，如果App的优先级相同，则后添加的App不能注册。 举例1： (1) 注册App3前 image (2) App3注册时段和App2有冲突 image (3) App3优先级高，系统接受App3的注册，自动注销App2的注册 image 举例2： (1) 注册App4 image (2) App4和App2及App3都有冲突，优先级比App2高，但比App3低，这种场景下App4注册不上，最终的注册效果如下 image
     *     一个App可以在一天内注册多个时段 image
     * 请编程实现，根据输入数据注册App，并根据输入的时间点，返回时间点使用的App名称，如果该时间点没有注册任何App，请返回字符串“NA”。
     * 输入描述
     * 第一行表示注册的App数量 N（N ≤ 100）
     * 第二部分包括 N 行，每行表示一条App注册数据
     * 最后一行输入一个时间点，程序即返回该时间点使用的App
     *     2
     *     App1 1 09:00 10:00
     *     App2 2 11:00 11:30
     *     09:30
     * 数据说明如下：
     *     N行注册数据以空格分隔，四项数依次表示：App名称、优先级、起始时间、结束时间
     *     优先级1~5，数字越大，优先级越高
     *     时间格式 HH:MM，小时和分钟都是两位，不足两位前面补0
     *     起始时间需小于结束时间，否则注册不上
     *     注册信息中的时间段包含起始时间点，不包含结束时间点
     * 输出描述
     * 输出一个字符串，表示App名称，或NA表示空闲时间
     * 备注
     *     用例保证时间都介于 00:00 - 24:00 之间；
     *     用例保证数据格式都是正确的，不用考虑数据输入行数不够、注册信息不完整、字符串非法、优先级超限、时间格式不正确的问题；
     *
     * 用例1
     * 输入
     * 1
     * App1 1 09:00 10:00
     * 09:30
     *
     * 输出
     * App1
     *
     * 说明
     *     App1注册在9点到10点间，9点半可用的应用名是App1
     *
     * 用例2
     * 输入
     * 2
     * App1 1 09:00 10:00
     * App2 2 09:10 09:30
     * 09:20
     *
     * 输出
     * App2
     *
     * 说明
     *     App1和App2的时段有冲突，App2优先级高，注册App2之后，App1自动注销，因此输出App2。
     *
     * 用例3
     * 输入
     * 2
     * App1 1 09:00 10:00
     * App2 2 09:10 09:30
     * 09:50
     *
     * 输出
     * NA
     * */
    static class APP{
        String name;
        int weight;
        int begin;
        int end;
        APP(String name, int weight){
            this.name = name;
            this.weight = weight;
        }
        APP(String name, int weight, int begin, int end){
            this.name = name;
            this.weight = weight;
            this.begin = begin;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();

        String[] str = new String[number];
        for(int i = 0; i < number; i++){
            str[i] = scanner.nextLine();
        }

        String timeStr = scanner.nextLine();
        //使用的时间
        int useTime = toMinute(timeStr);
        List<APP> apps = new ArrayList<>();
        out:
        for (String s : str) {
            String[] arrs = s.split(" ");
            String name = arrs[0];
            Integer weight = Integer.valueOf(arrs[1]);
            APP app = new APP(name, weight);
            int begin = toMinute(arrs[2]);
            int end  = toMinute(arrs[3]);
            //开始小于结束注册不上
            if(begin > end){
               continue;
            }
            app.begin = begin;
            app.end = end;
            //是否注册成功
            ArrayList<APP> deleteList = new ArrayList<>();
            for (int i = 0; i < apps.size(); i++) {
                APP ap = apps.get(i);
                if(ap.begin >= end || ap.end <= begin){
                    continue;
                }
                if(ap.weight < weight){
                    deleteList.add(ap);
                }else{
                    //如果重叠了，但是当前的app优先级低于之前的，则注册失败
                    //还要初始化deleteList;
                    deleteList.clear();
                    continue out;
                }
            }
            //因为我们添加的时候,他的索引是升序排列，所以删除的时候为了不改变他前面索引的位置我们
            //倒序移除数据
            for(APP ap : deleteList){
                apps.remove(ap);
            }
            //添加优先级更高的
            apps.add(app);
        }
        //最终apps里面只会剩下一个符合条件的，那么其他的begin和end都应该是0才对
        for (APP app : apps) {
            if(app.begin <= useTime && app.end > useTime){
                System.out.println(app.name);
                return;
            }
        }
        System.out.println("NA");
    }
    private static int toMinute(String time){
        String[] split = time.split(":");
        Integer hour = Integer.valueOf(split[0]);
        Integer minute = Integer.valueOf(split[1]);

        return hour * 60 + minute;
    }
}
