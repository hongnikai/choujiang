package com.lc.controller.task;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import com.lc.dao.NormalDao;
import com.lc.service.NormalService;
import com.lc.service.TaskService;
import com.lc.service.impl.TaskServiceImpl;
import com.lc.task.MyTimerTask;
import com.lc.util.TimeUtil;
import com.lc.util.UploadUtil;
import com.lc.util.lcRamdomUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.TimerTask;


/**
 *  @描述：定时器  专用   上线专用
 *    ps： 发起执行
 ** @author LC
 *  创建时间：2018-8-26 下午22:02
 */
@RestController
@Scope(value="prototype")
@RequestMapping("taskController")
public class TaskController extends java.util.Timer{

    // 日志记录器
    public final Logger log = Logger.getLogger(this.getClass());

     public static long time =1111111;

    @Autowired
    private NormalService normalService;

    @Autowired
    private NormalDao normalDao;

    String p_id="";     //奖品id
    int p_num=0;          //奖品数量
    int man_num=0;       //中奖人数



    /**
     * task:实现的定时任务 delay:项目启动制定时间后开始执行任务 period:没有执行定时任务的间隔时间
     * 如果Task执行时间过长；会导致period执行任务延期
     */
    public void schedule(TimerTask task, long delay, long period) {
        super.schedule(task, delay, period);
    }

    /**
     * 接口启动定时任务：     开始抽奖了
     *
     * @param
     * @throws Exception
     */
     @RequestMapping("create_CJ")
     public Object create_CJ(HttpServletRequest request ,HttpServletResponse response,
                             @RequestParam(value = "open_id",required = true)String open_id,
                             @RequestParam(value="p_name",required=false,defaultValue="0")String p_name,
                             @RequestParam(value="num",required=false,defaultValue="1")int num,
                             @RequestParam(value = "manNum",required = false,defaultValue = "0")int manNum,
                             @RequestParam(value="time",required=false,defaultValue="2018-09-02 17:52:30")String time,
                             @RequestParam(value = "file", required = false,defaultValue = "0") MultipartFile file
                            ) throws Exception {
         //清除过期数据
         normalService.deletePriceOutOfTime(TimeUtil.getSystemTimeFormart());
         normalService.delectPriceOrderNotInPrice();

         //新建奖品
         UploadUtil u=new UploadUtil();
         TimeUtil t=new TimeUtil();
         String detail_path="/pictures/"+open_id;
         String pics=u.uploadFilesToPath(request, file, detail_path);

         man_num =manNum;
         System.out.println("人数为："+man_num);

         p_num=num;
         System.out.println("奖品数为："+p_num);

         p_id=lcRamdomUtil.getSixPlusTimeStampRamdomString();
         Map<String,Object> map=new HashMap<String,Object>();
         map.put("p_id", p_id);
         map.put("open_id",open_id);
         map.put("img",pics);
         map.put("p_name",p_name);
         map.put("p_num",p_num);
         map.put("man_num",man_num);
         map.put("p_condition",2);
         map.put("time",time);
         map.put("order_state",0);
         normalService.createPrice(map);
         System.out.println(open_id+p_name+p_num+man_num+time);
         //先执行创建奖品的过程，再执行定时修改任务

         Map<String,Object> map2 =new HashMap<String, Object>();
         map2.put("p_id",p_id);
         map2.put("open_id",open_id);
         map2.put("create_time",TimeUtil.getSystemTimeFormart());
         map2.put("order_state",0);
         map2.put("win_num",0);
         normalDao.createPriceOrderByOpenid(map2);
         Map<String,Object> map3 =new HashMap<String, Object>();
         map3.put("p_id",p_id);
         map3.put("open_id",open_id);
         map3.put("create_time",TimeUtil.getSystemTimeFormart());
         map3.put("order_state",0);
         map3.put("win_num",0);
         normalDao.createPriceOrderByOpenid(map3);

         Timer timer =new Timer();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         ParsePosition pos = new ParsePosition(0);
         Date strtodate = formatter.parse(time, pos);
         timer.schedule(new MyTask(), strtodate);

//         while(true){//这个是用来停止此任务的,否则就一直循环执行此任务
//             try{
//                 int in = System.in.read();
//                 if(in == 's'){
//                     timer.cancel();//使用这个方法退出任务
//                     break;
//                 }
//             } catch (IOException e){
//                 // TODO Auto-generated catch block
//                 log.error(e.getMessage(), e);
//                 e.printStackTrace();
//             }
//         }
         return pics;
     }

    List<Map<String,Object>> list;


    class MyTask extends java.util.TimerTask{   //内部类调用全局变量

