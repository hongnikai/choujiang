package com.lc.controller.task;

import com.lc.dao.NormalDao;
import com.lc.service.NormalService;
import com.lc.util.TimeUtil;
import com.lc.util.UploadUtil;
import com.lc.util.lcRamdomUtil;
import org.apache.log4j.Logger;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map;

/**
 *  @描述：定时器     特殊   伪中奖专用
 *    ps： 发起执行          王寅抽奖
 ** @author LC
 *  创建时间：2018-8-26 下午22:02
 */
@SuppressWarnings("all")
@RestController
@Scope(value="prototype")
@RequestMapping("special")
public class specialController extends java.util.Timer{

    // 日志记录器
    public final Logger log = Logger.getLogger(this.getClass());

    public static long time =1111111;

    String p_id="";     //奖品id
    int p_num=0;          //奖品数量
    int man_num=0;       //中奖人数


    @Autowired
    private NormalService normalService;

    @Autowired
    private NormalDao normalDao;

    public void schedule(TimerTask task, long delay, long period) {
        super.schedule(task, delay, period);
    }

    /**
     * 接口启动定时任务：     创建伪抽奖类
     *
     * @param
     * @throws Exception
     */
    @RequestMapping("create_CJ")
    public java.lang.Object create_CJ(HttpServletRequest request , HttpServletResponse response,
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

        p_id= lcRamdomUtil.getSixPlusTimeStampRamdomString();
        Map<String, java.lang.Object> map=new HashMap<String, java.lang.Object>();
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

        Timer timer =new Timer();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(time, pos);
        timer.schedule(new MyTask(), strtodate);

        return pics;
    }

    List<Map<String,Object>> list;


    class MyTask extends java.util.TimerTask{   //内部类调用全局变量

        public void run(){//时间截至开始公布中奖名单，并发起推送
            System.out.println("开始抽奖了");

            Map<String, java.lang.Object> map=new HashMap<String, java.lang.Object>();
            map.put("p_id",p_id);
            map.put("open_id","xxxxxx1");
            map.put("create_time",TimeUtil.getSystemTimeFormart());
            map.put("order_state",1);
            map.put("win_num",p_num/man_num);

            Map<String,java.lang.Object> map2=new HashMap<String,java.lang.Object>();
            map2.put("p_id",p_id);
            map2.put("open_id","xxxxxx2");
            map2.put("create_time",TimeUtil.getSystemTimeFormart());
            map2.put("order_state",1);
            map2.put("win_num",p_num/man_num);

            Map<String,java.lang.Object> map3=new HashMap<String,java.lang.Object>();
            map3.put("p_id",p_id);
            map3.put("open_id","xxxxxx3");
            map3.put("create_time",TimeUtil.getSystemTimeFormart());
            map3.put("order_state",1);
            map3.put("win_num",p_num/man_num);

            Map<String,java.lang.Object> map4=new HashMap<String,java.lang.Object>();
            map4.put("p_id",p_id);
            map4.put("open_id","xxxxxx4");
            map4.put("create_time",TimeUtil.getSystemTimeFormart());
            map4.put("order_state",1);
            map4.put("win_num",p_num/man_num);

            Map<String,java.lang.Object> map5=new HashMap<String,java.lang.Object>();
            map5.put("p_id",p_id);
            map5.put("open_id","xxxxxx5");
            map5.put("create_time",TimeUtil.getSystemTimeFormart());
            map5.put("order_state",1);
            map5.put("win_num",p_num/man_num);

            switch (man_num) {
                case 1:
                    normalDao.createPriceOrderByOpenid(map);
                    normalService.updataPriceOrderState1ByPid(p_id);
                    break;
                case 2:
                    normalDao.createPriceOrderByOpenid(map);
                    normalDao.createPriceOrderByOpenid(map2);
                    normalService.updataPriceOrderState1ByPid(p_id);
                    break;
                case 3:
                    normalDao.createPriceOrderByOpenid(map);
                    normalDao.createPriceOrderByOpenid(map2);
                    normalDao.createPriceOrderByOpenid(map3);
                    normalService.updataPriceOrderState1ByPid(p_id);
                    break;
                case 4:
                    normalDao.createPriceOrderByOpenid(map);
                    normalDao.createPriceOrderByOpenid(map2);
                    normalDao.createPriceOrderByOpenid(map3);
                    normalDao.createPriceOrderByOpenid(map4);
                    normalService.updataPriceOrderState1ByPid(p_id);
                    break;
                case 5:
                    normalDao.createPriceOrderByOpenid(map);
                    normalDao.createPriceOrderByOpenid(map2);
                    normalDao.createPriceOrderByOpenid(map3);
                    normalDao.createPriceOrderByOpenid(map4);
                    normalDao.createPriceOrderByOpenid(map5);
                    normalService.updataPriceOrderState1ByPid(p_id);
                    break;
                default:

                    break;
            }

        }

    }
}

