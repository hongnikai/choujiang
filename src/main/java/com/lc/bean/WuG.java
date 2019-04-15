package com.lc.bean;
/**
 *  @描述： 创建一个乌龟类
 *    ps： 跑的慢
 ** @author LC
 *  创建时间：2018-8-8 下午23:30
 */
public class WuG implements Runnable{

    private static final String name = "mark";    //姓名  mark

    private static int milters;                   //起跑时距离起点的距离

    Thread thread = new Thread();
    @Override
    public void run() {
        milters = 50;

        for (int i=1;i<=100;i++){     //100秒
            try {
                thread.currentThread().sleep(1000);    //每秒一睡
            } catch (InterruptedException e) {
                System.out.println("sorry 线程阻塞");
                e.printStackTrace();
            }
            System.out.println("mark每秒跑了："+(milters+=5)+"米");
        }
    }
}