        public void run(){//时间截至开始公布中奖名单，并发起推送
            System.out.println("开始抽奖了");

            normalService.updataPriceOrderState1ByPid(p_id);
            System.out.println("修改了奖品的状态order_state =1 已开奖,下面开始随机生成中奖名单");

            Map<String,Object> map =new HashMap<String,Object>();
            map.put("p_id",p_id);
            map.put("man_num",man_num);  //抽取man_num个  申请的订单
            list = normalDao.selectRandmPriceOrderWin(map);
            //查询出全部中奖申请订单
            if(list.size()==0){
                //如果申请人数为0  ，不进行抽奖
                System.out.println("参与抽奖人数为0");
            }else if(list.size()<man_num){  //参与抽奖人数小于  中奖人数   奖品轮空逻辑
                System.out.println("参与人数不够，剩余奖品将按顺序分发");
                int a=list.size();
                minMethod(p_num,a);
            }else{//正常抽奖
                System.out.println("进入抽奖过程");
                mathMethod(p_num,man_num);   //开始执行抽奖
            }

        }
        //奖品多的情况下发放奖品
        public  void  minMethod(int p_num,int a){
            int result = (p_num/a);  //取整
            int res = (p_num%a);
            switch (res) {
                case 0:
                    System.out.println("正好整除，每个人分得："+result+"个");
                    for (int i=0;i<a;i++){
                        int p_order_id =(int)list.get(i).get("p_order_id");  //额外获得均分后剩余奖品的订单id
                        int win_num=0;   //初始为0
                        win_num+=result;
                        normalService.updateUserWinPriceOrder(p_order_id,win_num);//分发奖品
                    }
                    break;
                default:
                    //初始为0
                    System.out.println("不能整除，每个人分得："+result+"个");
                    for (int i=0;i<list.size();i++){
                        int p_order_id =(int)list.get(i).get("p_order_id");  //额外获得均分后剩余奖品的订单id
                        normalService.updateUserWinPriceOrder(p_order_id,result);//分发奖品
                    }
                    //从中奖订单中再循环
                    for(int i=0;i<res ;i++){
                        int p_order_id =(int)list.get(i).get("p_order_id");  //额外获得均分后剩余奖品的订单id
                        int b=result;
                        b+=1; //获取奖品数加1
                        System.out.println("获得中奖订单id为:"+p_order_id+"获取中奖订单奖品数为"+b+"获取剩余奖品数：---"+res+"个");
                        normalService.updateUserWinPriceOrder(p_order_id,b);  //分发剩余奖品
                    }
                    break;
            }
        }


        //执行抽奖过程
        public void mathMethod(int p_num,int man_num){
            System.out.println("执行抽奖过程");
            int result =  (p_num/man_num); //取余
            int res =(p_num%man_num);
            System.out.println(result);
            switch (res) {
                case 0:
                    System.out.println("正好整除，每个人分得："+result+"个");
                        //中奖结果+1
                        for (int i=0;i<list.size();i++){
                            int p_order_id =(int)list.get(i).get("p_order_id");  //额外获得均分后剩余奖品的订单id
                            int win_num=0;   //初始为0
                            win_num+=result;
                            normalService.updateUserWinPriceOrder(p_order_id,win_num);//正好整除，分发奖品
                        }
                    break;
                default:
                    //一下逻辑有望参考，如开启 高级抽奖后，分奖不均匀的判定
//                    System.out.println("每个人分得:"+result+"个");
//                    System.out.println("剩余:"+res+"个将按照随机分配");
//                    //每人分得result个奖品后进入修改
//                    for (int i=0;i<list.size();i++){
//                        int p_order_id =(int)list.get(i).get("p_order_id");  //额外获得均分后剩余奖品的订单id
//                        int win_num=0;   //初始为0
//                        win_num+=result;
//                        normalService.updateUserWinPriceOrder(p_order_id,win_num);//分发奖品
//                    }
//                    //从中奖订单中再循环
//                    for(int i=0;i<res ;i++){
//                        int p_order_id =(int)list.get(i).get("p_order_id");  //额外获得均分后剩余奖品的订单id
//                        int win_num =  (int)list.get(i).get("win_num");      //中奖的奖品数
//                        System.out.println("获得中奖订单id为:"+p_order_id+"获取中奖订单奖品数为"+win_num);
//                        win_num+=1; //获取奖品数加1
//                        normalService.updateUserWinPriceOrder(p_order_id,win_num);  //分发剩余奖品
//                    }
                    break;
            }

        }




    }














//    @ResponseBody
//    @RequestMapping("create_cj_test")
//    public Object create_cj_test()throws Exception {
//        String time111="2018-8-27 22:52:40";   //抽奖截止时间
//        TimeUtil t =new TimeUtil();
//        time=t.getRequestTimeStampLong(time111); //获取开奖的固定时间
//        taskService.job1(time);
//
//         return "抽奖结束";
//    }



    public TaskController(){}

    public TaskController(long time)
    {
        this.time =time;
    }

}
