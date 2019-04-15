package com.lc.bean;
/**
 *  @描述： 创建一个小兔子类
 *    ps： 跑的快
 ** @author LC
 *  创建时间：2018-8-8 下午23:30
 */
public class Rabit implements Runnable{

    private static final String name = "john";  //姓名 约翰
    private static int milters;                 //起跑时距离起点的距离


    public int run(int speed) throws Exception{

        milters = 0;  //约翰的速度为;  每秒跑5米
        Thread thread = new Thread();

        for (int i=1;i<=100;i++){       //100米
            thread.currentThread().sleep(1000);     //每秒一睡
            System.out.println("john每秒跑了："+(milters+=5)+"米");
        }
        return (milters+=5);
    }

    @Override
    public void run() {

    }
}
